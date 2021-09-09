package com.study.mapper;

import com.study.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {
    /*
        模糊查询
        like  concat('%',关键字,'%')   推荐
     */
    public User selectByName(String name);

    /*
        模糊查询2
        like '%关键字%'
     */
    public User selectByName2(String name);

    /*
        模糊查询3
        mybatis推荐的bind标签
     */
    public User selectByName3(String name);

    /*
        多个参数的查询,使用注解的方式
     */
    public User selectByMultiParams(@Param("name") String name, @Param("id") Integer id);

    /*
        argx 形式：arg 表示参数，x表示参数索引
     */
    public User selectByMultiParams2(String name,Integer id);

    /*
        paramX形式： param表示参数，x表示第几个参数
     */
    public User selectByMultiParams3(String name,Integer id);

    /*
        使用rowBounds来实现分页查询
     */
    public List<User> selectPage(RowBounds rowBounds);

    /*
        查询所有
     */
    public List<User> selectAll();
}
