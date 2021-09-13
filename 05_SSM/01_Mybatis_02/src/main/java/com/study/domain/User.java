package com.study.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private Date birth;

    public User(String name, Integer age, String sex, String address, Date birth) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.birth = birth;
    }
}
