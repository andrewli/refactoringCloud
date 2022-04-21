/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/28
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

import com.example.demo.common.constant.Result;
import com.example.demo.service.retry.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type CallbackController
 * @Desc
 * @date 2022-03-28 16:42
 */
@RestController
public class RetryController {


    @Autowired
    private RetryService retryService;

    @GetMapping("/retry")
    public Result retry(@RequestParam("code") Integer code) throws Exception {
        int i = retryService.retryDemo(code);
        return Result.create(i);
    }


}
