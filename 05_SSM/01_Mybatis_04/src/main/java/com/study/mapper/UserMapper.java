package com.study.mapper;

import com.study.domain.User;

import java.util.List;

public interface UserMapper {
    /*
        模糊查询
     */
    public User selectByName(String name);
}
