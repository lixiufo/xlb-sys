package com.demo.demooauth.config.server.oauth;

import lombok.Data;

import java.util.Map;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/26.
 * 定义集成认证实体
 */
@Data
public class IntegrationAuthenticationEntity {

    /**
     * 请求登录认证类型
     */
    private String authType;

    /**
     * 请求登录认证参数集合
     */
    private Map<String, String[]> authParameters;

    /**
     * 参数列表
     *
     * @param paramter
     *         nn
     *
     * @return nn
     */
    public String getAuthParameter(String paramter) {
        String[] values = this.authParameters.get(paramter);
        if (values != null && values.length > 0) {
            return values[0];
        }
        return null;
    }
}