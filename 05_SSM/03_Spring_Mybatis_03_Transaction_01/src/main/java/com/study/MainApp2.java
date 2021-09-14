package com.study;

import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  这里需要传一个接口才可以触发事务，不能是实现类
 */
public class MainApp2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        UserService userService = context.getBean(UserService.class);
        userService.deleteByPrimaryKey(31);
    }
}
