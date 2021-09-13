package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    使用注解的方式
 */
@Controller
@RequestMapping
public class Controller03 {
    @RequestMapping("query1.do")
    public void query(){
        System.out.println("调用了查询的接口");
    }

    @RequestMapping("query2.do")
    public ModelAndView query2(){
        System.out.println("调用了查询的接口");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }
}
