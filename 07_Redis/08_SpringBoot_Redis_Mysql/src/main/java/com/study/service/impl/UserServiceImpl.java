package com.study.service.impl;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;

import java.util.List;

@Service
@CacheConfig(cacheNames = "com.study.service.impl.UserServiceImpl")    // 分割
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "#id"),
                    @CacheEvict(key = "'user-all'")
            }
    )
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict("'user-all'")
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
//    @CacheEvict(key = "'user-all'")
//    @Cacheable
    @Caching(evict = {
            @CacheEvict(key = "'user-all'")
    }//,cacheable = {
//            @Cacheable(key = "#record.id")
//    }
            ,put = {@CachePut(key = "#record.id")}          // 先添加，在存，不然没有id(有是因为有mybatis的回调)
    )
    public User insertSelective(User record) {
        int i = userMapper.insertSelective(record);
        return record;
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
//    @Cacheable(key = "#record.id")
    @Caching(evict = {
//            @CacheEvict(key = "#record.id"),
            @CacheEvict(key = "'user-all'")
    }
//            cacheable = {
//                @Cacheable(key = "#record.id")
//            }
            ,put = {
            @CachePut(key = "#record.id")       // 先删除自己，再存到redis里去
    }
    )
    public User updateByPrimaryKeySelective(User record) {
        int i = userMapper.updateByPrimaryKeySelective(record);
        return record;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    @Cacheable(key = "'user-all'")
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

}
