package com.demo.demooauth.feign.bean;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/6/27.
 */

@Data
public class SysUserBean implements UserDetails {


    private String username;

    private String password;

    private boolean enabled;

    private List<SysAuthBean> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
