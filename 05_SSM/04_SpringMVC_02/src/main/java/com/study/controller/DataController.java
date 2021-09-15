package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("user")
@Controller
public class DataController {
    @RequestMapping("index.do")
    public String toIndex(@RequestParam("UserName") String username, @RequestParam("Age") String age, @RequestParam("Address") String address){
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
        return "../success.jsp";
    }
}
