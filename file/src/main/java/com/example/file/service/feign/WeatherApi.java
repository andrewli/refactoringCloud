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
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liudongwei
 * @Type WeatherApi
 * @Desc
 * @date 2022-04-12 13:39
 */
@FeignClient(name = "weatherApi", url = "${weather.api.url}", configuration = FeignConfig.class)

public interface WeatherApi {

    // request demo:  https://free-api.heweather.net/s6/weather/now?location=CN101230110&key=1dc1bafe12ca4eccaa534f1724869f47


    @GetMapping(value = "/s6/weather/now")
    JSONObject weatherNow(@RequestParam("location") String location, @RequestParam("key") String key);


}
