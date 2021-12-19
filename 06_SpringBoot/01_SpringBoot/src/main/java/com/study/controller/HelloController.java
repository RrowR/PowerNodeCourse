package com.study.controller;

import com.study.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("user1")
    private User user1;

    @Autowired
    @Qualifier("user2")
    private User user2;

    @Autowired
    @Qualifier("user4")
    private User user4;

    @RequestMapping("getUser")
    public User returnUser(){
        return user;
    }

    @RequestMapping("getUser1")
    public User returnUser1(){
        return user1;
    }

    @RequestMapping("getUser2")
    public User returnUser2(){
        return user2;
    }

    @RequestMapping("getUser4")
    public User returnUser4(){
        return user4;
    }
}
