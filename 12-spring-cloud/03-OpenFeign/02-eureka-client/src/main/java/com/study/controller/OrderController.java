package com.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("ordered")
    public String doOrder(){
        System.out.println("有人来下单了...");
        return "下单成功";
    }

}
