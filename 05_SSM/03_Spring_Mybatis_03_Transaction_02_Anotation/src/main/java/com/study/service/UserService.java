package com.study.service;

import com.study.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserService{

    int deleteByPrimaryKey(Integer id);

    User queryOneByKey(Integer id);

}
