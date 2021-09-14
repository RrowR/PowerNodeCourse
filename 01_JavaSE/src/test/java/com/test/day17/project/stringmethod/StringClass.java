package com.test.day17.project.stringmethod;

import org.junit.Test;

public class StringClass {
    /*
        无视字母大小写比较2个字符串的内容是否相同
     */
    @Test
    public void String(){
        String s1 = "dsad222";
        String s2 = "DSAD222";
        String s3 = "D2SAD222";
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s1.compareToIgnoreCase(s3));
    }

    /*
        去掉字符串 两边的空格
     */
    @Test
    public void Stringtrim(){
        System.out.println("    asdsadsad  ".trim());
    }

    /*
        返回任意类型的字符串表示形式
     */
    @Test
    public void StringvalueOf(){
        System.out.println(String.valueOf("dsadas"));
        System.out.println(String.valueOf(132));
        System.out.println(String.valueOf(123.2));
        System.out.println(String.valueOf(true));
    }

    /*
        按照字典顺序进行比较：
            当大于是返回整数
            当小于时返回负数
            当等于时返回0
     */
    @Test
    public void StringcompareTo(){
        String s = "abc";
        String s2 = "acd";
        String s3 = "ace";
        System.out.println(s.compareTo(s2));
        System.out.println(s2.compareTo(s3));
        System.out.println(s3.compareTo(s2));
    }

    /*
        判断一个字符串内容是否为空
     */
    @Test
    public void StringisEmpty(){
        String s = "sda123a456a789";
        String s2 = "";
        System.out.println(s.isEmpty());
        System.out.println(s2.isEmpty());
    }

    /*
        将字符串转换成大小写的方法
     */
    @Test
    public void StringToUpcaseToLowerCase(){
        String s = "sda123a456a789";
        System.out.println(s.toUpperCase());
        System.out.println(s.toUpperCase().toLowerCase());
    }

    /*
        根据指定字符串进行分割，结果返回一个数组
     */
    @Test
    public void Stringsplit(){
        String s = "sda123a456a789";
        String[] split = s.split("a");
        for (String arr : split) {
            System.out.println(arr);
        }
    }

    // 根据指定索引位置进行截取获得新字符串
    @Test
    public void StringsubString06() {
        String s = "a123a456a789";
        String substring = s.substring(3);
        System.out.println(substring);      // 3a456a789
    }

    // 获得指定索引位置的字符
    @Test
    public void StringcharAt05() {
        String s = "a123a456a789";
        System.out.println(s.charAt(5));        // 4
    }


    // String indexOf(String str) 返回指定字符在字符串里最后出现一次的索引位置
    public static void StringlastIndexOf04() {
        String s = "a123a456a789";
        System.out.println(s.lastIndexOf("a"));
    }

    // String 的常用方法
    @Test
    public void StringUsuallyMethod03(){
        String s = "abcdefghijk123456789";
        System.out.println(s.length());
        System.out.println(s.toUpperCase());
        int i = s.indexOf("d");
        System.out.println(i);
        // 获得单个字符在字符串里的索引
        int i1 = s.lastIndexOf("8");
        System.out.println(i1);

    }

    // 字符串之间的比较
    @Test
    public void Stringcompare02(){
        String s1 = new String("123");
        String s2 = "123";
        String s3 = 123+"";
        String s4 = new String(new char[]{'1','2','3'});
        String s5 = new String(new byte[]{49,50,51});
        System.out.println(s5 == s4);
        System.out.println(s5.equals(s4));
    }

    // String 类的构造方法
    @Test
    public void StringConstructor01(){
        String s1 = new String("123");
        String s2 = "123";
        String s3 = 123+"";
        String s4 = new String(new char[]{'1','2','3'});
        String s5 = new String(new byte[]{65,66,67,68,69});
    }
}
