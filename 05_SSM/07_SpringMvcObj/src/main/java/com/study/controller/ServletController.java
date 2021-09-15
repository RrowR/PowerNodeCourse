package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class ServletController {

    @Resource
    private HttpServletRequest request;

    @RequestMapping("obj1.do")
    public String obj1(HttpServletRequest req){
        /*
            上面的2个HttpServletRequest是不同的对象，但是里   面的值是一样的，相当于是另一个副本
            其实内部是在从tomcat8开始，tomcat其实有一个池子，从最近使用的里面去拿
            而且这个池子的默认个数是10个
         */
        request.setAttribute("username","猫羽雫");
        System.out.println(req.getAttribute("username"));
        System.out.println(request.hashCode());
        System.out.println(req.hashCode());
        return null;
    }


}
