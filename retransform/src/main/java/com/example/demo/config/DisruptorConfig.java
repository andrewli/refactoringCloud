/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/15
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.example.demo.common.constant.Constant;
import com.example.demo.service.disruptor.MsgEventFactory;
import com.example.demo.service.disruptor.MsgEventHandlerConsumer;
import com.example.demo.vo.MsgEvent;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/**
 * @author liudongwei
 * @Type OssConfig
 * @Desc
 * @date 2022-03-15 18:47
 */
@Slf4j
@Configuration
public class DisruptorConfig {

    /**
     * 初始化disruptor 队列的基本参数设置
     *
     * @Param []
     * @Return Disruptor
     */
    @Bean
    public Disruptor createDisruptor() {
        Disruptor<MsgEvent> disruptor = new Disruptor<>(new MsgEventFactory(),
                Constant.ringBufferSize,
                Executors.defaultThreadFactory(),
                ProducerType.MULTI,
                new BlockingWaitStrategy());
        return disruptor;
    }

    @Configuration
    public static class Setup {

        @Autowired
        private Disruptor disruptor;

        /**
         * 启动时两个消费者进行监听，一个消息被两个消费者各自独立消费一次：两个独立的消费者，各自对消费ringBuffer中的所有事件。
         * @Param [disruptor]
         * @Return void
         */
        @PostConstruct
        public void disruptorInit() {
            MsgEventHandlerConsumer consumer1 = new MsgEventHandlerConsumer("consumer-1");
            MsgEventHandlerConsumer consumer2 = new MsgEventHandlerConsumer("consumer-2");
            disruptor.handleEventsWith(consumer1, consumer2);
            log.info("disruptor consumer init");
            disruptor.start();
        }
    }
}
