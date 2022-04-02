/*
 * Project: AIHouse
 *
 * File Created at 2021/3/29
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */


package com.example.demo.service.delayjob;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@Configuration
public class JobWorker {

    @Autowired
    private RedisDelayedQueue redisDelayedQueue;

    @Autowired
    private Collection<Job> jobListeners;

    @PostConstruct
    public void start() {
        jobListeners.forEach(e -> {
            redisDelayedQueue.consumeQueue(e.queueName(), e.getListener());
        });
    }


}

