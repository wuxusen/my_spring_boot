package com.wxs.model;

import javax.persistence.*;

public class Mqinfo {
    @Id
    private Integer id;

    private String topic;

    private String tags;

    private String body;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * @return tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * @return body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }
}