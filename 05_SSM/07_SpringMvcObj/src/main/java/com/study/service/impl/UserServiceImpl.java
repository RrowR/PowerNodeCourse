package com.study.service.impl;

import com.study.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service        // 使UserService被IOC容器所管理，并且需要开启扫描到这个service包下
public class UserServiceImpl implements UserService {

    // 这个Service已经被IOC管理了，等会我们会测试没有被管理的情况
    @Resource
    private HttpServletRequest request;

    @Override
    public Object getReq() {
        return request;
    }
}
