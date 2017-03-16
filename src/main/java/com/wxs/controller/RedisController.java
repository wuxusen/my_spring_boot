package com.wxs.controller;

import com.wxs.RedisDao.PersonDao;
import com.wxs.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuxusen on 2017/3/16.
 */
@RestController
public class RedisController {

    @Autowired
    private PersonDao personDao;
    @RequestMapping("/set") //1
    public void set(){
        Person person = new Person("1","wyf", 32);
        personDao.save(person);
        personDao.setRedis();
    }

    @RequestMapping("/getPerson") //3
    public Person getPerson(){
        System.out.println("str:================"+ personDao.getStr());
        return personDao.getPerson();
    }
}
