package com.demo.demooperation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author WPF
 * @version springcloud
 * @date 2019-06-25.
 * 对接 oauth2的统一鉴权
 */

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .sessionManagement().disable()
                .authorizeRequests()
//swagger api json
                .antMatchers("/v2/api-docs",
                        //用来获取支持的动作
                        "/swagger-resources/configuration/ui",
                        //用来获取api-docs的URI
                        "/swagger-resources",
                        //安全选项
                        "/swagger-resources/configuration/security",
                        "/swagger-ui.html").permitAll()
                //放行接口
                .antMatchers("/v1/front/**").permitAll()
                .antMatchers("/v2/front/**").permitAll()
                .antMatchers("/v1/api/**").permitAll()
                .anyRequest().authenticated()
        ;
    }
}
