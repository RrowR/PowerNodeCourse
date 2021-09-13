package com.study.factory;

import com.study.domain.User;

public class UserFactory {
    public User getObj(){
        System.out.println("非静态工厂创建了...");
        return new User();
    }
}
