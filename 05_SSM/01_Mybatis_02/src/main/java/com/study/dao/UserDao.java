package com.study.dao;

import com.study.domain.User;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDao {
    public List<User> selectAll(){
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
//        sqlSession.selectList("com.study.dao.mapper")
        return null;
    }
}
