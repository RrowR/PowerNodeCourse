package com.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestApplicationService {
    @GetMapping("doLogin")
    public String getToken(String username ,String pwd){
        System.out.println(username);
        System.out.println(pwd);
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }
}
