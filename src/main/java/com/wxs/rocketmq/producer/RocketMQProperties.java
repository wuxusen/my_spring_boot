package com.wxs.rocketmq.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wuxusen on 2017/3/6.
 * MQ 配置类。
 */
@ConfigurationProperties(prefix = "myrocket.producer")
public class RocketMQProperties {

    private String producerGroup; // 相同属性的producer
    private String namesrvAddr;   // mq service 地址
    private String maxMessageSize; // 最大消息数
    private String subscribe;      //  描述
    private String instanceName;

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getProducerGroup() {
        return producerGroup;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(String maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }
}
