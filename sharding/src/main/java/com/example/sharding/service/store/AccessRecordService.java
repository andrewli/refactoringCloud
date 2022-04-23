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
import com.example.sharding.dao.AccessRecordMapper;
import com.example.sharding.model.AccessRecord;
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
public class AccessRecordService extends BaseService implements Strategy<AccessRecord> {

    @Autowired
    private AccessRecordMapper accessRecordMapper;


    @Override
    public Integer type() {
        return StoreTypeEnum.ACCESS_RECORD.getCode();
    }

    @Override
    public Long add(AccessRecord accessRecord) {
        long fileUuid = cachedUidGenerator.getUID();
        accessRecord.setUuid(fileUuid);
        accessRecordMapper.add(accessRecord);
        return fileUuid;
    }

    @Override
    public AccessRecord findByUuid(Long uuid) {
        return accessRecordMapper.findByUuid(uuid);

    }

    @Override
    public Long total() {
        return accessRecordMapper.total();
    }
}
