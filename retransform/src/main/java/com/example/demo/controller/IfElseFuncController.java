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

package com.example.demo.controller;

import com.example.demo.constant.Result;
import com.example.demo.service.functioninterface.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type StrategyController
 * @Desc 策略模式的方式
 * @date 2022-03-25 22:02
 */
@Slf4j
@RestController
public class IfElseFuncController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("activity")
    public Result activity(@RequestParam("userId") String userId,
                           @RequestParam("source") Integer source) {
        Boolean rewardResult = activityService.getReward(userId, source);
        return Result.create(rewardResult);
    }


}
