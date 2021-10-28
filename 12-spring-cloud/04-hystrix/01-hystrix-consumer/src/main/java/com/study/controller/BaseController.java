package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("base")
public class BaseController {

    /**
     * Ribbon的熔断方法，方法名就是rallback指示的名字，serviceName就是服务名
     * @param serviceName
     * @return
     */
    public String testRibbonHystrixFallback(String serviceName) {
        return "我是ribbon的备胎";
    }
}
