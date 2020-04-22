package com.demo.democommonlog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.core.annotation.SynthesizingMethodParameter;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/23.
 */
@Slf4j
@Aspect
@Configuration
@ConditionalOnProperty(value = "demo.log.enabled", havingValue = "true")
@Order(2)
@SuppressWarnings("all")
public class RequestLogAspect {

    private static final ParameterNameDiscoverer PARAMETER_NAME_DISCOVERER = new DefaultParameterNameDiscoverer();

    @Value("${demo.log.response.enabled:false}")
    private Boolean responseEnabled;

    @Value("${demo.log.request.enabled:false}")
    private Boolean requestEnabled;

    @Value("${demo.log.storage.enabled:false}")
    private Boolean storageEnabled;

    @Around(
            "(@within(org.springframework.stereotype.Controller) || " +
                    "@within(org.springframework.web.bind.annotation.RestController))"
    )
    public Object arountApi(ProceedingJoinPoint point) throws Throwable {
        String requestId = UUID.randomUUID().toString();
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        Object[] args = point.getArgs();
        // 请求参数处理
        final Map<String, Object> paraMap = new HashMap<>(16);
        for (int i = 0; i < args.length; i++) {
            // 读取方法参数
            MethodParameter methodParam = RequestLogAspect.getMethodParameter(method, i);
            // PathVariable 参数跳过
            PathVariable pathVariable = methodParam.getParameterAnnotation(PathVariable.class);
            if (pathVariable != null) {
                continue;
            }
            RequestBody requestBody = methodParam.getParameterAnnotation(RequestBody.class);
            Object value = args[i];
            // 如果是body的json则是对象
            if (requestBody != null && value != null) {
                paraMap.putAll(BeanMap.create(value));
                continue;
            }
            // 处理 List
            if (value instanceof List) {
                value = ((List) value).get(0);
            }
            // 处理 参数
            if (value instanceof HttpServletRequest) {
                paraMap.putAll(((HttpServletRequest) value).getParameterMap());
            } else if (value instanceof WebRequest) {
                paraMap.putAll(((WebRequest) value).getParameterMap());
            } else if (value instanceof MultipartFile) {
                MultipartFile multipartFile = (MultipartFile) value;
                String name = multipartFile.getName();
                String fileName = multipartFile.getOriginalFilename();
                paraMap.put(name, fileName);
            } else if (value instanceof HttpServletResponse) {
            } else if (value instanceof InputStream) {
            } else if (value instanceof InputStreamSource) {
            } else {
                // 参数名
                RequestParam requestParam = methodParam.getParameterAnnotation(RequestParam.class);
                String paraName;
                if (requestParam != null && requestParam.value().length() != 0) {
                    paraName = requestParam.value();
                } else {
                    paraName = methodParam.getParameterName();
                }
                paraMap.put(paraName, value);
            }
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = Objects.requireNonNull(request).getRequestURI();
        String requestMethod = request.getMethod();

        // 构建成一条长 日志，避免并发下日志错乱
        StringBuilder beforeReqLog = new StringBuilder(300);
        // 日志参数
        List<Object> beforeReqArgs = new ArrayList<>();
        beforeReqLog.append("\n\n================  Request:[").append(requestId).append("] Start  ================\n");
        if (requestEnabled) {
            // 打印路由
            beforeReqLog.append("===> {}: {}");
            beforeReqArgs.add(requestMethod);
            beforeReqArgs.add(requestURI);
            // 请求参数
            if (paraMap.isEmpty()) {
                beforeReqLog.append("\n");
            } else {
                beforeReqLog.append(" Parameters: {}\n");
                beforeReqArgs.add(paraMap.toString());
            }
            // 打印请求头
            Enumeration<String> headers = request.getHeaderNames();
            while (headers.hasMoreElements()) {
                String headerName = headers.nextElement();
                String headerValue = request.getHeader(headerName);
                beforeReqLog.append("===Headers===  {} : {}\n");
                beforeReqArgs.add(headerName);
                beforeReqArgs.add(headerValue);
            }
        }
        beforeReqLog.append("================  Request End   ================\n");
        // 打印执行时间
        long startNs = System.nanoTime();
        log.info(beforeReqLog.toString(), beforeReqArgs.toArray());
        // aop 执行后的日志
        StringBuilder afterReqLog = new StringBuilder(200);
        // 日志参数
        List<Object> afterReqArgs = new ArrayList<>();
        afterReqLog.append("\n\n================  Response:[").append(requestId).append("]  Start  ================\n");
        try {
            Object result = point.proceed();
            // 打印返回结构体
            if (responseEnabled) {
                afterReqLog.append("===Result===  {}\n");
                afterReqArgs.add(result.toString());
            }
            return result;
        } finally {
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
            afterReqLog.append("<=== {}: {} ({} ms)\n");
            afterReqArgs.add(requestMethod);
            afterReqArgs.add(requestURI);
            afterReqArgs.add(tookMs);
            afterReqLog.append("================  Response End   ================\n");
            log.info(afterReqLog.toString(), afterReqArgs.toArray());
        }
    }

    /**
     * 获取方法参数信息
     *
     * @param method         方法
     * @param parameterIndex 参数序号
     * @return {MethodParameter}
     */
    private static MethodParameter getMethodParameter(Method method, int parameterIndex) {
        MethodParameter methodParameter = new SynthesizingMethodParameter(method, parameterIndex);
        methodParameter.initParameterNameDiscovery(PARAMETER_NAME_DISCOVERER);
        return methodParameter;
    }

}
