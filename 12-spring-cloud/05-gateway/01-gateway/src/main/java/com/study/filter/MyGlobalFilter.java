package com.study.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 从exchange里拿到 ServerHttpRequest  注意不是 HttpServletRequest
        ServerHttpRequest request = exchange.getRequest();
        RequestPath path = request.getPath();
        System.out.println(path.value());
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        System.out.println(queryParams);
        String hostName = request.getRemoteAddress().getHostName();
        System.out.println(hostName);
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("content-type","application/json;charset=utf-8");
        return chain.filter(exchange);
    }


    // 实现Ordered接口来进行排序，越小越先执行
    @Override
    public int getOrder() {
        return 1;
    }
}
