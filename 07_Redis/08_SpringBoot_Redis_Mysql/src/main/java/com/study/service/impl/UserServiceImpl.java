package com.study.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;

@Service
@CacheConfig(cacheNames = "com.study.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    @CacheEvict("#id")
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict("'user-all'")
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    /*
        添加缓存
        Cacheable 会将这个方法调用之后的返回值当作value放到缓存中去
        #id  spel解析 spring expression el 表达式解析
     */
    @Override
    @Cacheable(key = "#id")
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(key = "#record.id")
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}
