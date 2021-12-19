package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @RequestMapping("templates")
    public String toTemplates(){
        /*
            我们请求的路径既没有加template，也没有加.html
            这里template的访问地址不能直接被访问到，必须使用跳转才可以,static下的文件才可以
         */
        return "hello";
    }
}
