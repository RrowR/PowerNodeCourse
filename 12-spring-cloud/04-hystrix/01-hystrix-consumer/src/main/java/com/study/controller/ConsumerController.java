package com.study.controller;

import com.study.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("getFood")
    public String getFood(){
        String food = providerFeign.makeFood();
        System.out.println(food);
        return food;
    }

}
