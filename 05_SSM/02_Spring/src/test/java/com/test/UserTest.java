package com.test;

import com.study.domain.Student;
import com.study.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    void TestBean(){
        // 加载配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//         从容器中获取对象,这里使用类名还是使用id都是可以的
        Object user = context.getBean("user");
        context.close();
    }

    @Test
    void TestBean2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Object user = context.getBean(Student.class);

    }

}
