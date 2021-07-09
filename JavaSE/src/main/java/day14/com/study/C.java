package day14.com.study;

public class C extends B {
    @Override
    protected A write() {
        return new C();
    }
}
