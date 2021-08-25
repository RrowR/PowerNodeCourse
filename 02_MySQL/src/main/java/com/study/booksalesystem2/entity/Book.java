package com.study.booksalesystem2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private Date publishTime;
    private Double price;
    private Integer num;
}
