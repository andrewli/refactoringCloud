/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/27
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.rocketstream;

import com.example.demo.service.channel.OrderSink;
import com.example.demo.vo.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author liudongwei
 * @Type OrderProduce
 * @Desc
 * @date 2022-03-27 16:51
 */
@Slf4j
@Component
public class OrderConsumer {


    @StreamListener(OrderSink.INPUT)
    public void getListtener(@Payload OrderMessage message) {
        log.info("[orderMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }


}
