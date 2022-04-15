/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/14
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liudongwei
 * @Type ThirdAppService
 * @Desc
 * @date 2022-04-14 18:21
 */
@Slf4j
@Service
public class ThirdAppService {

    @Autowired
    private IThirdApp thirdApp;

    public JSONObject queryWeather(String location, String key) {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("location", location);
        queryMap.put("key", key);
        return thirdApp.queryWeather(queryMap);

//        return thirdApp.queryWeather(location, key);

    }

}
