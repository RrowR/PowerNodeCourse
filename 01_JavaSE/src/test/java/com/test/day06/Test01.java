package com.test.day06;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Test01 {
    @Test
    public void test01() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            break;
        }
    }

    @Test
    public void test02() {
        int i = 1;
        System.out.println(i / 2);
    }

    /**
     * ++a 先+1 再赋值 == 2     a++ 先赋值 再+1  == 1
     */
    @Test
    public void test03() {
        int a = 1;
        int b = ++a;
        System.out.println(b);
    }

    @Test
    public void test04() {
        // 测试开次方的方法
        double pow = Math.pow(10, 2);
        System.out.println(pow);
    }

    @Test
    public void test05() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个年份：");
        int year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("是闰年");
        } else {
            System.out.println("不是闰年");
        }


    }
}
