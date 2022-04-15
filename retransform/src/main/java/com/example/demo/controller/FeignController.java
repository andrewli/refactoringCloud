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

package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.constant.Result;
import com.example.demo.service.feign.annotation.WeatherFeignService;
import com.example.demo.service.feign.noannotation.ThirdAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type TestController
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@RestController
public class FeignController {

    @Autowired
    private WeatherFeignService feignService;

    @Autowired
    private ThirdAppService thirdAppService;

    @GetMapping("queryWeatherByAnno")
    public Result queryWeatherByAnno(@RequestParam("location") String location, @RequestParam("key") String key) {
        return feignService.getWeatherNow(location, key);
    }

    @GetMapping("queryWeatherByNoAnno")
    public JSONObject queryWeatherByNoAnno(@RequestParam("location") String location, @RequestParam("key") String key) {
        return thirdAppService.queryWeather(location, key);
    }

}

