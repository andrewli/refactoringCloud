/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/18
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.proxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liudongwei
 * @Type Real
 * @Desc
 * @date 2022-04-18 15:52
 */
@Slf4j
@Service
public class RealDog implements IDog {

    @Override
    public void bark() {
        log.info("real dog bark");
    }

    @Override
    public String eat() {
        log.info("dog like eating meet");
        return "beef";
    }
}
