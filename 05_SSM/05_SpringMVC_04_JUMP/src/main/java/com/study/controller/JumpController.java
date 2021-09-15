package com.study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jump")
public class JumpController {
    @RequestMapping("forward01.do")
    public String forward01(){
        System.out.println("forword01执行了");
        return "../success.jsp";
    }

    @RequestMapping("forward02.do")
    public ModelAndView redirect02(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("../success2.jsp");
        return modelAndView;
    }

    @RequestMapping("forward03.do")
    public String redirect03(){
        return "redirect:http://www.baidu.com";
    }

    @RequestMapping("forward04.do")
    public String redirect04(){
        return "redirect:../success2.jsp";
    }


}
