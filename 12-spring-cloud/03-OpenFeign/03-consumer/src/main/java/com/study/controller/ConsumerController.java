package com.study.controller;

import com.study.feign.ConsumerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerFeign consumerFeign;

    @GetMapping("feignmethod")
    public String consumerOrder(){
        String result = consumerFeign.doOrderkkk();
        System.out.println(result);
        return result;
    }
}
