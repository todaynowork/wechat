package com.tn.wechat;

import com.tn.wechat.security.WechatAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@Profile("security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private WechatAuthenticationProvider wechatAuthenticationProvider;



//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/login","/logintest");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable().and()
//                .authorizeRequests()
//                .antMatchers("/login","/logintest").permitAll();
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.wechatAuthenticationProvider);
    }

    class MyAccessDeniedHandler implements AccessDeniedHandler {

        private  Logger logger = LoggerFactory.getLogger(MyAccessDeniedHandler.class);

        @Override
        public void handle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           AccessDeniedException e) throws IOException, ServletException {

            Authentication auth
                    = SecurityContextHolder.getContext().getAuthentication();
//            auth.get

            if (auth != null) {
                logger.info("User '" + auth.getName()
                        + "' attempted to access the protected URL: "
                        + httpServletRequest.getRequestURI());
            }

            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403");

        }
    }
}
