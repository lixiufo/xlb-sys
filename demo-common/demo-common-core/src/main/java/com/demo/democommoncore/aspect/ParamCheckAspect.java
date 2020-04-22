package com.demo.democommoncore.aspect;

import com.demo.democommoncore.annotation.ParamCheck;
import com.demo.democommoncore.constant.ReturnCode;
import com.demo.democommoncore.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/8.
 */
@Aspect
@Slf4j
@Order(1)
public class ParamCheckAspect {

    /**
     * 时间戳参数
     */
    public static final String TIMESTAMP = "timestamp";

    /**
     * 签名参数
     */
    public static final String MSG_SIGNATURE = "msgSignature";

    /**
     * access_token
     */
    public static final String ACCESS_TOKEN = "access_token";

    @Around("@annotation(paramCheck)")
    public Object aroundApi(ProceedingJoinPoint joinPoint, ParamCheck paramCheck) throws Throwable {
        if (paramCheck.value()) {
            var request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            var msgSignature = request.getParameter(MSG_SIGNATURE);
            var timeStamp = request.getParameter(TIMESTAMP);
            //检测必传参数
            if (StringUtils.isAnyEmpty(timeStamp, msgSignature)) {
                return Result.error(ReturnCode.ERROR_PARAM);
            }
            //检测时间戳
            if (System.currentTimeMillis() - Long.parseLong(timeStamp) > paramCheck.tolerate()) {
                return Result.error(ReturnCode.ERROR_TIMESSTAMP_ERROR);
            }
            var parameterMap = request.getParameterMap();
            var param = parameterMap.entrySet()
                    .parallelStream()
                    .filter(item -> !StringUtils.equalsAnyIgnoreCase(item.getKey(), ACCESS_TOKEN, MSG_SIGNATURE))
                    .sequential()
                    .sorted((a, b) -> a.getKey().compareToIgnoreCase(b.getKey()))
                    .map(item -> item.getValue() == null || item.getValue().length == 0 ? "" : item.getValue()[0])
                    .collect(Collectors.joining());
            //参数校验
            if (!StringUtils.equals(DigestUtils.md5Hex(request.getRequestURI() + param), Optional.ofNullable(msgSignature).orElse(""))) {
                return Result.error(ReturnCode.ERROR_MSGSIGNATURE);
            }
        }
        return joinPoint.proceed();
    }
}
