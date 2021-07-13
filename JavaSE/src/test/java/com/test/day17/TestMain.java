package com.test.day17;
/*
    测试主类
 */
public class TestMain {
    public static void main(String[] args) {
        Animal rabbit = new Rabbit("兔子", "黑色", "哺乳类");
        rabbit.howl();
        rabbit.eat();
        System.out.println("------------------------------------------------------");
        Animal frog = new Frog("青蛙","绿色","非哺乳类");
        frog.howl();
        frog.eat();
        // 向下转型成子类才可以调用接口里的方法
        ((Frog) frog).swim();
    }
}
