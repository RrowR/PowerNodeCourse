package com.study;

import com.study.bean.Student;
import com.study.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private User user;
    @Autowired
    private Student student;


    @Test
    void contextLoads() {
        System.out.println("user = " + user);
    }

    @Test       // 测试自己导入的配置文件的bean对象
    void Test02(){
        System.out.println("student = " + student);
    }

}
