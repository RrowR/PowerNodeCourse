package com.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMsgController {
    @GetMapping("clientmsg")
    public String sendMsg(){
        return "我是消息的提供者";
    }
}
