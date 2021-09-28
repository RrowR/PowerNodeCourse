package com.study.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component              // 必须加入到spring容器里之后才可以使用spring的注解
public class User {
    @Value("${user.username}")
    private String username;
    @Value("${user.age}")
    private Integer age;
}
