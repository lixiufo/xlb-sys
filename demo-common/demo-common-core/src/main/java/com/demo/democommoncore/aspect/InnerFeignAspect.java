package com.demo.democommoncore.aspect;

import com.demo.democommoncore.annotation.InnerFeign;
import com.demo.democommoncore.constant.SystemConst;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.Objects;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/25.
 */
@Slf4j
@Aspect
public class InnerFeignAspect implements Ordered {

    @Resource
    private HttpServletRequest httpServletRequest;

    @SneakyThrows
    @Around("@annotation(inner)")
    public Object around(ProceedingJoinPoint point, InnerFeign inner) {
        String header = httpServletRequest.getHeader(SystemConst.INNER_FROM);
        if (inner.value() && !Objects.equals(SystemConst.INNER_TOKEN, header)) {
            log.warn("访问接口 {} 没有权限", point.getSignature().getName());
            throw new AccessDeniedException("Access denied");
        }
        return point.proceed();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
