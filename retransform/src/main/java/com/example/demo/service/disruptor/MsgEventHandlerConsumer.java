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
import com.lmax.disruptor.EventHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liudongwei
 * @Type MsgConsumer
 * @Desc
 * @date 2022-04-05 16:20
 */
@Slf4j
public class MsgEventHandlerConsumer implements EventHandler<MsgEvent> {

    private String name;

    public MsgEventHandlerConsumer(String name) {
        this.name = name;
    }


    /**
     * l: sequence   b:endOfBatch
     *
     * @Param [msgEvent, l, b]
     * @Return void
     */
    @Override
    public void onEvent(MsgEvent msgEvent, long l, boolean b) throws Exception {
        log.info("{} thread :{} receive data:{}", this.name, Thread.currentThread().getId(), msgEvent.getValue());
    }

}
