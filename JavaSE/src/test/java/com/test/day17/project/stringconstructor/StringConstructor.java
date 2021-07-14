package com.test.day17.project.stringconstructor;

public class StringConstructor {
    public static void main(String[] args) {
        String s1 = new String("123");
        String s2 = "123";
        String s3 = 123+"";
        String s4 = new String(new char[]{'1','2','3'});
        String s5 = new String(new byte[]{65,66,67,68,69});
        System.out.println(s5);
    }
}
