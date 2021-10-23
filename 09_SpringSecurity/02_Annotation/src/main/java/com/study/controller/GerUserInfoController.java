package com.study.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/*
    获取当前用户信息的2种方式
 */
@RestController
public class GerUserInfoController {
    @RequestMapping("userinfo")
    public Principal getUserInfo(Principal principal) {
        // 从 Principal 对象中进行获取
        return principal;
    }

    @RequestMapping("userinfo2")
    public Principal getUserInfo2() {
        // 获取SecurityContextHolder 上下文的方式
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

}
