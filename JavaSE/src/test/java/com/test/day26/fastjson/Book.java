package com.test.day26.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Book {
    private String isbn;
    @JSONField(serialize = false)    // FastJson里的注解，当标注字段的序列化值为false时，此对象的这个属性将不会序列化成json字符串
    private String name;
    private String author;
    @JSONField(format = "yyyy-MM-dd")
    private Date pubTime;

    public Book(String isbn, String name, String author, Date pubTime) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.pubTime = pubTime;
    }

    public Book() {
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }
}
