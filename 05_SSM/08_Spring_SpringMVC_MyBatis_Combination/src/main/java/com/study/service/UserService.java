package com.study.service;

import com.study.domain.User;

import java.util.List;

public interface UserService{

    /*
        全查询
     */
    List<User> queryAllUser();

    /*
        根据id查询
     */
    User queryUserById(Integer id);

    /*
        修改用户
     */
    int updateUser(User user);

    /*
        添加用户
     */
    int addUser(User user);

    /*
        删除用户
     */
    int deleteUser(Integer id);

}
