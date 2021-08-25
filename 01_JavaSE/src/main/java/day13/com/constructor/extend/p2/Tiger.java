package day13.com.constructor.extend.p2;

public class Tiger extends Animal{
    private String name;
    private int age;

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(String name, int age) {
        this(name);
        this.age = age;
    }

    public Tiger(String name, int age, String color) {
        this(name,age);
//        super(color);
        this.name = name;
        this.age = age;

    }
}
