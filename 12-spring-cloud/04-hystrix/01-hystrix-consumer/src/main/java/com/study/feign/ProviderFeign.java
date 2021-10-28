package com.study.feign;

import com.study.feign.hystrix.ConsumerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/*
    value = "provider"  成功执行provider实例里的方法
    fallback  访问失败就执行fallback执行的方法
 */
@FeignClient(value = "provider", fallback = ConsumerHystrix.class)
public interface ProviderFeign {
    @GetMapping("makeFood")
    String makeFood();
}
