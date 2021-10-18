package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Service
public class UserServiceRedisAspectImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Autowired
    private JedisPool jedisPool;

    private final String userAllPrefix = "user:";

    private final String userPrefix = "user:";

    @Override
    public User selectByPrimaryKey(Integer id) {
        Jedis jedis = jedisPool.getResource();
        if (jedis.exists(id.toString())){
            String user = jedis.get(id.toString());
            User user1 = JSON.parseObject(user, User.class);
            jedis.close();
            return user1;
        }
        User user = userMapper.selectByPrimaryKey(id);
        if (!ObjectUtils.isEmpty(user)){
            jedis.set(user.getId().toString(),JSON.toJSONString(user));
            jedis.close();
        }
        return user;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        Jedis jedis = jedisPool.getResource();
        if (jedis.exists(id.toString())){
            jedis.del(id.toString());
            jedis.del(userAllPrefix);
            jedis.close();
        }
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int insert(User record) {
        Jedis jedis = jedisPool.getResource();
        if (!ObjectUtils.isEmpty(record)){
            jedis.del(userAllPrefix);
        }
        int i = userMapper.insert(record);
        if (i > 0){
            jedis.set(record.getId().toString(),JSON.toJSONString(record));
        }
        jedis.close();
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
        Jedis jedis = jedisPool.getResource();
        if (jedis.exists(userAllPrefix)){
            List<User> users = JSON.parseArray(jedis.get(userAllPrefix), User.class);
            jedis.close();
            return users;
        }
        List<User> users = userMapper.selectAll();
        if (!CollectionUtils.isEmpty(users)){
            jedis.set(userAllPrefix,JSON.toJSONString(users));
            jedis.close();
        }
        return users;
    }

}
