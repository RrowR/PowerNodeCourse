package com.test.day21;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student("猫羽雫", 16, "17777212100");
        Student s2 = new Student("镜华", 12, "17777212101");
        Student s3 = new Student("美美", 10, "17777212102");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.remove(s3);
        System.out.println(students);
        HashMap<String, LinkedList> map = new HashMap<>();
    }
}
