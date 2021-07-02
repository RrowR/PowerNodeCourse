package com.test.day09;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class ClassExaminations {
    @Test
    public void findRunYear() {
        for (int i = 2000; i <= 2030; i++) {
            if (i % 4 == 0 && i % 400 != 0 || i % 100 == 0) {
                System.out.println("从2000~2030之间的闰年有:" + i);
            }
        }
    }

    @Test
    public void sumMoney() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的本金：");
        double money = input.nextDouble();
        for (int i = 1; i <= 4; i++) {
            switch (i) {
                case 1:
                    System.out.println("您的第" + i + "年本金为" + money + "利息为:" + money * 0.0225);
                break;
                case 2:
                    System.out.println("您的第" + i + "年本金为" + (money * 0.0270 + money) + "利息为:" + ((money * 0.0270 + money) * 0.027));
                break;
                case 3:
                    System.out.println("您的第" + i + "年本金为" + ((money * 0.0324 + money) + ((money * 0.0324 + money) * 0.0324))  + "利息为:" + (0.0324 * ((money * 0.0324 + money) + ((money * 0.0324 + money) * 0.0324))));
                break;
                case 4:
                    System.out.println("您的第" + i + "年本金为" + (((money * 0.0360 + money) + ((money * 0.0360 + money) * 0.0360))+(0.0360 * ((money * 0.0360 + money) + ((money * 0.0360 + money) * 0.0360)))) + "利息为:"+(0.0360 * (((money * 0.0360 + money) + ((money * 0.0360 + money) * 0.0360))+(0.0360 * ((money * 0.0360 + money) + ((money * 0.0360 + money) * 0.0360))))));
                break;
            }
        }
    }

    @Test
    public void thirdAnswer(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入四位整数");
        int number = input.nextInt();
        int sum = 0;
        int[] arr = new int[4];
        arr[3] = (int)(number / 1 % 10);        // 第一位
        arr[2] = (int)(number / 10 % 10);       // 第二位
        arr[1] = (int)(number / 100 % 10);      // 第三位
        arr[0] = (int)(number / 1000 % 10);     // 第四位
        for (int i = 0; i < 4 ; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    @Test
    public void thirdAnswer2(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int number = input.nextInt();
        int sum = 0;
        for (int i = 1; (number / i) > 0 ; i *= 10) {
            sum += (int)(number / i % 10);
        }
        System.out.println(sum);
    }

    @Test
    public void sumDigit() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数:");
        int number = input.nextInt();
        int gewei = number % 10;

    }
}
