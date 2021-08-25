package day10.ObjectBetweenClass;

public class Student {
    String name;
    int age;
    void eat(){
        System.out.println("吃饭");
    }
    void study(){
        System.out.println("studyjavainpowernode");
    }

    // 创建了有参构造就要创建无参构造
//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
