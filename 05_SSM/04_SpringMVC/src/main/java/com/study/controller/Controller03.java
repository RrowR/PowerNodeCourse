package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    使用注解的方式
 */
@Controller
@RequestMapping("user")
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

    @RequestMapping("del.do")
    public void query3(){
        System.out.println("调用了删除...");
    }

    @RequestMapping("update.do")
    public void query4(){
        System.out.println("调用了修改");
    }

    @RequestMapping("Stringdel.do")
    public String query5(){
        return "../del.jsp";
    }

    @RequestMapping("Stringupdate.do")
    public String query6(){
        return "../update.jsp";
    }

    @RequestMapping("StringIndex2.do")
    public ModelAndView query7(){
        ModelAndView modelAndView = new ModelAndView("../index02.jsp");
        return modelAndView;
    }
}
