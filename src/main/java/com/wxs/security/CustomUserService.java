package com.wxs.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by wuxusen on 2017/3/16.
 */
public class CustomUserService implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        return null;
    }
}
