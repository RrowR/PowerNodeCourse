package com.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "myfile")
public class MyConfig {
    private List<String> allowType;

    private String serverHost;
}
