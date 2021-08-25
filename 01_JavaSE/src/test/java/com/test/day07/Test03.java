package com.test.day07;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int number = input.nextInt();
        judgeNumber(number);
    }

    private static void judgeNumber(int number) {
        boolean flag = true;
        for (int i = 2;i < number;i++){
            /*  这里是错的，这里是要么是质数，要么就不是质数，而在除的过程中会打印很多次语句（不是质数，是质数）
            if (number % i == 0){
                System.out.println("您输入的数"+number+"不是一个质数");
            }else {
                System.out.println("您输入的数"+number+"是质数");
            }*/
            // 这里当i判断到不是一个质数的时候，将flag改为false，然后使用break跳出整个循环
            if (number % i == 0){
                System.out.println("您输入的数"+number+"不是一个质数");
                flag = false;
                break;      // break 会跳出整个for循环不会再执行
            }
        }
        if (flag == true){
            System.out.println("您输入的数"+number+"是一个质数");
        }
    }
}
