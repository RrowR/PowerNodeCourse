package com.study;

import com.study.domain.User;
import com.study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class TestMain {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
    private UserService service = context.getBean(UserService.class);

    /*
        测试配置文件是否成功
     */
    @Test
    void TestConfig() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            User user = service.selectByPrimaryKey(1);
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);
    }

    /*
        出现脏读，没清缓存
     */
    @Test
    void TestDirtyRead(){
        System.out.println(service.selectByPrimaryKey(2));
        service.deleteByPrimaryKey(2);
        System.out.println(service.selectByPrimaryKey(2));
    }

    /*
        在插入的时候也应该清空all的缓存，并添加缓存
     */
    @Test
    void TestInsert(){
        service.insert(User.builder()
                .name("nachaco")
                .address("pisiv")
                .birth(new Date())
                .flag(1)
                .build()
        );
    }

    @Test
    void TestSpecialAll(){
        System.out.println(service.selectAll());
        TestInsert();
        List<User> users = service.selectAll();
        System.out.println(users);
        System.out.println(service.selectAll());
    }
}
