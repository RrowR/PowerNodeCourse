package com.study.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GetUserInfo {
    @RequestMapping("getUserInfo")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    @RequestMapping("getUserInfo2")
    public Principal getPrincipal2() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
