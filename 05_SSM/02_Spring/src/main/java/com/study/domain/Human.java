package com.study.domain;


import lombok.Data;
import org.springframework.stereotype.Component;

// 开启包扫描之后才可以使用组件来向spring添加对象
@Component
@Data
public class Human {
    private String name;
    private int age;
}
