package com.wxs.rocketmq.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wuxusen on 2017/3/7.
 */
@ConfigurationProperties(prefix = "myrocket.consumer")
public class RockerMQConsumerProperties {

    private String consumerGroup;
    private String namesrvAddr;

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }
}
