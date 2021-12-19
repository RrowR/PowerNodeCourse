package com.study.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Component
@ConfigurationProperties(prefix = "hero")
public class Hero {
    private Integer id;
    private Integer age;
    private String name;
    private Date birth;
    private String[] hobby;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    
    private List<User> users;
}
