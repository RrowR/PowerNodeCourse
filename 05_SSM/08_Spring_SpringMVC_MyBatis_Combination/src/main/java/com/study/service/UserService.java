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
        添加用户
     */
    int addUser(User user);

    /*
        删除（根据id）
     */
    int deleteById(Integer id);

    /*
        修改
     */
    int updateUser(User user);


}
