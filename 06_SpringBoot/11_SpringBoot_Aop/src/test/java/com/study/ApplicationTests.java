package com.study;

import com.study.bean.Man;
import com.study.bean.User;
import com.study.interfaces.Eat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    private Man man;

    @Autowired
    private Eat user;       // 注意: JDK代理注入的是接口

    @Test
    void contextLoads() {
        System.out.println("man.getClass().getSimpleName() = " + man.getClass().getSimpleName());
        man.eat("food");
    }

    @Test
    void contextLoads2() {
        System.out.println("user.getClass().getSimpleName() = " + user.getClass().getSimpleName());
        user.eat("food");
    }

}
