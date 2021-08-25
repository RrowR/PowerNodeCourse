package com.test.day18.test;

public class Testwork {
    public static void main(String[] args) {
        /*
             String concat(String str)
            将指定字符串连接到此字符串的结尾。
         */
        // concat 方法的时候，添加一个新字符串，要接收返回的字符串才行
        String str = "ccc";
        String concat = str.concat("kkk");
        System.out.println(concat);
    }
}
