package com.demo.democommondataredis.annotation;

import com.demo.democommondataredis.enums.LimitType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/8.
 * Api限流接口
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisApiLimit {

    /**
     * 资源名称，用于描述接口功能
     */
    String name() default "";

    /**
     * 资源 key
     */
    String key() default "";


    /**
     * key prefix
     */
    String prefix() default "";


    /**
     * 时间的，单位秒
     */
    int period() default 60;


    /**
     * 限制访问次数
     */
    int count() default 60;


    /**
     * 限制类型
     */
    LimitType limitType() default LimitType.IP;

}
