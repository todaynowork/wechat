package com.tn.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WechatApplication extends SpringBootServletInitializer
{
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WechatApplication.class);
    }

	public static void main(String[] args) {
        //System.out.print("hello");
		SpringApplication.run(WechatApplication.class, args);
	}
}
