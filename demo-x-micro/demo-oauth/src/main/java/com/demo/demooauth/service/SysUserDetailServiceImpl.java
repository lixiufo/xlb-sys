package com.demo.demooauth.service;

import com.demo.demooauth.config.server.oauth.IntegrationAuthenticationContext;
import com.demo.demooauth.config.server.oauth.IntegrationAuthenticationEntity;
import com.demo.demooauth.config.server.oauth.authenticator.IntegrationAuthenticator;
import com.demo.demooauth.feign.bean.SysUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WPF
 * @version springcloud
 * @date 2019-06-25.
 */

@Service
public class SysUserDetailServiceImpl implements UserDetailsService {

    private List<IntegrationAuthenticator> authenticatorList;

    @Autowired(required = false)
    public void setIntegrationAuthenticatorList(List<IntegrationAuthenticator> authenticatorList) {
        this.authenticatorList = authenticatorList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        IntegrationAuthenticationEntity entity = IntegrationAuthenticationContext.get();
        if (entity == null) {
            entity = new IntegrationAuthenticationEntity();
        }
        SysUserBean pojo = this.authenticate(entity);
        if (pojo == null) {
            throw new UsernameNotFoundException("登录失败");
        }
        return new User(pojo.getUsername(), pojo.getPassword(), pojo.getAuthorities());
    }

    private SysUserBean authenticate(IntegrationAuthenticationEntity entity) {
        if (this.authenticatorList != null) {
            for (IntegrationAuthenticator authenticator : authenticatorList) {
                if (authenticator.support(entity)) {
                    return authenticator.authenticate(entity);
                }
            }
        }
        return null;
    }

}
