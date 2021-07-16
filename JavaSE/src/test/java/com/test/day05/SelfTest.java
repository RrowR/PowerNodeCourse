package com.test.day05;

import org.junit.Test;

public class SelfTest {
    @Test
    public void test01(){
        /**
         * 获取各个位数
         */
        int a = 9876;
        //求个位数
        int b = a % 10;
        System.out.println(b);
        //求十位数
        int c = a / 10 % 10;
        System.out.println(c);
        //求百位数
        int d = a / 100 % 10;
        System.out.println(d);
        //求千位数
        int e = a / 1000 % 10;
        System.out.println(e);
    }

    @Test
    public void test02(){
        int random = (int)(Math.random()*31) + 30;
        System.out.println(random);
    }
}
