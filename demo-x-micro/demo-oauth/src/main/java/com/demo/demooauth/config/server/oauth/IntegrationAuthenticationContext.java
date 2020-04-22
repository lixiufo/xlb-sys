package com.demo.demooauth.config.server.oauth;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/26.
 */
public class IntegrationAuthenticationContext {

    private static final ThreadLocal<IntegrationAuthenticationEntity> holder = new ThreadLocal<>();

    public static void set(IntegrationAuthenticationEntity entity) {
        holder.set(entity);
    }

    public static IntegrationAuthenticationEntity get() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }

}
