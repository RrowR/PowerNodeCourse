package com.study.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Component
@ConfigurationProperties(prefix = "hero")
@Validated  // 开启验证
public class Hero {
    private Integer id;
    @Range(min = 0,max = 100,message = "超出范围")           // 范围限制
    private Integer age;
    private String name;
    private Date birth;
    private String[] hobby;
    private List<String> list;
    private Set<String> set;
    @Email
//    @NotBlank     验证不能为空
    private String email;
}
