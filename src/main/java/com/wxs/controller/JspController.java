package com.wxs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wuxusen on 2017/3/14.
 */
@Controller
public class JspController {

    @Value("${application.hello:Hello}")
    private String hello;


    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String, Object> map) {
        System.out.println("HelloController.helloJsp().hello=" + hello);
        map.put("hello", hello);
        return "helloJsp";

    }

}
