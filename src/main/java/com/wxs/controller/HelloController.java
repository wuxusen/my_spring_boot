package com.wxs.controller;


import com.google.gson.Gson;
import com.wxs.autoconfig.HelloService;
import com.wxs.model.Country;
import com.wxs.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private CountryService countryService;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(helloService.getHelloProperties().toString());
        return helloService.getHelloProperties().toString();
    }
    @RequestMapping("/hello2")
    public String hello2(){
        List<Country> all = countryService.getAll(null);
        Gson gson = new Gson();
        String str = gson.toJson(all);
        System.out.println(str);
        return str;
    }



}
