package com.demo.democommonquartz.aspect;

import com.demo.democommonquartz.annotation.JobLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/23.
 */
@Aspect
@Slf4j
public class JobLogAspect {

    @Around("@annotation(jobLog)")
    public Object aroundApi(ProceedingJoinPoint point, JobLog jobLog) throws Throwable {
        String taskUuid = UUID.randomUUID().toString();
        long startTime = System.nanoTime();
        log.info("========{}==定时任务【{}】======执行开始=======", taskUuid, jobLog.value());
        Object proceed = point.proceed();
        log.info("========{}==定时任务【{}】======执行结束=======执行时间【{}】====", taskUuid, jobLog.value(), TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
        return proceed;
    }

}
