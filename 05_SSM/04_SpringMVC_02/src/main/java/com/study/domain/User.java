package com.study.domain;


public class User {
    private String username;
    private int age;
    private String address;

    public User(String username, int age, String address) {
        this.username = username;
        this.age = age;
        this.address = address;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
