package com.study.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JumpController {

    @RequestMapping("add")
    @PreAuthorize("hasAuthority('auth:add')")
    public String doAdd() {
        return "我做了add";
    }

    @RequestMapping("del")
    @PreAuthorize("hasAuthority('auth:del')")
    public String doDel() {
        return "我做了del";
    }

    @RequestMapping("others")
    public String others() {
        return "我是其他请求";
    }

}
