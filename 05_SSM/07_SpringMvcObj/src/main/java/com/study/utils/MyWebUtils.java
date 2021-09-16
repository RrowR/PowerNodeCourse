package com.study.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



public class MyWebUtils {

    @Resource
    private HttpServletRequest request;

    public HttpServletRequest getRequest(){
        System.out.println(request);
        return request;
    }

}

