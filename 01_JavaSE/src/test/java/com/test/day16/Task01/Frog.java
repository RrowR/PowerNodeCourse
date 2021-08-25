package com.test.day16.Task01;
/*
    青蛙类
 */
public class Frog extends Animal implements Swimming{

    public Frog(String name, String color, String kid) {
        super(name, color, kid);
    }

    @Override
    public void howl() {
        System.out.println("那只"+super.getColor()+"的"+",名叫"+super.getName()+"的青蛙"+"正在呱呱叫");
    }

    @Override
    public void eat() {
        System.out.println("青蛙是"+super.getKid()+",爱吃昆虫");
    }

    @Override
    public void swim() {
        System.out.println("虽然我不是鱼，但是青蛙也是游泳高手");
    }
}
