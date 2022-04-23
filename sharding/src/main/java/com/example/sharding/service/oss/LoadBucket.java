/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/23
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.sharding.service.oss;

import com.example.sharding.dao.OssBucketMapper;
import com.example.sharding.model.OssBucket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author liudongwei
 * @Type LoadBucket
 * @Desc
 * @date 2022-04-23 21:32
 */
@Slf4j
@Service
public class LoadBucket {

    private ConcurrentHashMap<Integer, List<String>> bucketMap = new ConcurrentHashMap<>();

    @Autowired
    private OssBucketMapper ossBucketMapper;

    /**
     * 加载bucket
     * @Param []
     * @Return void
     */
    @PostConstruct
    public void loadBucket() {
        List<OssBucket> bucketList = ossBucketMapper.queryAll();
        Map<Integer, List<OssBucket>> map = bucketList.stream().collect(Collectors.groupingBy(OssBucket::getStoreType));
        map.forEach((k, v) -> {
            List<String> buckets = v.stream().map(OssBucket::getBucketName).collect(Collectors.toList());
            bucketMap.put(k, buckets);
        });
    }

    public List<String> getBucketName(Integer storeType) {
        return bucketMap.get(storeType);
    }
}
