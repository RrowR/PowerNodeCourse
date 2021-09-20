package com.study.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    /*
         跳转到登录页
      */
    @RequestMapping("toLogin.action")
    public String login(){
        return "main/login";
    }

    /*
        跳转到首页
     */
    @RequestMapping("index.action")
    public String index(){
        return "main/index";
    }

    /*
        跳转到工作台
     */
    @RequestMapping("toWelcome.action")
    public String toWelcome(){
        return "main/welcome";
    }
}
