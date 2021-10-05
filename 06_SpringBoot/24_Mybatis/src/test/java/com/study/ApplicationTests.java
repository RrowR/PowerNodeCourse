package com.study;

import com.github.pagehelper.Page;
import com.study.domain.User;
import com.study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = userService.selectByPrimaryKey(1);
        System.out.println(user);

    }

    /*
        使用pagehelper进行分页查询
     */
    @Test
    void TestPageHelper(){
        Page<User> page = userService.queryForPage(1,2);
        System.out.println(page);
    }

}
