package com.study.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  使用java代码来配置路由
 */
@Configuration
public class MyRouter {

    @Bean
    public RouteLocator locator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("222", r -> r.path("/").uri("http://www.baidu.com"))
                .build();
    }
}
