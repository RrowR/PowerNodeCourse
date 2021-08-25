package day12;

/**
 * public class BlockDemo {
 *     public static void main(String[] args) {
 *         new Student(3);
 *         new Student();
 *     }
 * }
 * 自己的：（错误，使用构造方法的时候还会先再调用一次构造代码块）
 *  静态代码块执行 num: 1
 *  构造代码块执行 num: 2
 *  无参构造方法在执行 num: 3
 *  有参构造方法在执行 num: 4
 *  无参构造方法在执行 num: 5
 *
 * 静态代码块执行 num: 1
 * 构造代码块执行 num: 2
 * 无参构造方法在执行 num: 3
 * 有参构造方法在执行 num: 4
 * 构造代码块执行 num: 5
 * 无参构造方法在执行 num: 6
 */
public class Student {
    static int num;
    static {
        System.out.println("静态代码块执行 num:" + ++num);
    }
    {
        System.out.println("构造代码块执行 num:" + ++num);
    }
    public Student() {
        System.out.println("无参构造方法在执行 num:" + ++num);
    }
    public Student(int number) {
        this();
        System.out.println("有参构造方法在执行 num:" + ++num);
    }
}
