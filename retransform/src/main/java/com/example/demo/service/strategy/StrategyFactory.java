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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liudongwei
 * @Type StrategyFactory
 * @Desc
 * @date 2022-03-25 20:39
 */
@Component
public class StrategyFactory {


    /**
     * 当注入一个List的时候，注入后Spring会将实例化的bean放入List中
     */
    @Autowired
    private List<Strategy> strategies;

    /**
     * 当注入一个Map的时候 ，注入后Spring会将实例化后的bean放入value ，key则为注入后bean的名字
     */
    @Autowired
    private Map<String, Strategy> strategyNameMap;

    public Strategy getStrategyByName(String strategyName) {
        return strategyNameMap.get(strategyName);
    }


    // note: 通过指定一个类型绑定对一个的策略
    private ConcurrentHashMap<Integer, Strategy> strategyTypeMap = new ConcurrentHashMap<>();

    @Autowired
    public StrategyFactory(List<Strategy> strategy) {
        strategy.forEach(e -> {
            strategyTypeMap.put(e.type(), e);
        });
    }

    public Strategy getStrategyByType(Integer strategyType) {
        return strategyTypeMap.get(strategyType);
    }

}

