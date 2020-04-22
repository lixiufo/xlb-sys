package com.demo.democommoncore.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/8.
 * 前端参数校验接口
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamCheck {
    /**
     * 是否开启前端参数校验
     *
     * @return nn
     */
    boolean value() default true;

    /**
     * 容错时间（ms）
     *
     * @return nn
     */
    int tolerate() default 60_000;
}
