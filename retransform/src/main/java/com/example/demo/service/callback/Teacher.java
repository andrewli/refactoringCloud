/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/28
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.callback;

import com.example.demo.vo.QuestionCallbackVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liudongwei
 * @Type Teacher
 * @Desc 模拟广播消息，等待各个节点返回消息，例如:检测各个节点是否存活
 * @date 2022-03-28 17:16
 */
@Slf4j
@Component
public class Teacher implements QuestionCallback {


    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private List<IStudent> students;

    @Override
    public void askQuestion() {
        for (IStudent student : students) {
            log.info("send to student start:{}", LocalDateTime.now());
            // 异步线程广播
            CompletableFuture.runAsync(() -> {
                student.resloveQuestion(this);
            }, threadPoolExecutor);

            // 同步线程广播
            // student.resloveQuestion(this);
            log.info("send to student end");

        }
    }

    @Override
    public void askCallback(QuestionCallbackVo questionCallback) {
        log.info("teacher receive answers from student:{}", questionCallback);
    }
}
