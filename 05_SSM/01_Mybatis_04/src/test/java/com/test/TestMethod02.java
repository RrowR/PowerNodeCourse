package com.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/*
    多参数的查询
 */
public class TestMethod02 {
    SqlSession sqlSession = SqlSessionUtils.getsqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);


    @Test
    void Test01(){
        /*
            使用了注解的方式
         */
        User cat = mapper.selectByMultiParams("猫", 1);
        System.out.println("cat = " + cat);
    }

    @Test
    void Test02(){
        /*
           argx 形式：arg 表示参数，x表示参数索引
         */
        User cat = mapper.selectByMultiParams2("猫", 1);
        System.out.println("cat = " + cat);
    }

    @Test
    void Test03(){
        /*
            paramX形式： param表示参数，x表示第几个参数
         */
        User cat = mapper.selectByMultiParams3("猫", 1);
        System.out.println("cat = " + cat);
    }

}
