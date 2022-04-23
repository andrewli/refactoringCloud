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

package com.example.sharding.service.store;

import com.baidu.fsg.uid.impl.CachedUidGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liudongwei
 * @Type BaseService
 * @Desc
 * @date 2022-04-23 13:45
 */
@Slf4j
@Service
public class BaseService {

    @Autowired
    protected CachedUidGenerator cachedUidGenerator;




}
