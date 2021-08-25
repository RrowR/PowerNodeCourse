package day11;

public class Constructor {
    String name;
    String password;
    int age;

    public Constructor() {
    }

    public Constructor(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Constructor(String name, String password, int age) {
        this(name,password);
        this.age = age;
    }
}
