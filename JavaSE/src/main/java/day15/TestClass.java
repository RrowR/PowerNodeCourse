package day15;

public class TestClass {
    public static void main(String[] args) {
        Animal animal= new Cat();
        Animal tiger = new Tiger();
        // 左边是对象，右边是类型
        // 当对象是当前类或者父类，那么为true，否则为false
        System.out.println(tiger instanceof Tiger);
        System.out.println(tiger instanceof Animal);
        System.out.println(animal instanceof Tiger);
    }
}
