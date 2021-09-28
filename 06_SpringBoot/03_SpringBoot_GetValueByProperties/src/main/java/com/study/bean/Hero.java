package com.study.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Component
public class Hero {
    @Value("${hero.id}")
    private Integer id;
    @Value("${hero.age}")
    private Integer age;
    @Value("${hero.name}")
    private String name;
    @Value("${hero.birth}")
    private Date birth;
    @Value("${hero.hobby}")
    private String[] hobby;
    @Value("${hero.list}")
    private List<String> list;
    @Value("${hero.set}")
    private Set<String> set;
//    @Value("${hero.map}")     // map不支持使用value来注入
    private Map<String, String> map;
//    @Value("${hero.users}")  对象数组好像也不行
    private List<User> users;
}
