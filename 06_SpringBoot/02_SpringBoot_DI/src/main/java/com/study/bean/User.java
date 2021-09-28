package com.study.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component      // 标记为spring的一个组件
@ConfigurationProperties(prefix = "user") // 使用user前缀去ioc容器里面读取配置文件
public class User {
    private String username;
    private Integer age;
}
