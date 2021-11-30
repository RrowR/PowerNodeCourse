package com.study.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.domain.LoginLog;
import com.study.mapper.LoginLogMapper;
import com.study.service.LoginLogService;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
@Slf4j
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public void addLoginLog(int i, String username) {
        log.info("记录了{}用户登录日志");
        if (StringUtils.hasText(username)) {
            LoginLog log = LoginLog.builder()
                    .username(username)
                    .createTime(new Date())
                    .message(i == 0 ? "登录失败" : "登录成功")
                    .status(i)
                    .type("密码")
                    .build();
            int insert = loginLogMapper.insert(log);
            System.out.println(insert);
        }
    }
}
