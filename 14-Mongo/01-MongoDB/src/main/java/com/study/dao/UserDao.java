package com.study.dao;

import com.study.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/*
    自己写一个接口去继承 MongoRepository 里面有很多方法
 */
@ResponseBody
public interface UserDao extends MongoRepository<User,String> {
    User findAllById(String id);
}
