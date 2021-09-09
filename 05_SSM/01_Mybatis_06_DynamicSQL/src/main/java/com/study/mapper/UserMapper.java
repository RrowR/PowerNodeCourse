package com.study.mapper;


import com.study.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /*
        模糊查询
     */
    public List<User> selectOneUserByFuzzy(@Param("name") String name,@Param("address") String address);

    public List<User> selectOneUserByFuzzy2(@Param("name") String name,@Param("address") String address);

    /*
        根据User进行更新
     */
    public int updateUserByUser(@Param("user") User user);
}
