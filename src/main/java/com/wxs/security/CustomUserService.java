package com.wxs.security;

import com.wxs.model.SysUser;
import com.wxs.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by wuxusen on 2017/3/16.
 */
public class CustomUserService implements UserDetailsService{

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getSysUserByName(s);
        if(sysUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return sysUser;
    }
}
