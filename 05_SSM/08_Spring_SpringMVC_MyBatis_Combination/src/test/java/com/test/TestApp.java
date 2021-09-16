package com.test;

import com.study.domain.User;
import com.study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    @Test
    void TestQuery(){
        // 读取spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        UserService service = context.getBean(UserService.class);
        User user = service.queryUserById(1);
        System.out.println(user);


    }
}
