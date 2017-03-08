package com.wxs.rocketmq.producer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.wxs.rocketmq.consumer.MyMessageListenerConcurrently;
import com.wxs.rocketmq.consumer.RockerMQConsumerProperties;
import com.wxs.rocketmq.consumer.RocketMQConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wuxusen on 2017/3/6.
 */

@Configuration
@EnableConfigurationProperties({RocketMQProperties.class,RockerMQConsumerProperties.class})
@ConditionalOnClass(RocketMQService.class)
public class RocketMQAutoConfiguration {

    private static Logger logger = LoggerFactory.getLogger(RocketMQAutoConfiguration.class);

    @Autowired
    private RocketMQProperties rocketMQProperties;
    @Autowired
    private RockerMQConsumerProperties rockerMQConsumerProperties;


    @Bean
    @ConditionalOnMissingBean(RocketMQConsumerService.class)
    public RocketMQConsumerService intConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setConsumerGroup(rockerMQConsumerProperties.getConsumerGroup());
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setNamesrvAddr(rockerMQConsumerProperties.getNamesrvAddr());
        consumer.subscribe("TopicTest", "*");
        consumer.registerMessageListener(new MyMessageListenerConcurrently());
        consumer.start();
        System.out.println("Consumer Started ==============================================");
        return new RocketMQConsumerService();
    }



    /**
     * 获得配置文件，启动producer
     */
    @Bean
    @ConditionalOnMissingBean(RocketMQService.class)
    public RocketMQService getProducer(){

        System.out.println("============================ producer 配置方法执行。。。。。。。。。");
        RocketMQService service = new RocketMQService();
        DefaultMQProducer producer = new DefaultMQProducer(rocketMQProperties.getProducerGroup());
        producer.setNamesrvAddr(rocketMQProperties.getNamesrvAddr());
        producer.setInstanceName(rocketMQProperties.getInstanceName());
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
            logger.error("RockteMQ 启动异常！！！！！！");
        }
        service.setProducer(producer);
        return service;
    }





}
