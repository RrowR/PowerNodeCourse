package com.study.service.impl;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.service.StudentService;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional(propagation = Propagation.NESTED)
    public int deleteByPrimaryKey(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        int a = 10/0;
        return i;
    }
}
