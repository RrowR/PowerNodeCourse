package com.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController01 {
    @GetMapping("pro")
    public String provider01SendMsg(){
        return "我是provider1发过来的消息";
    }
}
