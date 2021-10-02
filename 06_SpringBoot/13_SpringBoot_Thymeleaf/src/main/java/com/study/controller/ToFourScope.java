package com.study.controller;

import com.study.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("scope")
public class ToFourScope {
    @RequestMapping("four")
    public String fourScope(Model model, HttpServletRequest request){
        User user = new User(1, "猫羽雫", "女", 16, "japen", "xxxxx", new Date(), 99999.899);
        model.addAttribute("name",user.getName());
        request.setAttribute("sex",user.getSex());
        request.getSession().setAttribute("age",user.getAge());
        request.getServletContext().setAttribute("phone",user.getPhone());
        return "fourScope";
    }
}
