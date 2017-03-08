package com.wxs.rocketmq.consumer;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.wxs.model.Mqinfo;
import com.wxs.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */
public class MyMessageListenerConcurrently implements MessageListenerConcurrently {

    @Autowired
    private MqService mqService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + list);
        for (MessageExt msg : list) {
            String topic = msg.getTopic();
            String tags = msg.getTags();
            byte[] body = msg.getBody();
            Mqinfo mqinfo = new Mqinfo();
            mqinfo.setBody(new String(body));
            mqinfo.setTopic(topic);
            mqinfo.setTags(tags);
            mqService.insertInfo(mqinfo);

            System.out.println("MQ -----------------topic:"+topic+" , tags:"+tags+" ,body:"+ new String(body));
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
