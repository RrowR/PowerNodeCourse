package com.study.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

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

    /*
        断言表达式地址(spring官方文档)
        https://docs.spring.io/spring-cloud-gateway/docs/2.2.5.RELEASE/reference/html/#gateway-request-predicates-factories
     */
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
