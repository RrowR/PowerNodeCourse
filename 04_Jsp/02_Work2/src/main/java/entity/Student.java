package entity;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private Integer sex;
    private Date birth;

    public Student() {
    }

    public Student(Integer id, String name, String address, Integer age, Integer sex, Date birth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.birth = birth;
    }

    public Student(String name, String address, Integer age, Integer sex, Date birth) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birth=" + birth +
                '}';
    }
}
