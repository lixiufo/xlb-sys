package com.demo.demooauth.feign.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/6/27.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysAuthBean implements GrantedAuthority {

    private String authority;

}
