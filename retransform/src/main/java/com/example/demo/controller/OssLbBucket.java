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

package com.example.demo.controller;

import com.example.demo.constant.Result;
import com.example.demo.service.oss.BucketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author liudongwei
 * @Type OssLbBucket
 * @Desc
 * @date 2022-04-07 18:22
 */
@Slf4j
@RestController
public class OssLbBucket {


    @Autowired
    private BucketService bucketService;

    @GetMapping("/getBucketName")
    public Result getBucketName() {

        List<String> bucketNames = Arrays.asList("bucket-1", "bucket-2", "bucket-3", "bucket-4");
        String bucketName = bucketService.acquireBucket(bucketNames);
        return Result.create(bucketName);
    }
}
