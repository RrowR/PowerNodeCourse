package com.study.demo10;

import com.study.demo10.entity.Student;
import org.junit.Test;

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
}
