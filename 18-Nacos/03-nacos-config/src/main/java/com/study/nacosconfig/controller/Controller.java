package com.study.nacosconfig.controller;

import com.study.nacosconfig.domain.Hero;
import com.study.nacosconfig.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private User user;

    @Autowired
    private Hero hero;

    @GetMapping("getUser")
    public String getUser(){
        return user.toString() + hero;
    }

}
