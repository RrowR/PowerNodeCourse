package day14.com.study;

public class D extends B {
    @Override
    protected A write() {
        return new A();
    }
}
