/*
 * Project: AIHouse
 *
 * File Created at 2021/3/29
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.

 */


package com.example.demo.service.delayjob;

import com.example.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@Service
public class UserDelayJob implements Job<User> {

    @Override
    public String queueName() {
        return User.class.getName();
    }

    @Override
    public TaskEventListener<User> getListener() {
        TaskEventListener<User> jobListener = e -> {
            log.info("thread:{} user delay job callback  user detail:{}", Thread.currentThread().getId(), e);
            doUserJobAction(e);
        };
        return jobListener;
    }

    private void doUserJobAction(User e) {
        log.info("thread:{} user delay job is doing", Thread.currentThread().getId());
    }


}
