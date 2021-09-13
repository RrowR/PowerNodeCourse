package com.study.mapper;

import com.study.domain.User;

import java.util.List;

public interface UserMapper {
    /*
        全查询
     */
    public List<User> queryAllUsers();

    /*
        查询一个
     */
    public User queryOneUser(Integer id);

    /*
        添加
     */
    public int addUser(User user);

    /*
        修改
     */
    public int updateUser(User user);

    /*
        根据id删除
     */
    public int deleteUser(Integer id);
}
