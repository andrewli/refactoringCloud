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

package com.example.sharding.service.oss;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liudongwei
 * @Type RoundRobinLoadBalancer
 * @Desc
 * @date 2022-04-07 18:16
 */
@Slf4j
@Service
public class RoundRobinLoadBalancer implements LoadBalancer {

    private final AtomicInteger index = new AtomicInteger(-1);

    @Override
    public String getEntry(List<String> bucketNames) {
        int ind = Math.abs(this.index.incrementAndGet() % bucketNames.size());
        return bucketNames.get(ind);
    }
}
