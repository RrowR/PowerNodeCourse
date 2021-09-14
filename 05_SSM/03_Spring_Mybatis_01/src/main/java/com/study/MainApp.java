package com.study;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        UserService userService = context.getBean(UserServiceImpl.class);
        User user = userService.selectByPrimaryKey(2);
        System.out.println(user);
    }
}
