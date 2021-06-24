package com.test.day02;

import org.junit.jupiter.api.Test;

public class Demo06ClassFacesExaminations {

    @Test
    public void test05(){
        /**
         * 两减一加
         */
        int a = 3;
        int b = 5;
        b = b - a;  //2 = 5 - 3;
        a = b + a;  //5 = 2 + 3;
        b = a - b;  //3 = 5 - 2;
        System.out.println("a="+a+" b="+b);
    }

    @Test
    public void test04(){
        /**
         * 需求，求出两数相加的整数部分
         * 计算的时候一定要注意：
         *      明确在强制类型转换的时候，可能会丢失精度，明确取值范围
         */
        float a = 3.75F;
        float b = 2.53F;
        int c = (int)(a+b);
        int d = (int)a + (int)b;
        System.out.println(c);
        System.out.println(d);
    }

    @Test
    public void test03(){
        /**
         * 求出2个小数之和，并且结果只保留小数部分
          */
        int a = (int)(3.14 + 2.46);
        System.out.println(a);
    }

    @Test
    public void test02(){
        /**
         * 这里将会进行向上转型，结果为最大类型
         */
        float b1 = 10.1F;
        byte b2 = 20;
        float f = b1 + b2;
        System.out.println(f);
    }

    @Test
    public void test01(){
        /**
         * 注意：当数据类型的大小小于int的时候，结果将自动提升为int类型
         */
        byte b1 = 12;
        byte b2 = 13;
        short s1 = 22;
        short s2 = 23;
        int i1 = b1 + b2;
        //如果想强制为byte需要进行强制转换
        byte i11 = (byte)(b1 + b2);
        int i2 = s1 + s2;
        System.out.println(i1);
        System.out.println(i2);
    }
}
