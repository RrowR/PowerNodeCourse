package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class MVCInnerObject {
    @RequestMapping("params.do")
    public String param(HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model){
        System.out.println(request);
        System.out.println(session);
        System.out.println(response);
        request.setAttribute("username","晓峰");
        request.setAttribute("age",30);
        return "../user.jsp";
    }
    @RequestMapping("params2.do")
    public String param2(Model model){
        System.out.println(model.getClass().getSimpleName());
        model.addAttribute("username","猫羽雫");
        model.addAttribute("age",30);
        return "../user.jsp";
    }

    @RequestMapping("params3.do")
    public ModelAndView param3(ModelAndView modelAndView,String username, String password){
        /**
         *  ModelAndView既可以设置跳转，又可以存数据
         */
        System.out.println("modelAndView.getModel().get(\"username\") = " + modelAndView.getModel().get("username"));
        System.out.println("modelAndView.getModel().get(\"password\") = " + modelAndView.getModel().get("password"));
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        modelAndView.setViewName("../user.jsp");
        modelAndView.addObject("username","ddd");
        modelAndView.addObject("age","15");
        return modelAndView;
    }



}
