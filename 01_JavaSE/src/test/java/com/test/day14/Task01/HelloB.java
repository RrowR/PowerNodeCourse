package com.test.day14.Task01;

public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("static B");
    }

}
