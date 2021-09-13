package com.study;


import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectOneUserByFuzzy("风","go");
        users.forEach(System.out::println);
        sqlSession.close();
    }
}
