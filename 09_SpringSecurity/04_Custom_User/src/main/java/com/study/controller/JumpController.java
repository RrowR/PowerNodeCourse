package com.study.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("toAdd")
    @PreAuthorize("hasAnyAuthority('user:save')")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("toDel")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public String toDel(){
        return "del";
    }

    @RequestMapping("toUpdate")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public String toUpdate(){
        return "update";
    }

    @PreAuthorize("hasAnyAuthority('user:query')")
    @RequestMapping("toQuery")
    public String toQuery(){
        return "query";
    }

    @PreAuthorize("hasAnyAuthority('user:export')")
    @RequestMapping("toExport")
    public String toExport(){
        return "export";
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
