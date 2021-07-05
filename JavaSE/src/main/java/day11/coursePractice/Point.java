package day11.coursePractice;

public class Point {
    double x;
    double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(Point p1, Point p2) {
        return Math.sqrt((Math.pow(p2.x - p1.x, 2) + (Math.pow(p2.y - p1.y, 2))));
    }
//    double getDistance(Point p) {
//        return Math.sqrt((Math.pow(this.x - p.x, 2) + (Math.pow(this.y - p.y, 2))));
//    }

    double getDistance(Point p) {
        return getDistance(this,p);
    }
}
