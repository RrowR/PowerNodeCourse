package com.study;

import com.study.domain.User;
import com.study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    使用Redis来作为缓存
 */
public class TestToRedis {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
    private UserService service = context.getBean(UserService.class);

    @Test
    void TestQueryUserForRedis(){
        User user = service.selectByPrimaryKey(8);
        System.out.println(user);
    }

    @Test
    void TestQueryUserForRedis2(){
        User user = null;
        long s = System.currentTimeMillis();
        for (int i = 0 ; i < 1000 ; i++) {
            user = service.selectByPrimaryKey(8);
        }
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
}
