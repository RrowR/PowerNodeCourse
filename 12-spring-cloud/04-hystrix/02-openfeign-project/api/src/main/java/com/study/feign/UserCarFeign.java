package com.study.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "car-service")
public interface UserCarFeign {
}
