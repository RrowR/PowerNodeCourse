package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("success")
    public String toLogin() {
        return "success";
    }

    @RequestMapping("fail")
    public String fail() {
        return "fail";
    }
}
