package com.test.day17;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    void isTriangle() {
        if (a + b <= c || a + c <= b || b + c <= a){
            throw new IllegalArgumentException("参数不合法");
        }else {
            System.out.println("参数合法");
        }
    }

    public void getElement(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
