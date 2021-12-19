package com.study;

import com.study.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private User user;


    @Test
    void contextLoads() {
        /*
            不同频道下执行的配置文件不同，返回的bean对象也会不同
         */
        System.out.println("user = " + user);
    }

}
