package com.tn.wechat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import java.io.IOException;

@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {
//    private static RedisServer redisServer;

    @Bean
    public JedisConnectionFactory connectionFactory() throws IOException {
//        redisServer = new RedisServer(Protocol.DEFAULT_PORT);
//        redisServer.start();
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("redis-11366.c6.eu-west-1-1.ec2.cloud.redislabs.com");
        factory.setPort(11366);
        return factory;
    }

//    @PreDestroy
//    public void destroy() {
//        redisServer.stop();
//    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }
}
