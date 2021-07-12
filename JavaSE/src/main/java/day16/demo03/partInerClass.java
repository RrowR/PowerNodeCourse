package day16.demo03;

/**
 * 局部内部类的使用，可以延长 a 的生命周期
 *  解释：
 *      当局部内部类访问了外部内的成员变量，
 */
public class partInerClass {
    int a = 10;
    public void method(){
        class InnerClass{
            public void getNumber(){
                System.out.println(a);
            }
        }
    }
}
