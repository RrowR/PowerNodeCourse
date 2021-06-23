package com.test.day02;

import org.junit.jupiter.api.Test;

public class Demo06ClassFacesExaminations {
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
