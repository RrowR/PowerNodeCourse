package day18;

import java.util.HashSet;

public class TestMain {
    public static void main(String[] args) {
//        Person p1 = new Person("卡卡", 222);
//        Person p2 = new Person("卡卡", 222);
        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("卡卡", 222));
        hashSet.add(new Person("卡卡", 222));
        System.out.println(hashSet.size());
    }
}
