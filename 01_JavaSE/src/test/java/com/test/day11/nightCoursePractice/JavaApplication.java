package com.test.day11.nightCoursePractice;

import lombok.Data;

import java.util.Date;

/**
 * 开发一个Java应用，要求如下：
 * a) 能够从控制台录入若干书的信息
 * b) 能够在控制台打印输出所录入的书的信息
 * c) 书的信息包括编号、名称、作者、价格、出版社、出版日期等。
 */
@Data
public class JavaApplication {
    private String bookNum;
    private String bookName;
    private String author;
    private Double price;
    private String publishedHouse;
    private Date publishTime;
}
