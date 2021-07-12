package com.test.day14.Task04;

public class Cylinder extends Circle{
    private double hight;

    public Cylinder(double radius, double hight) {
        super(radius);
        this.hight = hight;
    }

    public Cylinder() {
    }

    public double getVolume(){
        double perimeter = super.getPerimeter();
        return perimeter * hight;
    }

    public void showVolume(){
        System.out.println("圆柱体的体积为：" + getVolume());
    }
}
