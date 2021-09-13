package com.study.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controller02 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("springMVC 02");
        ModelAndView modelAndView = new ModelAndView();
        // ModelAndView 内部使用的是内部转发的方式
//        modelAndView.setViewName("/index.jsp");
        modelAndView.setViewName("redirect:index.jsp");     // 手动加可以改请求方式
        return modelAndView;
    }
}
