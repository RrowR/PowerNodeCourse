package com.study.controller;

import com.study.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserOrderFeign userOrderFeign;

    @GetMapping("userDoOrder")
    public String test() {
        String s = userOrderFeign.doOrder();
        return s;
    }

}
