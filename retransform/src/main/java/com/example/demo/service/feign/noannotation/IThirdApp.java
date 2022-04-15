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

package com.example.demo.service.feign.noannotation;

import com.alibaba.fastjson.JSONObject;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

/**
 * @author liudongwei
 * @Type WeatherApi
 * @Desc
 * @date 2022-04-12 13:39
 */
public interface IThirdApp {

    // request demo:  https://free-api.heweather.net/s6/weather/now?location=CN101230110&key=1dc1bafe12ca4eccaa534f1724869f47

    /**
    * feign 原生注解
    * @Param [queryMap]
    * @Return JSONObject
    */
    @RequestLine("GET /s6/weather/now")
    JSONObject queryWeather(@QueryMap Map<String, Object> queryMap);


    /**
    * 需要 feign 配置springmvcContract
    * @Param [location, key]
    * @Return JSONObject
    */
    /*@GetMapping("/s6/weather/now")
    JSONObject queryWeather(@RequestParam("location") String location, @RequestParam("key") String key);*/

}
