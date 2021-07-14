package com.test.day17;

import java.util.Scanner;

/**
 * 1.	编写程序接收用户输入分数信息，如果分数在0—100之间，输出成绩。如果成绩不在该范围内，抛出异常信息，提示分数必须在0—100之间。
 * 要求：使用自定义异常实现
 */
public class TestCustomerException {
    public static void main(String[] args) throws CustomerException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个0~100之间的数");
        int num = input.nextInt();
        if (num < 0 || num > 100){
            throw new CustomerException("您输入的值不对");
        }else {
            System.out.println("数值正确");
        }
    }
}
