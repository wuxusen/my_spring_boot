package com.wxs;

import com.wxs.datasource.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

@MapperScan(basePackages = "com.wxs.mapper")
@SpringBootApplication
@ServletComponentScan// 开启自己自定义的servlet扫描
@Import({DynamicDataSourceRegister.class})// 注册动态多数据源
public class MySpringBoot02Application {


	public static void main(String[] args) {
		SpringApplication.run(MySpringBoot02Application.class, args);
	}

}
