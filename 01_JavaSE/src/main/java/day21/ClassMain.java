package day21;

import org.junit.Test;

public class ClassMain {
    @Test
    public void Test01(){
        B b = new B();
        b.swapMethod(100,"kaka");
    }

    class B{
        public <T> void swapMethod(T a,T b){

        }
    }
}
