package com.test.day99finalTask.task06;

import com.test.day99finalTask.task06.annotations.JsonFormat;
import com.test.day99finalTask.task06.annotations.JsonResetName;
import com.test.day99finalTask.task06.annotations.Jsonignore;

import java.util.Date;

public class Person {
    @Jsonignore
    private int id;

    @JsonResetName(reName = "user_name")
    private String name;

    private int age;

    @JsonFormat(redate = "yyyy=MM=dd")
    private Date birth;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    public Person() {
    }

    public Person(int id, String name, int age, Date birth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
