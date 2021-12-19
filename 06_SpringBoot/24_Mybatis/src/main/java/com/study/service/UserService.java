package com.study.service;

import com.github.pagehelper.Page;
import com.study.domain.User;
public interface UserService{


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Page<User> queryForPage(int i, int i1);
}
