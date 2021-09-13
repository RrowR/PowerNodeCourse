package com.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPagingSearch {
    SqlSession sqlSession = SqlSessionUtils.getsqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Test
    void PagingSearch01(){
        // 调用分页查询的类，Mybatis自带
        RowBounds rowBounds = new RowBounds(0,2);
        /*
            调用mapper里的分页查询，传入RowBounds，获得分页查询对象，这里面的方法也是接口映射过来的
            使用rowBounds来进行分页的查询首会查询所有，再帮你分页(分页不是在sql内部进行)，所以效率其实是很低的
         */
        List<User> users = mapper.selectPage(rowBounds);
        users.forEach(System.out::println);
    }
}
