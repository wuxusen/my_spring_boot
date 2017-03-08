package com.wxs.service;

import com.wxs.mapper.MqinfoMapper;
import com.wxs.model.Mqinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/8.
 */
@Service
public class MqService {

    @Autowired
    private MqinfoMapper mqinfoMapper;

    public int insertInfo(Mqinfo mqinfo){
        return mqinfoMapper.insert(mqinfo);
    }

}
