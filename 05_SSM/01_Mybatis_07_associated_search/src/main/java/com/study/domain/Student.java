package com.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;

    private String sname;

    private Integer cid;

    /*
        方法一: 添加Class表里的课程字段
     */
    private String cname;
}