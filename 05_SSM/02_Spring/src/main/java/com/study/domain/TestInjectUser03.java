package com.study.domain;

public class TestInjectUser03 {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "TestInjectUser01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
