package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TransferData {
    @GetMapping("testTransferData")
    @ResponseBody
    public void getData(String name,String password){
        System.out.println(name);
        System.out.println(password);
    }

    @RequestMapping("transferButton")
    public String totransferButton(){
        return "transferButton";
    }
}
