package com.demo.demooauth.config.server.oauth.authenticator;

import com.demo.demooauth.config.server.oauth.IntegrationAuthenticationEntity;
import com.demo.demooauth.feign.SysUserFeignService;
import com.demo.demooauth.feign.bean.SysUserBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/28.
 * 管理员登录
 */
@Component
public class SystemUsernameAuthenticator extends AbstractPreparableIntegrationAuthenticator {

    /**
     * 管理员以第三方身份登录
     */
    private static final String SYSTEM_LOGIN = "system";

    @Resource
    private SysUserFeignService sysUserFeignService;

    @Override
    public SysUserBean authenticate(IntegrationAuthenticationEntity entity) {
        String name = entity.getAuthParameter("username");
        return sysUserFeignService.loadUserByUsername(name);
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return Objects.equals(SYSTEM_LOGIN, entity.getAuthType());
    }
}
