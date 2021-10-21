package com.study;

import com.study.domain.User;
import com.study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = userService.selectByPrimaryKey(15);
        System.out.println(user);
    }

    @Test
    void Test02(){
//        List<User> users = userService.selectAll();
//        System.out.println(users);
        System.out.println(userService.selectByPrimaryKey(8));
    }

}
