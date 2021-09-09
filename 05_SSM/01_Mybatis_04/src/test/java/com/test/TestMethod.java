package com.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/*
    测试3种模糊查询
 */
public class TestMethod {
    SqlSession sqlSession = SqlSessionUtils.getsqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);


    @Test
    void Test01(){
        User user = mapper.selectByName("猫");
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    void Test02(){
        User user = mapper.selectByName2("猫");
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    void Test03(){
        User user = mapper.selectByName3("猫");
        System.out.println("user = " + user);
        sqlSession.close();
    }
}
