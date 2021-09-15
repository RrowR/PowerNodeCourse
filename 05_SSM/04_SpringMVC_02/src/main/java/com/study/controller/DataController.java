package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
@Controller
public class DataController {
    @RequestMapping("index.do")
    public String toIndex(String username,String age,String address){
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
        return "../index.jsp";
    }
}
