package com.study.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.ZonedDateTime;

/**
 * 使用java代码来配置路由
 */
@Configuration
public class MyRouter {

    @Bean
    public RouteLocator locator(RouteLocatorBuilder builder) {
        // 自定义一个路由，当请求 / 的时候跳转到 http://www.baidu.com
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

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RouteLocator doLogin(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("login-service", r -> r.path("/doLogin")
                        .filters(f -> f.modifyResponseBody(String.class, String.class, (serverWebExchange, s) -> {
                                    // 这个filter是一个后置拦截的方法，编辑响应的结果，s为响应的值，也就是data
                                    System.out.println(s);
                                    // 反转成Object对象，其实里面是data
                                    JSONObject jsonObject = JSON.parseObject(s);
                                    // 我们可以在网关里进行操作存入redis
                                    redisTemplate.opsForValue().set(jsonObject.getString("token"), jsonObject.get("user").toString(), Duration.ofSeconds(Integer.parseInt(jsonObject.get("expire_in").toString())));
                                    return Mono.just(jsonObject.getString("token"));
                                }
                                // uri是配合上面的path来进行拼接的，拼接起来就是 http://127.0.0.1:80/loginservice/doLogin
                        )).uri("lb://loginservice")).build();

    }
}
