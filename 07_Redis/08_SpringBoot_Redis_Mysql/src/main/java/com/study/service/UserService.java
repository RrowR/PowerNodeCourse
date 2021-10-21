package com.study.service;

import com.study.domain.User;

import java.util.List;

public interface UserService{


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();

}
