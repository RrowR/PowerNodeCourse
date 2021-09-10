package com.study.domain;



import java.util.Date;

/**
 *  注意想测试spring的protoype不能使用lombok对象，使用了lombok那么这个对象是一个单例的
 */
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private Date birth;

    public User() {
    }
}
