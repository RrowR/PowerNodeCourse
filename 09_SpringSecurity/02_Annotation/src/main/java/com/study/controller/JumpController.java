package com.study.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JumpController {

    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("fail")
    public String fail(){
        return "fail";
    }

    @RequestMapping("free")
    @ResponseBody
    public String free(){
        return "jumped to free";
    }


    @RequestMapping("add")
    @ResponseBody
    @PreAuthorize("hasAuthority('sec:add')")
    public String add(){
        return "jumped to add";
    }

    @PreAuthorize("hasAuthority('sec:del')")
    @ResponseBody
    @RequestMapping("del")
    public String del(){
        return "jumped to del";
    }

    @PreAuthorize("hasAuthority('sec:update')")
    @ResponseBody
    @RequestMapping("update")
    public String update(){
        return "jumped to update";
    }

    @PreAuthorize("hasAuthority('sec:query')")
    @ResponseBody
    @RequestMapping("query")
    public String query(){
        return "jumped to query";
    }


    @RequestMapping("other")
    @ResponseBody
    public String other(){
        return "anywhere pages is me";
    }


}
