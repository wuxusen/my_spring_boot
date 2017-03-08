package com.wxs.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2017/2/20.
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    private String name;
    private Integer age;
    private boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String   toString() {
        return "HelloProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
