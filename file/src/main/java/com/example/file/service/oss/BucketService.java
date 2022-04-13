/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/7
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.file.service.oss;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liudongwei
 * @Type BucketService
 * @Desc
 * @date 2022-04-07 18:15
 */
@Slf4j
@Service
public class BucketService {

    @Autowired
    private RoundRobinLoadBalancer roundRobinLoadBalancer;

    public String acquireBucket(List<String> bucketNames) {
        String entryBucket = roundRobinLoadBalancer.getEntry(bucketNames);
        log.info("loadBalance bucket is :{}", entryBucket);
        return entryBucket;
    }
}
