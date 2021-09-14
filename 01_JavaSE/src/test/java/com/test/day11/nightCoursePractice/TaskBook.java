package com.test.day11.nightCoursePractice;

import java.util.Date;

/**
 * 1.	开发一个表示图书的Book类，该类具有成员变量：编号、名称、作者、价格、出版社、出版日期等信息，同时该类还具有如下成员方法:
 * a)	以一个字符串的形式获得本书的编号、名称、作者和价格等信息。
 * b)	调整价格，以价格的变化量为参数。
 * 然后，开发一个测试类，测试Book类，具体要求如下：
 * c)	分别创建三个Book对象，通过对象.成员变量为各属性赋值。
 * d)	分别调整三个Book对象的价格，通过方法获得调整后的价格，并打印。
 * e)	打印三个Book对象的成员变量值
 */
public class TaskBook {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setNum("first");
        book1.setAuthor("hxd1");
        book1.setName("时间简史1");
        book1.setDate(new Date());
        book1.setPrice(100.0);
        book1.setPublishingHouse("东方出版社1");

        Book book2 = new Book();
        book2.setNum("second");
        book2.setAuthor("hxd2");
        book2.setName("时间简史2");
        book2.setDate(new Date());
        book2.setPrice(100.0);
        book2.setPublishingHouse("东方出版社2");

        Book book3 = new Book();
        book3.setAuthor("hxd3");
        book3.setName("时间简史3");
        book3.setDate(new Date());
        book3.setPrice(100.0);
        book3.setPublishingHouse("东方出版社3");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

    }
}
