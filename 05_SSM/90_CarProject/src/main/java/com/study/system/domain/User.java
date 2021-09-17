package com.study.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userid;

    private String loginname;

    private String identity;

    private String realname;

    /**
    * 0女1男
    */
    private Integer sex;

    private String address;

    private String phone;

    private String pwd;

    private String position;

    /**
    * 1，超级管理员,2，系统用户
    */
    private Integer type;

    private Integer available;
}