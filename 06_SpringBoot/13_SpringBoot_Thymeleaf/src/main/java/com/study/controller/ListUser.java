package com.study.controller;

import com.study.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class ListUser {
    @RequestMapping("getListUsers")
    public String ListUser(Model model){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            User user = new User(i, "猫羽雫"+i, "女"+i, 16+i, "japen"+i, "xxxxx"+i, new Date(), 99999.899);
            users.add(user);
            model.addAttribute("users",users);
        }
        return "userModel2";
    }
}
