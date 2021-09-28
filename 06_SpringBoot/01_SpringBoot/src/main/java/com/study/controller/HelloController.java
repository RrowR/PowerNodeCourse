package com.study.controller;

import com.study.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("getUser")
    public User returnUser(){
        return new User("猫羽雫",16);
    }
}
