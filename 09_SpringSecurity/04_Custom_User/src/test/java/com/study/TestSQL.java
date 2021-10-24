package com.study;

import com.study.domain.SysUser;
import com.study.mapper.SysUserMapper;
import com.study.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSQL {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserMapper userMapper;

    @Test
    void Test01(){
        System.out.println(sysUserService.selectByPrimaryKey(1));
    }

    @Test
    void Test02(){
        System.out.println(userMapper.findUserByusername("zhangsan"));
    }

}
