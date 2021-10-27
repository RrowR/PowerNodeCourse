package com.study.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "client-provider")         // 找到对应的服务名
public interface ConsumerFeign {

    @GetMapping("ordered")          // 找到服务名下对应的接口
    String doOrderkkk();            // 方法名可以随便取，给其他调用就可以了
}
