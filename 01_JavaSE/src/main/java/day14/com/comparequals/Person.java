package day14.com.comparequals;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String QQ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(QQ, person.QQ);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, QQ);
//    }
}
