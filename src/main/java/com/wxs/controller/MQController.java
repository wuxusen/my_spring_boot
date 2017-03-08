package com.wxs.controller;

import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.wxs.rocketmq.producer.RocketMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/6.
 */
@RestController
public class MQController {


    @Autowired
    private RocketMQService rocketMQService;

    @RequestMapping("/mq")
    public String hello() throws Exception {

        Message msg = new Message("TopicTest",// topic
                "TagA",// tag
                ("中文，会出现编码问题？").getBytes(RemotingHelper.DEFAULT_CHARSET)// body
        );
        rocketMQService.asyncSendMsg(msg);
        return "make it !";
    }

}
