package com.test.day06;

import org.junit.jupiter.api.Test;

public class Test01 {
    @Test
    public void test01(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            break;
        }
    }

    @Test
    public void test02(){
        int i = 1;
        System.out.println(i/2);
    }

    /**
     * ++a 先+1 再赋值 == 2     a++ 先赋值 再+1  == 1
     */
    @Test
    public void test03(){
        int a = 1;
        int b = ++a;
        System.out.println(b);
    }
}
