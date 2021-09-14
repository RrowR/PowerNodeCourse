package day12;

/**
 * 类的组成内容有：
 *   a)成员变量
 *   b)静态变量
 *   c)静态代码块
 *   d)构造代码块
 *   e)构造方法
 *   f)成员方法
 *   g)静态方法
 */
public class Dog {
    String name = "母老虎";
    static String classRoom = "教室七";
    {
        int num = 10; // num出生
        System.out.println(this);
        System.out.println(name);
        System.out.println(classRoom);
        System.out.println("构造代码块1");
    } // num死亡
    // System.out.println(name); // 编译错误
    {
        // System.out.println(num); // 编译错误
        System.out.println("构造代码块2");
    }
    {
        System.out.println("构造代码块3");
    }

    public Dog() {
        System.out.println("构造方法。。。");
    }
}
