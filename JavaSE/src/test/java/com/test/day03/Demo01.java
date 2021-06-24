package com.test.day03;

import org.junit.jupiter.api.Test;

public class Demo01 {

    @Test
    /**
     * 扩展赋值运算符:
     *      不仅把右边看作一个整体，并且还会将右边整体的数据强转成左边数据的类型
     */
    public void test04(){
        short a = 2;
        a += a + 1;
    }

    @Test
    public void test01() {
        int a = 10;
        int b = 5;
        int c = b++ + a;     //这里的b++仅仅只是5，运算的时候还是5
        int d = ++b + a;     //这里是先自增，再进行运算  b = 6 + 1 = 7
        System.out.println(c);
        System.out.println(d);
    }
}
