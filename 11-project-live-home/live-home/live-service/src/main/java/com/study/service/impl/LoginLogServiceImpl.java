package com.study.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.domain.LoginLog;
import com.study.mapper.LoginLogMapper;
import com.study.service.LoginLogService;
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService{

}
