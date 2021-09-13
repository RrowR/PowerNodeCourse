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
        System.out.println("我User被调用了...");
    }

    private void init() {
        System.out.println("打印了初始化的方法...");
    }


    private void destroy() {
        System.out.println("打印了销毁的方法");
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}';
    }
}
