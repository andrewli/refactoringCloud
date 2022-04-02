/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/24
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.vo.User;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author liudongwei
 * @Type RockeMqProducer
 * @Desc
 * @date 2022-03-24 19:27
 */
@Component
public class RockeMqProducer<T> implements Serializable {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void send(Collection<User> message) {
        String topic = "access-topic";

        syncSendMessageByRocketMq(topic, JSONObject.toJSONString(message));
    }


    /**
     * 普通消息
     */
    public void syncSendMessageByRocketMq(String topic, String message) {
        rocketMQTemplate.syncSend(topic, message);
    }

    /**
     * 发送普通消息
     */
    public void sendMsg(String topic, String msgBody) {
        rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msgBody).build());
    }

    /**
     * 发送异步消息 在SendCallback中可处理相关成功失败时的逻辑
     */
    public void sendAsyncMsg(String topic, String msgBody) {
        rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(msgBody).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                // 处理消息发送成功逻辑
            }

            @Override
            public void onException(Throwable e) {
                // 处理消息发送异常逻辑
            }
        });
    }

    /**
     * 发送带tag的消息,直接在topic后面加上":tag" ,例如:queue_test_topic:tag1
     */
    public void sendTagMsg(String topic, String msgBody) {
        rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msgBody).build());
    }

}
