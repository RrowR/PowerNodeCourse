package com.study.utils;

import com.study.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyWebUtils {
    @Resource
    private HttpServletRequest request;

    public HttpServletRequest getRequest(){
        return request;
    }

}

