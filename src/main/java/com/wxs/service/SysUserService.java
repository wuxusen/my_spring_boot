package com.wxs.service;

import com.wxs.mapper.SysRoleMapper;
import com.wxs.mapper.SysUserMapper;
import com.wxs.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuxusen on 2017/3/16.
 */
@Service
public class SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    public SysUser getSysUserByName(String name){
        SysUser sysUser = sysUserMapper.getUserByName("wxs");
        return  sysUser;
    }

}
