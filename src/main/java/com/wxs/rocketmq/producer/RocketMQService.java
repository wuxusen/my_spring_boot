package com.wxs.rocketmq.producer;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;

/**
 * Created by wuxusen on 2017/3/6.
 *
 */

public class RocketMQService {

    private static Logger logger = LoggerFactory.getLogger(RocketMQService.class);

    private DefaultMQProducer producer;

    public void setProducer(DefaultMQProducer producer){
        this.producer = producer;
    }


    public void asyncSendMsg(Message msg) throws Exception {
        logger.info("producer --------------------------:{}",producer);
        logger.info("producerGroupName:[{}],message:[{}],body[{}]",
                new Object[]{producer.getProducerGroup(), msg, new String(msg.getBody())});
        producer.send(msg, new SendCallback() {
            public void onSuccess(SendResult sendResult) {
                logger.info("异步消息放入队列成功[{}]", sendResult);
            }

            public void onException(Throwable e) {
                logger.debug("producer[{}]", producer);
                logger.info("异步消息放入队列失败,resaon:[{}]", e);
            }
        });
    }

    @PreDestroy
    public void shutdown() {
        producer.shutdown();
        logger.info("关闭MQ ---- producer shutdown ok status: [{}]",
                producer.getDefaultMQProducerImpl().getServiceState());
    }

}
