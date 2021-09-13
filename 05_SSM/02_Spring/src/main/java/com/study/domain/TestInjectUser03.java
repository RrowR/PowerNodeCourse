package com.study.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestInjectUser03 {
    private Integer id;
    private String name;

    // 使用AutoWired注解注入的时候，不需要写setter方法
    @Autowired
    private User user;

    @Override
    public String toString() {
        return "TestInjectUser03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
