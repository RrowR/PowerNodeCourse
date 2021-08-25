package day16.demo02;

public class OuterClass{
    public int a = 100;
    public class InnerClass{
        public void show(){
            System.out.println(OuterClass.this.a);
        }
    }
}
