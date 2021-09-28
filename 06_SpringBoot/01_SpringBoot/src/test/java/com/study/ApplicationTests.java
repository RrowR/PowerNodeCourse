package com.study;

import com.study.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
class ApplicationTests {

    @Autowired
    @Qualifier("user3")         // 选择到底是哪一个对象
    private User user;

    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
