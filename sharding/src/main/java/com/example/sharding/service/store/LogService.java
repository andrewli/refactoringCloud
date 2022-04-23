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

package com.example.sharding.service.store;

import com.example.sharding.common.enums.StoreTypeEnum;
import com.example.sharding.dao.LogMapper;
import com.example.sharding.model.Log;
import com.example.sharding.service.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liudongwei
 * @Type ConcreteStrategy1
 * @Desc
 * @date 2022-03-25 20:37
 */
@Slf4j
@Component
public class LogService extends BaseService  implements Strategy<Log> {

    @Autowired
    private LogMapper logMapper;


    @Override
    public Integer type() {
        return StoreTypeEnum.LOG.getCode();
    }


    @Override
    public void add(Log log) {
        log.setUuid(cachedUidGenerator.getUID());
        logMapper.add(log);
    }

    @Override
    public Log findbyId(Long id) {
        return null;
    }
}
