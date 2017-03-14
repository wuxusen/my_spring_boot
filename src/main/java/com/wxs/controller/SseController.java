package com.wxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author BeautifulSoup
 * SSE(基于服务器端发送事件的服务器端推送)
 */
@Controller
public class SseController {
    /**
     * @return
     * 演示服务器端每5秒钟向浏览器推送随机消息
     */
    @ResponseBody
    @RequestMapping(value="/push",produces="text/event-stream;charset=UTF-8")
    public String push(){
        Random r=new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3"+r.nextInt()+"\n\n";
    }
}