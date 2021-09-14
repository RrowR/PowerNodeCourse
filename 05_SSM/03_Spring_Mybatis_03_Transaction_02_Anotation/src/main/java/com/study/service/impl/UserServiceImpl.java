package com.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        int a = 10/0;
        int j = userMapper.deleteByPrimaryKey(id+1);
        return i;
    }

    @Override
    public User queryOneByKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println("user = " + user);
        int a = 10/0;
        return user;
    }


}
