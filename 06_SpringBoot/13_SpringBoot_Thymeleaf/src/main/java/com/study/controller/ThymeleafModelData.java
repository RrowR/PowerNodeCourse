package com.study.controller;

import com.study.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ThymeleafModelData {
    @RequestMapping("user")
    public String helloModel(Model model){
        User user = new User(1, "猫羽雫", "女", 16, "japen", "xxxxx", new Date(), 99999.899);
        model.addAttribute("user",user);
        return "userModel";
    }
}
