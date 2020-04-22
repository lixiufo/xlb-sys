package com.demo.demooperation.utils.sys;

import org.springframework.context.ApplicationContext;

/**
 * @author WPF
 * @version distribution-sys
 * @date 2019-04-07.
 */

public class SpringUtils {

    /**
     * 上下文变量 -> 初始化时赋值
     */
    private static ApplicationContext applicationContext = null;

    /**
     * 初始化上下文变量
     *
     * @param applicationContext
     *         nn
     */
    public static void init(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 获取Bean
     *
     * @param tClass
     *         nn
     * @param <T>
     *         n
     *
     * @return n
     */
    public static <T> T getBean(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }

}
