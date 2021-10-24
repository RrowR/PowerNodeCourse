package com.study.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.mapper.SysRolePermissionMapper;
import com.study.domain.SysRolePermission;
import com.study.service.SysRolePermissionService;
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService{

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer perid,Integer roleid) {
        return sysRolePermissionMapper.deleteByPrimaryKey(perid,roleid);
    }

    @Override
    public int insert(SysRolePermission record) {
        return sysRolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRolePermission record) {
        return sysRolePermissionMapper.insertSelective(record);
    }

}
