package com.demo.demooauth.config.server.oauth.authenticator;

import com.demo.demooauth.config.server.oauth.IntegrationAuthenticationEntity;
import com.demo.demooauth.feign.SysUserFeignService;
import com.demo.demooauth.feign.bean.SysUserBean;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/26.
 */
@Component
public class SmsAuthenticator extends AbstractPreparableIntegrationAuthenticator {

    /**
     * 短信登录参数
     */
    private static final String SMS_AUTH_TYPE = "sms";

    @Resource
    private SysUserFeignService sysUserFeignService;

    @Override
    public SysUserBean authenticate(IntegrationAuthenticationEntity entity) {
        //手机号码
        String phone = entity.getAuthParameter("phone");
        //验证码
        String code = entity.getAuthParameter("codeResult");
        //验证
        if (!"1".equals(code)) {
            throw new OAuth2Exception("验证码错误或已过期");
        }
        return sysUserFeignService.loadUserByUsername(phone);
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return SMS_AUTH_TYPE.equals(entity.getAuthType());
    }
}
