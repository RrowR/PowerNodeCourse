package day11.demo01static;

public class Person {
    String name;
    String live;
    int age;
    // 这里的属性是静态的
    static String className;

    public Person() {
    }

    public Person(String name, String live, int age) {
        this.name = name;
        this.live = live;
        this.age = age;
    }

    void getMsg(){
        System.out.println("name="+name+" live="+live+" age="+age+" className="+className);
    }
}
