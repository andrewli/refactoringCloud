/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/23
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.sharding.config;

import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author liudongwei
 * @Type BaiduUid
 * @Desc  百度 uid generator
 * @date 2022-03-23 19:24
 */
@Component
public class UidGeneratorConfig {

    @Bean
    public DisposableWorkerIdAssigner disposableWorkerIdAssigner() {
        return new DisposableWorkerIdAssigner();
    }


    @Bean
    public CachedUidGenerator initCachedUidGenerator(DisposableWorkerIdAssigner disposableWorkerIdAssigner) {
        CachedUidGenerator cachedUidGenerator = new CachedUidGenerator();
        cachedUidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner);
        cachedUidGenerator.setTimeBits(31);
        cachedUidGenerator.setWorkerBits(20);
        cachedUidGenerator.setSeqBits(12);
        cachedUidGenerator.setEpochStr(LocalDate.now().format(DateTimeFormatter.ofPattern("2022-04-21"))); // 初始时间, 默认:"2016-05-20")，可以自定义
        cachedUidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner);
        return cachedUidGenerator;
    }


}
