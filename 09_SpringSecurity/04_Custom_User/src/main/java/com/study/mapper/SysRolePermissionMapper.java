package com.study.mapper;

import com.study.domain.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(@Param("perid") Integer perid, @Param("roleid") Integer roleid);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);
}