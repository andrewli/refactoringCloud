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

package com.example.demo.controller;

import com.example.demo.constant.Result;
import com.example.demo.service.rocketstream.OrderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type OrderStreamController
 * @Desc  更多详细用法: https://zhuanlan.zhihu.com/p/447203595
 * @date 2022-03-27 16:16
 */
@Slf4j
@RestController
public class OrderStreamController {


    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/rocketmqStream/order-topic/produce")
    public Result produceOrder() {
        orderProducer.produce();
        return Result.create();
    }


}
