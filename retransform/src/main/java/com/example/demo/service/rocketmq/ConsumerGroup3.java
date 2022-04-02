/*
 * Project: sky5
 *
 * File Created at 2021/3/3
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

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author liudongwei
 * @Type producer
 * @Desc
 * @date 2021年03月03日 14:20
 */
@Service
@Slf4j
/**
*
 相同的消费组会竞争消费消息，一条消息只会被相同消费组消费一次，不同消费组之间不相互影响
 consumeMode :  消费模式  是否顺序消费，默认同步（非顺序CONCURRENTLY） 有序ORDERLY
 messageModel： 消息模式 默认集群  即消费者部署在多个节点上时，一条消息只能被同一个组的一个消费者消费，如果换成广播，则可以多个消费者都消费
 */
@RocketMQMessageListener(topic = "access-topic", consumerGroup = "consumer-group-2")
public class ConsumerGroup3 implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("group2-消费组-2：{}", s);
    }

}
