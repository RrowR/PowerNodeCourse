package com.test.day12.nighthomework.work2.code03;

/**
 * 定义一个圆类——Circle，在类的内部提供一个属性：半径(r)，同时 提供 两个 方 法 ：
 * 计算 面积 （ getArea() ） 和 计算 周长（getPerimeter()） 。
 * 通过两个方法计算圆的周长和面积并且对计算结果进行输出。最后定义一个测试类对 Circle 类进行使用。
 */
public class Circle {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public Circle() {
    }

    double getArea(){
        return 3.14 * r * r;
    }

    double getPerimeter(){
        return 2 * 3.14 * r;
    }
}
