/*
 * Project: retransformDemo
 *
 * File Created at 2021/9/26
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.sharding.controller;

import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.example.sharding.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type TestController
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@RestController
public class BaiduUidController {

    @Autowired
    private CachedUidGenerator cachedUidGenerator;

    @GetMapping("getBaiduUuid/cache")
    public Result getBaiduUuidByCache() {
        long uid = cachedUidGenerator.getUID();
        return Result.create(uid);
    }

}

