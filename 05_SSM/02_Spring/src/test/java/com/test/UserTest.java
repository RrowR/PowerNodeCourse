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
        /*
            当获取容器为字节码的时候,如果其中有2个对象的字节码是同一个对象，那么Spring将无法区分到底使用哪个字节码
            我们需要对其中一个字节码添加primary属性，才可以生效，而不能达到3个，否则一个有primary另一个又不知道了
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Object user = context.getBean(Student.class);
    }



}
