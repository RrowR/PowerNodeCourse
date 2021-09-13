package com.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 使用接口代理的方式来查询数据库
 * 好处是从类变成了接口，直接调用配置文件的方法自动封装数据了
 * 也不需要调sqlSession里的增删改查的方法了，直接调接口里的方法
 * 以前是在类里调sqlSession里的增删改查的方法
 */
public class TestProxyMethod {
    // 获得SqlSession
    private SqlSession sqlSession = SqlSessionUtils.getsqlSession();
    // 传入接口的字节码
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Test
    void Test01(){
        /*
            测试查询
         */
        List<User> users = mapper.queryAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    void Test02(){
        // 测试删除，这里也是需要提交事物的，后面就不测试了，方法一样
        int i = mapper.deleteUser(5);
        // 提交事物
        sqlSession.commit();
        System.out.println(i);
    }
}
