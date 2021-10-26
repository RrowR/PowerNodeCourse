package com.study.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider2 {

    @GetMapping("pro")
    public String pro2(){
        return "我是provider2的消息";
    }
}
