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

package com.example.demo.service.oss;

import java.util.List;

/**
 * @author liudongwei
 * @Type LoadBalancer
 * @Desc
 * @date 2022-04-07 18:15
 */
public interface LoadBalancer {

    String getEntry(List<String> bucketNames);

}
