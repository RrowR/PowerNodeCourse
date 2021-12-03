package com.nacos.study.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-discovery-client-b")
public interface RpcFeign {

    @GetMapping("hello")
    String hello();

}
