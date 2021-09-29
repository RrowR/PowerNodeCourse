package com.study.dynamicresources.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Jump {
    @RequestMapping("hello")
    public String toHello(){
        return "redirect:index.html";
    }
}
