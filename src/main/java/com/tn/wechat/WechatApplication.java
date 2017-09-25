package com.tn.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WechatApplication extends SpringBootServletInitializer
{
    private static Logger logger = LoggerFactory.getLogger(WechatApplication.class);
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info(" start from servlet 3.0 initializer");
        return application.sources(WechatApplication.class);
    }

	public static void main(String[] args) {
        logger.info(" start from command line");
		SpringApplication.run(WechatApplication.class, args);
	}
}
