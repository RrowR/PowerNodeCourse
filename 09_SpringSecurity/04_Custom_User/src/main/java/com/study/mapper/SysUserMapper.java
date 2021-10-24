package com.study.mapper;

import com.study.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    @Select("select * from sys_user where username = #{value} ")
    SysUser findUserByusername(String username);

    @Select("SELECT DISTINCT t1.percode FROM sys_permission as t1 join sys_role_permission as t2 ON (t1.perid = t2.perid) join sys_user_role as t3 ON (t2.roleid = t3.roleid) where t3.userid = #{value} ")
    List<String> findAuthsByUserId(Integer userid);
}