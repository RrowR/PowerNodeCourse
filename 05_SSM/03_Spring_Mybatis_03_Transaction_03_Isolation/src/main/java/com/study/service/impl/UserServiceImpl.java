package com.study.service.impl;

import com.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentService studentService;


    /*
        propagation = Propagation.REQUIRED  这个事务是传播的，和上级事务是同一个事务
        propagation = Propagation.NESTED    事务是嵌套的，如果都有事务，父事务回滚会影响子事务，子事务回滚不会影响父事务 注意: 子事务在出现异常的时候父事务需要去try/catch一下，否则会导致父事务的回滚
     */
    @Override
    @Transactional(propagation = Propagation.NESTED)
    public int deleteByPrimaryKey(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        studentService.deleteByPrimaryKey(id+1);
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
