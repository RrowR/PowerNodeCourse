package com.test.day17.project.stringmethod;

import java.util.Locale;

public class StringClass {
    public static void main(String[] args) {
//        Stringcompare02();
        StringUsuallyMethod03();
    }

    // String 的常用方法
    public static void StringUsuallyMethod03(){
        String s = "abcdefghijk123456789";
        System.out.println(s.length());
        System.out.println(s.toUpperCase());
        int i = s.indexOf("d");
        System.out.println(i);
        int i1 = s.lastIndexOf("8");
        System.out.println(i1);

    }

    // 字符串之间的比较
    public static void Stringcompare02(){
        String s1 = new String("123");
        String s2 = "123";
        String s3 = 123+"";
        String s4 = new String(new char[]{'1','2','3'});
        String s5 = new String(new byte[]{49,50,51});
        System.out.println(s5 == s4);
        System.out.println(s5.equals(s4));
    }

    // String 类的构造方法
    public static void StringConstructor01(){
        String s1 = new String("123");
        String s2 = "123";
        String s3 = 123+"";
        String s4 = new String(new char[]{'1','2','3'});
        String s5 = new String(new byte[]{65,66,67,68,69});
    }
}
