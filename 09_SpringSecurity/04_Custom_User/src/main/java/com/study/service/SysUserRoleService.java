package com.study.service;

import com.study.domain.SysUserRole;
public interface SysUserRoleService{


    int deleteByPrimaryKey(Integer userid,Integer roleid);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

}
