/*
 * Project: retransformDemo
 *
 * File Created at 2022/2/14
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service;

import com.example.demo.constant.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liudongwei
 * @Type TestService
 * @Desc
 * @date 2022-02-14 19:36
 */
@Slf4j
@Service
public class LogService {

    public Result testLog() {
        log.info("这是一个test请求");
        return Result.create();
    }

}
