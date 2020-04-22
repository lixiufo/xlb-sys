package com.demo.democommoncore.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/25.
 * 内部服务鉴权 -> 使用专门的token校验规则
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InnerFeign {

    /**
     * 是否AOP统一处理
     *
     * @return false, true
     */
    boolean value() default true;

    /**
     * 需要特殊判空的字段(预留)
     *
     * @return {}
     */
    String[] field() default {};

}
