package com.test.day14.testPermissionModifier03;
// default 修饰的修饰符只能在同一个包下使用
/*
    用protected修饰的类、方法、变量，包内的任何类以及包外继承了该类的子类才能进行访问,子包都不可以
    重点是：包外继承了该类的子类才可以进行访问，意思市protected修饰的类中的方法和成员变量，
    只能被子类访问，不论这个子类和父类是否在同一个包中
*/
public class A14 {
    protected void method(){
        System.out.println("protected method run...");
    }
}
