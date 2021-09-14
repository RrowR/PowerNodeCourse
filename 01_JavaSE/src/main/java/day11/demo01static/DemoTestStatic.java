package day11.demo01static;

public class DemoTestStatic {
    public static void main(String[] args) {
        Person p = new Person("镜华","connect",12);
        Person.className = "princessInClass";
        p.getMsg();
        Person p2 = new Person("镜华","connect",12);
        p2.className = "ClassInPrinces";
        p2.getMsg();
        Person p3 = new Person("镜华","connect",12);
        p3.className = "p3ClassName";
        p3.getMsg();
    }
}
