package com.study.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUsers();
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
