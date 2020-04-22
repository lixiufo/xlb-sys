package com.demo.demooauth.config.server.oauth.authenticator;

import com.demo.demooauth.config.server.oauth.IntegrationAuthenticationEntity;
import com.demo.demooauth.feign.SysUserFeignService;
import com.demo.demooauth.feign.bean.SysUserBean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/26.
 */
@Component
@Primary
public class UsernamePasswordAuthenticator extends AbstractPreparableIntegrationAuthenticator {

    @Resource
    private SysUserFeignService sysUserFeignService;

    @Override
    public SysUserBean authenticate(IntegrationAuthenticationEntity entity) {
        String name = entity.getAuthParameter("username");
        String pwd = entity.getAuthParameter("password");
        //验证码校验
        if (name == null || pwd == null) {
            throw new OAuth2Exception("用户名或密码不能为空");
        }
        SysUserBean pojo = sysUserFeignService.loadUserByUsername(name);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(pwd, pojo.getPassword())) {
            return pojo;
        }
        return null;
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return entity.getAuthType() == null || entity.getAuthType().length() == 0;
    }
}
