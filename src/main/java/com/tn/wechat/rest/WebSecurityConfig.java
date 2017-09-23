package com.tn.wechat.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chengchao.dong on 9/9/2017.
 */
@Configuration
@Profile("production")
public class WebSecurityConfig extends WebMvcConfigurerAdapter  {
    //
    public final static String SESSION_KEY = "user";
    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
//        System.out.println("exclude");
        addInterceptor.excludePathPatterns("/errorlogin");
        addInterceptor.excludePathPatterns("/loginPost");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            HttpSession session = request.getSession();
            if (session.getAttribute(SESSION_KEY) != null && session.getAttribute(session.getId()) != null) {
                //add session check
                return true;
            }
            // 跳转登录
            System.out.println("session:");
            System.out.println(session);
            System.out.println("session id :" + session.getId());
            String url = "/errorlogin";
            response.sendRedirect(url);
            return false;
        }
    }
}
