package com.demo.demooperation.utils.sys;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WPF
 * @version springcloud
 * @date 2019-06-26.
 */

public class CurrentUser {

    /**
     * 未知的未登录用户
     */
    public static final String UN_LOGIN_USER = "un_login_user";

    private static final String SPY_HEADER = "spy";


    /**
     * 获取登陆用户信息
     *
     * @return 账户名
     */
    public static String username() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            try {
                if (RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes) {
                    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                    List<String> authList = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
                    if (StringUtils.isNotEmpty(request.getHeader(SPY_HEADER)) && (authList.contains("system") || authList.contains("admin"))) {
                        return request.getHeader(SPY_HEADER);
                    }
                }
                return authentication.getName();
            } catch (Exception e) {
                return UN_LOGIN_USER;
            }
        }
        return UN_LOGIN_USER;
    }

    /**
     * 获取登录用户的权限列表
     *
     * @return nn
     */
    public static List<String> authList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            try {
                return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
            } catch (Exception ignored) {
            }
        }
        return new ArrayList<>(0);
    }
}
