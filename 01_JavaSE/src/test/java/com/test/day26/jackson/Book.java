package com.test.day26.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Book {
    private String isbn;
    private String name;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pubTime=" + pubTime +
                '}';
    }
}
