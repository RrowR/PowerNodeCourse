package com.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPageHelper {

    @Test
    void TestPageHelper01(){
        // 使用工具类获取sqlSession
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        // 调用SqlSession里的getMapper方法获取UserMapper的map对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 创建分页对象               第几页的几个对象
        Page<User> userPage = PageHelper.startPage(1, 2);
        /*
            这里看起来好像和PageHelper没有任何关系
            其实在执行这条语句之前，PageHelper会对这条sql进行拦截，把sql进行再一次的封装
            这条查询所有的sql其实就已经失效了，已经被封装成了一个PageHelper分页的sql语句，不管怎么打印都是上面PageHelper封装的分页sql
         */
        List<User> userList = mapper.selectAll();
        System.out.println("总页数 = " + userPage.getPages());
        System.out.println("总个数 = " + userPage.getPageNum());
        System.out.println("每页条数 = " + userPage.getPageSize());
        System.out.println("总条数 = " + userPage.getTotal());
        List<User> users = userPage.getResult();
//        users.forEach(System.out::println);
        userList.forEach(System.out::println);
        sqlSession.close();
    }
}
