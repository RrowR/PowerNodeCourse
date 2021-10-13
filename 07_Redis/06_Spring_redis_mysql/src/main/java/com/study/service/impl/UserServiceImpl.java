package com.study.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    private Map<String,Object> mycache = new HashMap<>();


    @Override
    public User selectByPrimaryKey(Integer id) {
        if (mycache.containsKey(id)){
            return (User) mycache.get(id);
        }
        User user = userMapper.selectByPrimaryKey(id);
        if (!ObjectUtils.isEmpty(user)){
            mycache.put(id.toString(),user);
        }
        return user;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        mycache.remove(id);
        return i;
    }

    @Override
    public int insert(User record) {
        int i = -1;
        if (!ObjectUtils.isEmpty(record)){
            mycache.remove("user:all");
            i = userMapper.insert(record);
        }
        mycache.put(record.getId().toString(),record);
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
        if (mycache.containsKey("user:all")){
            return (List<User>) mycache.get("user:all");
        }
        List<User> users = userMapper.selectAll();
        if (!CollectionUtils.isEmpty(users)){
            mycache.put("user:all",users);
        }
        return users;
    }

}
