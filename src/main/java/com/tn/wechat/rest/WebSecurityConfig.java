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
//    public static String openId;
//    public static String sessionId;
    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
//        System.out.println("exclude");
        addInterceptor.excludePathPatterns("/403");
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/error");
        //for backend message handle
        addInterceptor.excludePathPatterns("/comm/**");

        addInterceptor.excludePathPatterns("/2_d_code/img/**");
        addInterceptor.excludePathPatterns("/image/**");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            HttpSession session = request.getSession();
            System.out.println("open id:" +session.getAttribute("WECHAT_OPENID"));
//            Object openId = session.getAttribute(session.getAttribute(session.getId()).toString());
            if (session.getAttribute("WECHAT_OPENID") != null ) {
                //add session check
                return true;
            }
            // 跳转登录
            System.out.println("session id :" + session.getId());

            String url = "/403";
            response.sendRedirect(url);
            return false;
        }
    }
}
