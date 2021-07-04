package com.test.day10;

import java.util.Scanner;

/**
 * 数组查找操作：定义一个长度为10 的一维字符串数组，在每一个元素存放一个单词；
 * 然后运行时从命令行输入一个单词，程序判断数组是否包含有这个单词，包含这个单词就打印出“Yes”，不包含就打印出“No”。
 */
public class Question1 {
    public static void main(String[] args) {
        String[] arr = {"one","two","three","four","five","six","seven","eight","night","ten"};
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个数: ");
        String next = input.next();
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (next.equals(arr[i])){
                flag = true;
            }
        }
        if (flag == true){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
