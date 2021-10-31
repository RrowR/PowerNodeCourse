package com.study.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

@Configuration
public class MyRateLimiteConfig {

    /*
        根据IP来做限流
     */
    @Bean
    @Primary
    public KeyResolver hostLimitResolver(){
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /*
        根据api来做限流
     */
    @Bean
    public KeyResolver apiLimitResolver(){
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

    /*
        使用id来做限流
     */
    @Bean
    public KeyResolver userLimitResolver(){
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }
}
