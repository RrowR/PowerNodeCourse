package com.test.day17;
/*
    兔子类
 */
public class Rabbit extends Animal{
    public Rabbit(String name, String color, String kid) {
        super(name, color, kid);
    }

    @Override
    public void howl() {
        System.out.println("我是"+super.getColor()+"的,名叫"+super.getName()+"的兔子"+"正在叽叽叫");
    }

    @Override
    public void eat() {
        System.out.println("兔子是"+super.getKid()+",爱吃胡萝卜");
    }
}
