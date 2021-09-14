package day14.com.study;

/**
 * B继承A ，继承方法中，B权限 >= A权限
 * 子类返回值类型 <= 父类
 */
public class A {
    protected A write(){return new A();}
}
