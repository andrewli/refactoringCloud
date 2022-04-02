/*
 * Project: retransformDemo
 *
 * File Created at 2021/9/26
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

import com.example.demo.service.LogService;
import com.example.demo.constant.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author liudongwei
 * @Type TestController
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@RestController
public class LogController {

    @Autowired
    private LogService testService;

    @PostMapping("createLog")
    public void testLog() {
        new Thread(() -> {
            while (true) {
                log.info("定时任务info级别日志---->{}", LocalDateTime.now().toString());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                log.debug("定时任务debug级别日志---->{}", LocalDateTime.now().toString());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                log.error("定时任务error级别日志---->{}", LocalDateTime.now().toString());

                try {
                    int i = 10 / 0;
                } catch (Exception e) {
                    log.error("计算异常", e);
                }
            }
        }).start();

        return;
    }


    @PostMapping("test")
    public Result test() {
        return testService.testLog();

    }

}

