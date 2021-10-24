package com.study.service;

import com.study.domain.SysRolePermission;
public interface SysRolePermissionService{


    int deleteByPrimaryKey(Integer perid,Integer roleid);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

}
