package com.study;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        // 传入UserService和UserServiceImpl都是可以的
        UserService userService = context.getBean(UserService.class);
        User user = userService.selectByPrimaryKey(1);
        user.setName("Nya");
        userService.insert(user);
    }
}
