/*
 * Project: mybatis_hello
 *
 * File Created at 2022/4/6
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
import com.lmax.disruptor.EventFactory;

/**
 * @author liudongwei
 * @Type OrderFactory
 * @Desc
 * @date 2022-04-06 19:15
 */
public class MsgEventFactory implements EventFactory<MsgEvent> {

    @Override
    public MsgEvent newInstance() {
        return new MsgEvent();
    }
}
