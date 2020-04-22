package com.demo.demooauth.config.server.oauth;

import com.demo.demooauth.config.server.oauth.authenticator.IntegrationAuthenticator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/26.
 * 定义拦截器拦截登录请求
 */
@Component
public class IntergrationAuthenticationFilter extends GenericFilterBean implements ApplicationContextAware {

    /**
     * 授权参数
     */
    private static final String AUTH_TYPE_PARAM_NAME = "auth_type";

    /**
     * 授权地址
     */
    private static final String AUTH_TOKEN_URL = "/oauth/token";

    /**
     * 鉴权主体
     */
    private Collection<IntegrationAuthenticator> authenticatorList;

    private ApplicationContext applicationContext;

    private final RequestMatcher requestMatcher;

    public IntergrationAuthenticationFilter() {
        this.requestMatcher = new OrRequestMatcher(
                new AntPathRequestMatcher(AUTH_TOKEN_URL, "POST"),
                new AntPathRequestMatcher(AUTH_TOKEN_URL, "GET")
        );
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //转参数
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //不合法的请求，驳回
        if (!requestMatcher.matches(httpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }
        RequestParameterWrapper requestParameterWrapper = new RequestParameterWrapper(httpServletRequest);
        if (requestParameterWrapper.getParameter("password") == null) {
            requestParameterWrapper.addParameter("password", "");
        }
        IntegrationAuthenticationEntity entity = new IntegrationAuthenticationEntity();
        entity.setAuthType(requestParameterWrapper.getParameter(AUTH_TYPE_PARAM_NAME));
        entity.setAuthParameters(requestParameterWrapper.getParameterMap());
        IntegrationAuthenticationContext.set(entity);
        try {
            this.prepare(entity);
            chain.doFilter(requestParameterWrapper, response);
            this.complete(entity);
        } finally {
            IntegrationAuthenticationContext.clear();
        }

    }

    /**
     * 认证前回调
     *
     * @param entity
     *         集成认证实体
     */
    private void prepare(IntegrationAuthenticationEntity entity) {
        if (entity != null) {
            synchronized (this) {
                Map<String, IntegrationAuthenticator> map = applicationContext.getBeansOfType(IntegrationAuthenticator.class);
                this.authenticatorList = map.values();
            }
        }
        if (this.authenticatorList == null) {
            this.authenticatorList = new ArrayList<>();
        }
        for (IntegrationAuthenticator authenticator : this.authenticatorList) {
            if (authenticator.support(entity)) {
                authenticator.prepare(entity);
            }
        }
    }

    /**
     * 认证结束后回调
     *
     * @param entity
     *         集成认证实体
     */
    private void complete(IntegrationAuthenticationEntity entity) {
        for (IntegrationAuthenticator authenticator : authenticatorList) {
            if (authenticator.support(entity)) {
                authenticator.complete(entity);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 用途：在拦截时给Request添加参数
     * Cloud OAuth2 密码模式需要判断Request是否存在password参数，
     * 如果不存在会抛异常结束认证
     * 所以在调用doFilter方法前添加password参数
     */
    class RequestParameterWrapper extends HttpServletRequestWrapper {

        private final Map<String, String[]> params = new HashMap<String, String[]>();

        public RequestParameterWrapper(HttpServletRequest request, Map<String, Object> extraParams) {
            this(request);
            addParameters(extraParams);
        }

        RequestParameterWrapper(HttpServletRequest request) {
            super(request);
            this.params.putAll(request.getParameterMap());
        }

        void addParameters(Map<String, Object> extraParams) {
            for (Map.Entry<String, Object> entry : extraParams.entrySet()) {
                addParameter(entry.getKey(), entry.getValue());
            }
        }

        void addParameter(String name, Object value) {
            if (value != null) {
                if (value instanceof String[]) {
                    params.put(name, (String[]) value);
                } else if (value instanceof String) {
                    params.put(name, new String[]{(String) value});
                } else {
                    params.put(name, new String[]{String.valueOf(value)});
                }
            }
        }

        @Override
        public String getParameter(String name) {
            String[] values = params.get(name);
            if (values == null || values.length == 0) {
                return null;
            }
            return values[0];
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return params;
        }

        @Override
        public String[] getParameterValues(String name) {
            return params.get(name);
        }

    }
}
