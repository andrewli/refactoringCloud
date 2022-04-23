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

package com.example.sharding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liudongwei
 * @Type StrategyFactory
 * @Desc
 * @date 2022-03-25 20:39
 */
@Component
public class StrategyFactory {

    private ConcurrentHashMap<Integer, Strategy> strategyTypeMap = new ConcurrentHashMap<>();

    @Autowired
    public StrategyFactory(List<Strategy> strategy) {
        strategy.forEach(e -> {
            strategyTypeMap.put(e.type(), e);
        });
    }

    public Strategy getStrategy(Integer strategyType) {
        return strategyTypeMap.get(strategyType);
    }

}

