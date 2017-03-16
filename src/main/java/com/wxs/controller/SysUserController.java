package com.wxs.controller;

import com.wxs.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/16.
 */
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/getinfo")
    public String getInfo(){
        /*SysUser sysUser = sysUserService.getSysUserById("wxs");
        String str = JSONUtils.toJSONString(sysUser);
        return str;*/
        return null;
    }

}
