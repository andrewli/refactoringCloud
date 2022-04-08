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

package com.example.demo.controller;

import com.example.demo.constant.Result;
import com.example.demo.service.mybatis.MybatisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2022-03-29 14:34
 */
@Slf4j
@RestController
public class MybatisController extends BaseController {


    @Autowired
    private MybatisService mybatisService;

    @GetMapping("/mybatis/queryByCursor/{limit}")
    public Result queryByCursor(@PathVariable("limit") int limit) {

        mybatisService.scan(limit);

        return Result.create();
    }

}
