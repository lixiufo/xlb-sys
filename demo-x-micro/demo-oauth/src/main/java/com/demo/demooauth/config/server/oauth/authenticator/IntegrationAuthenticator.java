package com.demo.demooauth.config.server.oauth.authenticator;

import com.demo.demooauth.config.server.oauth.IntegrationAuthenticationEntity;
import com.demo.demooauth.feign.bean.SysUserBean;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/26.
 * 定义集成认证-认证器接口
 */
public interface IntegrationAuthenticator {

    /**
     * 处理集成认证
     *
     * @param entity
     *         集成认证实体
     *
     * @return 用户表实体
     */
    SysUserBean authenticate(IntegrationAuthenticationEntity entity);

    /**
     * 预处理
     *
     * @param entity
     *         集成认证实体
     */
    void prepare(IntegrationAuthenticationEntity entity);

    /**
     * 判断是否支持集成认证类型
     *
     * @param entity
     *         集成认证实体
     */
    boolean support(IntegrationAuthenticationEntity entity);

    /**
     * 认证结束后执行
     *
     * @param entity
     *         集成认证实体
     */
    void complete(IntegrationAuthenticationEntity entity);

}
