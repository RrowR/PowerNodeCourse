package com.study;

import com.study.bean.Hero;
import com.study.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Hero hero;

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        System.out.println(hero);
    }

    @Test
    void test() {
        System.out.println(user);
    }


}
