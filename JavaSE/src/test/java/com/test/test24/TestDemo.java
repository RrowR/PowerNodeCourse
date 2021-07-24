package com.test.test24;

import org.junit.Test;

public class TestDemo {
    @Test
    public void method01(){
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
