package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceRedisAspectImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Autowired
    private JedisPool jedisPool;

    private final String userPrefix = "com.study.domain.User:";

    @Override
    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int insert(User record) {
        int i = userMapper.insert(record);
        return i;
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

}
