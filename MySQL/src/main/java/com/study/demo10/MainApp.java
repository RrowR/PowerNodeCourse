package com.study.demo10;

import com.study.demo10.entity.Student;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MainApp {
    /*
        查询所有
     */
    @Test
    public void method01(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.queryAllStudent();
        students.forEach(System.out::println);
    }

    @Test
    public void method02(){
        /*
            根据id单个查询
         */
        StudentDao dao = new StudentDaoImpl();
        Student student = dao.queryStudentById(1);
        System.out.println(student);
    }

    @Test
    public void method03(){
        /*
            插入一个学生对象
         */
        StudentDao dao = new StudentDaoImpl();
        Student 猫羽雫 = new Student(null, "猫羽雫", "maoyuna@twiter.com", 16, "女", new Date());
        Student 美美 = new Student(null, "美美", "meimei@princessConnector.com", 12, "女", new Date());
        int i = dao.addStudent(美美);
        System.out.println(i);
    }
}
