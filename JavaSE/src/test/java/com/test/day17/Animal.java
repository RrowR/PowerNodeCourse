package com.test.day17;

/*
    这里的抽象类是不能被初始化的，所以构造方法几乎无用
 */
public abstract class Animal {
    // 定义名字
    private String name;
    // 定义颜色
    private String color;
    // 定义类别
    private String kid;

    public Animal(String name, String color, String kid) {
        this.name = name;
        this.color = color;
        this.kid = kid;
    }

    public void eat(){

    }

    public void howl(){

    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getKid() {
        return kid;
    }
}
