/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/25
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liudongwei
 * @Type DefaultStrategy
 * @Desc
 * @date 2022-03-25 20:34
 */
@Slf4j
@Component
public class DefaultStrategy implements Strategy {


    @Override
    public Integer type() {
        return 0;  // 0：表示默认
    }

    @Override
    public void doSomething() {
        log.info("default strategy: 默认行为");
    }
}
