package com.wxs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(basePackages = "com.wxs.mapper")
@SpringBootApplication
@ServletComponentScan// 开启自己自定义的servlet扫描
public class MySpringBoot02Application {


	public static void main(String[] args) {
		SpringApplication.run(MySpringBoot02Application.class, args);
	}

}
