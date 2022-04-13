/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/12
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.file.service.feign;

import com.alibaba.fastjson.JSONObject;
import com.example.file.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liudongwei
 * @Type FeignServie
 * @Desc
 * @date 2022-04-12 13:37
 */
@Slf4j
@Service
public class WeatherFeignService {

    @Autowired
    private WeatherApi weatherApi;

    public Result getWeatherNow(String location, String key) {
        JSONObject weatherNow = weatherApi.weatherNow(location, key);
        return Result.create(weatherNow);
    }


}
