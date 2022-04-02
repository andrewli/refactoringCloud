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

package com.example.demo.service.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author liudongwei
 * @Type OrderSink
 * @Desc
 * @date 2022-03-27 16:02
 */
public interface OrderSink {

    String INPUT = "order-input";

    @Input(INPUT)
    SubscribableChannel input();
}
