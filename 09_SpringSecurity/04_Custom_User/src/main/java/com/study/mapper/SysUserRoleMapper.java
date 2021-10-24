package com.study.mapper;

import com.study.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(@Param("userid") Integer userid, @Param("roleid") Integer roleid);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}