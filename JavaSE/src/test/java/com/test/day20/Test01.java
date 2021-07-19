package com.test.day20;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

public class Test01 {

    @Test
    public void Task01(){
        Student student = new Student("小明",12);
        System.out.println(student);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Student{
        private String name;
        private int age;
    }
}
