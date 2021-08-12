package com.study.demo10.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private String sex;
    private Date birth;
}
