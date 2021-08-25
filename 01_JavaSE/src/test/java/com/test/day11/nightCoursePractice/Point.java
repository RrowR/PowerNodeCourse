package com.test.day11.nightCoursePractice;

import lombok.Data;

/**
 * 	开发一个表示坐标点的类Point，该类对外提供以下成员方法：
 * 	设置横纵坐标
 * 	偏移横坐标
 * 	偏移纵坐标
 * 	偏移横纵坐标
 * 	求本点到另外一个点的距离
 * 然后，开发一个测试类，对上述Point类进行测试
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public double getDistance(Point point){
        return Math.sqrt(Math.pow(this.x - point.x,2) + Math.pow(this.y - point.y,2));
    }
}
