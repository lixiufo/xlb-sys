package com.demo.demooauth.feign.handler;

import com.demo.demooauth.feign.SysUserFeignService;
import com.demo.demooauth.feign.bean.SysUserBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author WPF
 * @version springcloud
 * @date 2019-06-26.
 */
@Component
public class SysUserFeignServiceException implements SysUserFeignService {

    @Override
    public SysUserBean loadUserByUsername(String username) {
        throw new UsernameNotFoundException("用户不存在");
    }
}
