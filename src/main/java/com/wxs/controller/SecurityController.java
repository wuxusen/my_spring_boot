package com.wxs.controller;

import com.wxs.model.Msg;
import com.wxs.propertiesConf.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/3/17.
 */
@Controller
public class SecurityController {

    @Autowired
    private Person person; // 因为 ConfigurationProperties 注解没有location属性，增加了替代方法


    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request,String verification){
        HttpSession session = request.getSession();
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);

        System.out.println("-------------------verification" + verification);
        System.out.println("person : "+ person.toString());


        return "home";
    }
}
