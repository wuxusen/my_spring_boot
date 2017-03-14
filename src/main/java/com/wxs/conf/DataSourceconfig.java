package com.wxs.conf;

import com.wxs.datasource.DynamicDataSourceRegister;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by wuxusen on 2017/3/13.
 */
@Configuration
@Import({DynamicDataSourceRegister.class})// 注册动态多数据源
public class DataSourceconfig {
}
