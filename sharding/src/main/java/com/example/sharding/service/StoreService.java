/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/21
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

import com.alibaba.fastjson.JSONObject;
import com.example.sharding.common.enums.StoreTypeEnum;
import com.example.sharding.common.vo.StoreVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author liudongwei
 * @Type ShardingService
 * @Desc
 * @date 2022-04-21 19:25
 */
@Slf4j
@Service
public class StoreService {

    @Autowired
    private StrategyFactory strategyFactory;

    public Long add(StoreVo storeVo) {
        Integer storeType = storeVo.getStoreType();
        Assert.notNull(storeType, "存储类型不能为空");
        StoreTypeEnum storeTypeEnum = StoreTypeEnum.get(storeType);
        Assert.notNull(storeTypeEnum, "存储类型不存在");
        Class classType = storeTypeEnum.getDesc().getClassType();
        Strategy strategy = strategyFactory.getStrategy(storeType);
        Long fileUuid = strategy.add(JSONObject.parseObject(JSONObject.toJSONString(storeVo.getData()), classType));
        return fileUuid;

    }

    public Object findByUuid(Integer type, Long uuid) {
        Strategy strategy = strategyFactory.getStrategy(type);
        return strategy.findByUuid(uuid);

    }

    public Long total(Integer type) {
        Strategy strategy = strategyFactory.getStrategy(type);
        return strategy.total();
    }


}
