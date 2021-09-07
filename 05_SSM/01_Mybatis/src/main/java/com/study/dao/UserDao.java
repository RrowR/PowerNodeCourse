package com.study.dao;

import com.study.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> selectAll();
}
