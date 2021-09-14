package com.test.day99finalTask.task05;

import com.test.day19.Student;

public class TestJson {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(JsonUtils.toJsonString(student));
    }
}