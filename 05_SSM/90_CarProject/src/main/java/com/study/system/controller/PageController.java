package com.study.system.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.study.system.common.Constants;
import com.study.system.common.Result;
import com.study.system.domain.User;
import com.study.system.service.UserService;
import com.study.system.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("page")
public class PageController {

    /*
         跳转到登录页
      */
    @RequestMapping("toLogin.action")
    public String login(){
        return "main/login";
    }

    /*
        跳转到首页
     */
    @RequestMapping("index.action")
    public String index(){
        return "main/index";
    }

}
