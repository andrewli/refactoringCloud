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
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.List;

/**
 * @author liudongwei
 * @Type MsgProducer
 * @Desc disruptor 生产者
 * @date 2022-04-05 16:18
 */
public class MsgProducer {

    private Disruptor disruptor;
    public MsgProducer(Disruptor disruptor){
        this.disruptor = disruptor;
    }

    public void send(String data){
        RingBuffer<MsgEvent> ringBuffer = this.disruptor.getRingBuffer();
        long next = ringBuffer.next();
        try{
            MsgEvent event = ringBuffer.get(next);
            event.setValue(data);
        }finally {
            //注意最后的publish方法必须放在finally中以确保必须得到调用；如果某个请求的sequence未被提交将会堵塞后续的发布操作或者其他的producer
            ringBuffer.publish(next);
        }
    }

    public void send(List<String> dataList){
        dataList.stream().forEach(data -> this.send(data));
    }

}
