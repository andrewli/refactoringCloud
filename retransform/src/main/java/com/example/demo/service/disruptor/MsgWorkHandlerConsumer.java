/*
 * Project: mybatis_hello
 *
 * File Created at 2022/4/5
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.disruptor;

import com.example.demo.vo.MsgEvent;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liudongwei
 * @Type MyWorkHandler
 * @Desc
 * @date 2022-04-05 18:44
 */
@Slf4j
public class MsgWorkHandlerConsumer implements WorkHandler<MsgEvent> {

    private String name;

    public MsgWorkHandlerConsumer(String name) {
        this.name = name;
    }


    @Override
    public void onEvent(MsgEvent msgEvent) throws Exception {
        log.info("{} thread :{} receive data:{}", this.name, Thread.currentThread().getId(), msgEvent.getValue());
    }
}
