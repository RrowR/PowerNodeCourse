package com.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JumpController {
    @RequestMapping("welcome")
    public String welcome(){
        return "jumped to welcome";
    }

    @RequestMapping("login")
    public String login(){
        return "jumped to login";
    }

    @RequestMapping("free")
    public String free(){
        return "jumped to free";
    }

    @RequestMapping("add")
    public String add(){
        return "jumped to add";
    }

    @RequestMapping("del")
    public String del(){
        return "jumped to del";
    }

    @RequestMapping("update")
    public String update(){
        return "jumped to update";
    }

    @RequestMapping("query")
    public String query(){
        return "jumped to query";
    }

    @RequestMapping("fail")
    public String fail(){
        return "this is fail page";
    }

    @RequestMapping("other")
    public String other(){
        return "anywhere pages is me";
    }


}
