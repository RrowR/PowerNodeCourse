package day14.com.comparequals;

import day12.Student;

import java.util.HashMap;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
//        System.out.println(p1);
//        System.out.println(p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
//        HashMap<Person, String> hashMap = new HashMap<>();
//        hashMap.put(p1,"123");
//        hashMap.put(p2,"456");
//        System.out.println(hashMap.get(p1));        // "456"
//        System.out.println(hashMap.get(p2));        // "456"

    }
}
