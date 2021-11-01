package com.study.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
    其实这里也不需要写实体类，只需要写上
    post        http://localhost:8080/actuator/refresh
    @RefreshScope
    @Data
    2个注解在controller里也是可以的
 */
@RestController
@RefreshScope
@Data
public class TestController {
    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private String age;

    @Value("${user.address}")
    private String address;

    @GetMapping("data")
    public String getData(){
        return "" + name + age + address;
    }
}
