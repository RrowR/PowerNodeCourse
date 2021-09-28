package com.study;

import com.study.bean.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Hero hero;

    @Test
    void contextLoads() {
        System.out.println(hero);
    }

}
