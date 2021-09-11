package com.study.factory;

import com.study.domain.User;

public class UserStaticFactory {
    public static User getObj(){
        System.out.println("静态工厂创建了...");
        return new User();
    }
}
