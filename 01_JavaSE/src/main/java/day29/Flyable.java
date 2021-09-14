package day29;

@FunctionalInterface
public interface Flyable {
    void fly1();

    default void fly2(){
        System.out.println("fly2 is fly");
    }

    static void fly3(){
        System.out.println("fly3 is fly");
    }
}

class A {
    public static void main(String[] args) {
        C c = new C();
        c.fly2();
    }
}

class C implements Flyable{
    @Override
    public void fly1() {
        System.out.println("fly1 is fly");
    }
}