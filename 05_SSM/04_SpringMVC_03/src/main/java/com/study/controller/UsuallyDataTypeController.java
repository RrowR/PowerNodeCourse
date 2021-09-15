package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UsuallyDataTypeController {
    /**
     * @param map 当前端传过来的数据后端使用mao来进行接收的时候，需要使用@RequestParam才能进行接收
     * @return
     */
    @RequestMapping("getMap.do")
    public String getMapData(@RequestParam Map<String,Object> map){
        System.out.println(map);
        return "../success.jsp";
    }

    @RequestMapping("getArr.do")
    public String getArrData(String[] list){
        System.out.println(Arrays.toString(list));
        return "../success.jsp";
    }

    @RequestMapping("getArr2.do")
    public String getArrData2(@RequestParam("List") String[] list){
        System.out.println(Arrays.toString(list));
        return "../success.jsp";
    }
}
