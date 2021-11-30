package com.study.service;

import com.study.domain.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;
public interface LoginLogService extends IService<LoginLog>{


    void addLoginLog(int i, String username);
}
