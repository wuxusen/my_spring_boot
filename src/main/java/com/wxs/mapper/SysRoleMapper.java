package com.wxs.mapper;

import com.wxs.model.SysRole;
import com.wxs.util.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper extends MyMapper<SysRole> {

    @Select("SELECT r.id ,r.name FROM sys_role r " +
            "LEFT JOIN sys_user_roles s ON r.id = s.roles_id WHERE sys_user_id = #{0}")
    public List<SysRole> getSysRoleBySysUserID(Long id);
}