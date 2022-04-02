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

import com.example.demo.service.channel.OrderSource;
import com.example.demo.vo.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author liudongwei
 * @Type OrderProduce
 * @Desc
 * @date 2022-03-27 16:51
 */
@Slf4j
@Component
public class OrderProducer {


    @Autowired
    private OrderSource orderSource;


    public void produce() {
        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setOrderId(String.valueOf(new Random().nextInt()));
        orderMessage.setNote("this is jack's meal");
        orderMessage.setDateTime(LocalDateTime.now());
        Message<OrderMessage> message = MessageBuilder.withPayload(orderMessage).build();
        orderSource.output().send(message);
    }
}
