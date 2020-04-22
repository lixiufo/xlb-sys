package com.demo.demooauth.feign;

import com.demo.demooauth.feign.bean.SysUserBean;
import com.demo.demooauth.feign.handler.SysUserFeignServiceException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author WPF
 * @version springcloud
 * @date 2019-06-26.
 */

@FeignClient(value = "demo-user-role", fallback = SysUserFeignServiceException.class)
public interface SysUserFeignService {

    /**
     * 查找用户名和密码
     *
     * @param username
     *         nn
     *
     * @return nn
     */
    @GetMapping("v1/api/user/loadUserByUsername")
    SysUserBean loadUserByUsername(@RequestParam("username") String username);
}
