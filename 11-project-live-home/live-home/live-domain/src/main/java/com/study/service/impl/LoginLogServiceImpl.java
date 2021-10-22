package com.study.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.domain.LoginLog;
import com.study.mapper.LoginLogMapper;
import com.study.service.LoginLogService;
@Service
public class LoginLogServiceImpl implements LoginLogService{

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return loginLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LoginLog record) {
        return loginLogMapper.insert(record);
    }

    @Override
    public int insertSelective(LoginLog record) {
        return loginLogMapper.insertSelective(record);
    }

    @Override
    public LoginLog selectByPrimaryKey(Integer id) {
        return loginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LoginLog record) {
        return loginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LoginLog record) {
        return loginLogMapper.updateByPrimaryKey(record);
    }

}
