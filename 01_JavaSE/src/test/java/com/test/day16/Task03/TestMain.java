package com.test.day16.Task03;

public class TestMain {
    public static void main(String[] args) {
        Person p1 = new Person("美美", 9);
        Person p2 = new Person("猫羽雫", 16);
        Person p3 = new Person("镜华", 11);
        Person[] people = new Person[3];
        people[0] = p1;
        people[1] = p2;
        people[2] = p3;
        new Person().sortArr(people);
    }
}
