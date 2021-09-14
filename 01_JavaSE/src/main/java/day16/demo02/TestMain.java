package day16.demo02;

public class TestMain {
    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.show();
    }
}
