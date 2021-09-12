package com.study.domain;

public class TestInjectUser01 {
    private String name;
    private int age;

    public TestInjectUser01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestInjectUser01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
