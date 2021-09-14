package day10.ObjectBetweenClass;

public class Demo02OfStudent {
    public static void main(String[] args) {
        // 如果创建了有参构造，那么就必须创建无参构造
        Student student = new Student();
        student.eat();
        student.age = 1;
        student.name = "kaka";
        System.out.println(student);
    }
}
