package com.study.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class TokenCheckedFilter implements GlobalFilter, Ordered {

    private static final List<String> ALLOW_URL = Arrays.asList("/loginservice/doLogin","/doLogin");

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().value();
        if (ALLOW_URL.contains(path)) {
            // 如果是登陆请求地址，直接放行
            return chain.filter(exchange);
        }
        // 从请求有里拿到Authorization这个字段的值，但是返回却是一个list
        List<String> authorization = request.getHeaders().get("Authorization");
        if (!CollectionUtils.isEmpty(authorization)) {
            // 如果前端传过来的Authorization集合不为空，获取集合里的第一个元素，也就是Authorization的值
            String auth = authorization.get(0);
            if (StringUtils.hasText(auth)){
                // 如果前端传过来的Authorization对象有值，将这个token进行重组
                String token = auth.replaceAll("bearer ", "");
                if (StringUtils.hasText(token) && redisTemplate.hasKey(token)){
                    // 如果重组的token有值并且在redis里也有值，则放行
                    return chain.filter(exchange);
                }
            }
        }
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("content-Type","application/json;charset=utf-8");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code",401);
        hashMap.put("msg","你还没有授权啊");
        byte[] bytes = new byte[0];
        try {
            bytes = new ObjectMapper().writeValueAsBytes(hashMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        DataBuffer wrap = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(wrap));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
