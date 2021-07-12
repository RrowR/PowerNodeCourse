package com.test.day14.Task04;

/**
 * 2.	编写应用程序，创建类的对象，分别设置圆的半径、圆柱体的高，计算并分别显示圆半径、圆面积、圆周长，圆柱体的体积。
 */
public class Circle {
    public static final double PI = 3.1415926;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getArea(){
        return PI * Math.pow(radius,2);
    }

    public double getPerimeter(){
        return PI * 2 * radius;
    }

    public void show(){
        System.out.println("圆半径为："+radius);
        System.out.println("圆面积为: "+this.getArea());
        System.out.println("圆周长为："+this.getPerimeter());

    }
}
