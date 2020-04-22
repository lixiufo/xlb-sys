package com.demo.demooauth.config.server.oauth.authenticator;

import com.demo.demooauth.config.server.oauth.IntegrationAuthenticationEntity;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/26.
 * 定义集成认证-认证器抽象类
 */
public abstract class AbstractPreparableIntegrationAuthenticator implements IntegrationAuthenticator {

    @Override
    public void prepare(IntegrationAuthenticationEntity entity) {

    }

    @Override
    public void complete(IntegrationAuthenticationEntity entity) {

    }
}
