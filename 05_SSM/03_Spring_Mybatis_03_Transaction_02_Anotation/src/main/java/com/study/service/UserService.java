package com.study.service;

import com.study.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService{

    int deleteByPrimaryKey(Integer id);

    @Transactional(readOnly = true)
    User queryOneByKey(Integer id);

}
