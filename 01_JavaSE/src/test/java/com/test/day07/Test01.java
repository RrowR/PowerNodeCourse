package com.test.day07;

import org.junit.jupiter.api.Test;

public class Test01 {
    @Test
    public void test01() {
        for (int i = 0; i < 6; i++) {
            int k = ++i;
            while (k < 5) {
                System.out.print(i);
                break;
            }
        }
    }

    @Test
    public void test02() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            do {
                i++;                // 2 4 6
                if (i % 2 != 0)
                    sum += i;
            } while (i < 6);
        }
        System.out.println(sum);
    }

    @Test
    public void test03(){
        int i = 99;
        mb_operate(i);
        System.out.print(i + 100);
    }
    static void mb_operate(int i) {
        i += 100;
    }
}

