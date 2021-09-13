package com.study.domain;

import java.util.*;

public class Person {
    private Integer id;
    private String name;
    private boolean sex;
    private String[] likes;//爱好

    private Set<String> girlFriends; //女朋友

    private List<Dream> dreams;//梦想

    private Map<String,String> house; //房子

    private Properties properties; //配置文件属性

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    public void setGirlFriends(Set<String> girlFriends) {
        this.girlFriends = girlFriends;
    }

    public void setDreams(List<Dream> dreams) {
        this.dreams = dreams;
    }

    public void setHouse(Map<String, String> house) {
        this.house = house;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", likes=" + Arrays.toString(likes) +
                ", girlFriends=" + girlFriends +
                ", dreams=" + dreams +
                ", house=" + house +
                ", properties=" + properties +
                '}';
    }
}
