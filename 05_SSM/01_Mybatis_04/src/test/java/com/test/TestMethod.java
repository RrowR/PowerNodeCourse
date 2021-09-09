package com.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class TestMethod {


    @Test
    void Test01(){
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByName("猫");
        System.out.println("user = " + user);
    }


}
