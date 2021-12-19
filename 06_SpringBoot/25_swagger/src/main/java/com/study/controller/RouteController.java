package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("route")
public class RouteController {
    @PostMapping("hello")
    public String hello(){
        return "hello";
    }
}
