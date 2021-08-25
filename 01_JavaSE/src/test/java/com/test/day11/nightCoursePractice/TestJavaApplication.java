package com.test.day11.nightCoursePractice;

import java.util.Date;
import java.util.Scanner;

/**
 * 开发一个Java应用，要求如下：
 * a) 能够从控制台录入若干书的信息
 * b) 能够在控制台打印输出所录入的书的信息
 * c) 书的信息包括编号、名称、作者、价格、出版社、出版日期等。
 */
public class TestJavaApplication {
    public static void main(String[] args) {
        JavaApplication japp = new JavaApplication();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入书籍编号:");
        String bookNum = input.next();
        System.out.println("请输入书籍名称:");
        String bookName = input.next();
        System.out.println("请输入书籍作者");
        String author = input.next();
        System.out.println("请输入书籍价格:");
        double price = input.nextDouble();
        System.out.println("请输入书的出版商:");
        String publishedHouse = input.next();
        japp.setBookNum(bookNum);
        japp.setBookName(bookName);
        japp.setAuthor(author);
        japp.setPrice(price);
        japp.setPublishedHouse(publishedHouse);
        japp.setPublishTime(new Date());
        System.out.println("=====================================================");
        System.out.println(japp);

    }
}
