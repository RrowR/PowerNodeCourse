package day11.coursePractice;

/**
 * 定义一个坐标类（Point)，用于表示二维空间中的一个坐标位置。通过坐标类的方法，实现计算两个坐标位置之间的距离（要求：使用构造方法）。
 * 坐标类成员变量：X轴点（x）、Y轴点（y）
 * 坐标类构造方法：Point(double x, double y)
 * 坐标类成员方法：计算两个坐标位置之间的距离。
 * 方法名为：getDistance即可
 */
public class Test {
    public static void main(String[] args) {
        // 方法一
//        System.out.println(new Point().getDistance(new Point(2, 3), new Point(4, 5)));
        // 方法二
        System.out.println(new Point(1, 2).getDistance(new Point(2, 3)));
    }
}
