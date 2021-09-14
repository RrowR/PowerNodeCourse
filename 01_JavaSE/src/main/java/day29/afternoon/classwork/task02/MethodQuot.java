package day29.afternoon.classwork.task02;

import java.util.ArrayList;

public class MethodQuot {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        // 这里引用了一个接口的实现类，但是这个实现类又是引用了System.out里的println(String str)方法，所以这是 :: 在jdk8的新特性（方法的引用）,已经不是多态了
        list.forEach(System.out::println);
    }
}
