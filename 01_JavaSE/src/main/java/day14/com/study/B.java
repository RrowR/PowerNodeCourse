package day14.com.study;

public class B extends A{
//    void write(){}

    @Override
    protected A write() {
        return new B();
    }
}
