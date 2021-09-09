package com.study.mapper;

import com.study.domain.User;

import java.util.List;

public interface UserMapper {
    /*
        模糊查询
     */
    public User selectByName(String name);

    /*
        模糊查询2
     */
    public User selectByName2(String name);

    /*
        模糊查询3
     */
    public User selectByName3(String name);
}
