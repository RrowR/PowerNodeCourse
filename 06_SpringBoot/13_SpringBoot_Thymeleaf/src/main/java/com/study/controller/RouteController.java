package com.study.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class RouteController {

    // 可以在接受的参数上写入传入的字符串格式并自动转换成date类型
    @ResponseBody
    @RequestMapping("dateFormat")
    public String getFrontData(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println(date);
        return "ok";
    }

    // 不想在请求方法上添加参数，可以在配置文件里统一进行配置
    @ResponseBody
    @RequestMapping("dateFormat2")
    public String getFrontData2(Date date){
        System.out.println(date);
        return "ok";
    }

    // 使用LocalDate可以直接获得配置文件配置的指定字符串格式类型的LocalDate对象
    @ResponseBody
    @RequestMapping("dateFormat3")
    public String getFrontData3(LocalDate localDate){
        System.out.println(localDate);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("dateFormat4")
    public String getFrontData4(LocalDateTime dateTime){
        System.out.println(dateTime);
        return "ok";
    }
}
