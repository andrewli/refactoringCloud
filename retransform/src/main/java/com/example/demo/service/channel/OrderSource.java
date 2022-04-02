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

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author liudongwei
 * @Type OrderSource
 * @Desc
 * @date 2022-03-27 15:57
 */
public interface OrderSource {

    String OUTPUT = "order-output";

    @Output(OUTPUT)
    MessageChannel output();

}
