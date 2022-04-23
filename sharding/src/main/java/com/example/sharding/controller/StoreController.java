/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/29
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

import com.example.sharding.common.Result;
import com.example.sharding.common.vo.StoreVo;
import com.example.sharding.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type AssertController
 * @Desc
 * @date 2022-03-29 14:34
 */
@Slf4j
@RestController
public class StoreController extends BaseController {

    @Autowired
    private StoreService shardingService;

    @PostMapping("/add")
    public Result add(@RequestBody StoreVo storeVo) {
        shardingService.add(storeVo);
        return Result.create();
    }

    @GetMapping("/query")
    public Result get(@RequestParam("type")Integer type, @RequestParam("id") Long id) {
        return Result.create(shardingService.findById(type,id));
    }



}
