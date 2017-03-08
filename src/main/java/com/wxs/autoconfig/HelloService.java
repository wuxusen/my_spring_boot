package com.wxs.autoconfig;

/**
 * Created by Administrator on 2017/2/20.
 */
public class HelloService {
    private HelloProperties helloProperties = new HelloProperties();

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
