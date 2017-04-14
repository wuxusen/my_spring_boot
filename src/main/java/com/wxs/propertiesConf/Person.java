package com.wxs.propertiesConf;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 类描述  ： ConfigurationProperties 没有location属性，所欲使用了PropertySource代替。
 * 创建人  : 吴绪森
 * 创建时间：2017/4/7
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */


@Data
@Component
@ConfigurationProperties(prefix = "person")
@PropertySource("classpath:/conf/person.properties")
@ToString
public class Person {
    private String name;
    private int age;
    private String info;
}
