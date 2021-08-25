package com.test.day17.project.packaging;

import org.junit.Test;

public class VariousBasicPackaingClass {

    /*
        包装类转换成String类型
     */
    @Test
    public void ConverToString(){
        // int 转String
        String s = new Integer(123).toString();
        System.out.println(s);

        // Integer转换成二进制字符串
        String s1 = Integer.toBinaryString(123);
        System.out.println(s1);

        // Integer转成八进制字符串
        String s2 = Integer.toOctalString(123);
        System.out.println(s2);

        // Integer转换成十六进制字符串
        String s3 = Integer.toHexString(123);
        System.out.println(s3);

        // Integer转换成十六进制的字符串的多参数构造方法
        String s4 = Integer.toString(123, 8);
        System.out.println(s4);
    }
}
