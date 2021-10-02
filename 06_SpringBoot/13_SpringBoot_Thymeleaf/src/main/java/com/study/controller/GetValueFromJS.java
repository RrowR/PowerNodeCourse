package com.study.controller;

import com.study.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class GetValueFromJS {
    @RequestMapping("formjs")
    public String GetValueFormJS(Model model, HttpServletRequest request){
        User user = new User(1, "猫羽雫", "女", 16, "japen", "xxxxx", new Date(), 99999.899);
        model.addAttribute("name",user.getName());
        model.addAttribute("age",user.getAge());
        request.setAttribute("phone",user.getPhone());
        return "fromjs";
    }
}
