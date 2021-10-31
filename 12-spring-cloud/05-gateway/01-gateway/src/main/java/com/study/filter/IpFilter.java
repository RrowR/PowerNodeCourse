package com.study.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Objects;

/*
    IP拦截指定ip地址
 */
@Component
public class IpFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String hostName = exchange.getRequest().getHeaders().getHost().getHostName();
        if (hostName.equals("localhost")){
            // 如果请求的ip为localhost则为黑名单
            ServerHttpResponse response = exchange.getResponse();
            // 设置返回状态码
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",HttpStatus.UNAUTHORIZED);
            map.put("msg","不允许给劳资访问");
            response.getHeaders().add("content-Type","application/json;charset=utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                byte[] bytes = objectMapper.writeValueAsBytes(map);
                // 可以用response拿到buffer工厂
                DataBufferFactory dataBufferFactory = response.bufferFactory();
                // 包装直接数组
                DataBuffer wrap = dataBufferFactory.wrap(bytes);
                // 因为返回值需要是一个Mono,里面传的参数就只能这样处理
                return response.writeWith(Mono.just(wrap));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return chain.filter(exchange);
    }

    // IP拦截要先进行判断
    @Override
    public int getOrder() {
        return 0;
    }
}
