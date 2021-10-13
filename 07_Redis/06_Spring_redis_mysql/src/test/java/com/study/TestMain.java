package com.study;

import com.study.domain.User;
import com.study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    /*
        测试配置文件是否成功
     */
    @Test
    void TestConfig(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        UserService service = context.getBean(UserService.class);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            User user = service.selectByPrimaryKey(1);
        }
        long time = System.currentTimeMillis()-start;
        System.out.println(time);
    }
}
