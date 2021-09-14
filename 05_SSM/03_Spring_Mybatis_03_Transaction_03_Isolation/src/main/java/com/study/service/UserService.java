package com.study.service;

import com.study.domain.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService{

    int deleteByPrimaryKey(Integer id);

    User queryOneByKey(Integer id);

}
