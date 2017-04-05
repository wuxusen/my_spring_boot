package com.wxs.quartz.quartzService;

import com.wxs.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2017//2
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */
@Service
public class TestQuartzService {

    @Autowired
    private CityMapper cityMapper;

    public void execu(){
        System.out.println("定时任务已经执行================="+cityMapper.selectAll());
    }


}
