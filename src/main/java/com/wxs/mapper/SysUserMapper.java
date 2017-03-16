package com.wxs.mapper;

import com.wxs.model.SysUser;
import com.wxs.util.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper extends MyMapper<SysUser> {

    @Select(" select id,password,username from sys_user where username = #{0}")
    public SysUser getSysUserByusername(String username);

    public SysUser getUserByName(String username);

}