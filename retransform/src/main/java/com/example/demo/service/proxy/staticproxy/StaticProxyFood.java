/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/18
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.proxy.staticproxy;

import com.example.demo.vo.Food;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liudongwei
 * @Type ProxyFood
 * @Desc
 * @date 2022-04-18 15:18
 */
@Slf4j
@Service
public class StaticProxyFood implements IFood {

    @Autowired
    private RealFood realFood;

    @Override
    public List<Food> produce() {

        log.info("proxy food enhance content start");

        List<Food> realFoodProduce = realFood.produce();

        List<Food> result = new ArrayList<>();
        result.addAll(realFoodProduce);
        Food enhanceFood = new Food();
        enhanceFood.setColor("enhance color");
        enhanceFood.setName("enhance food");
        result.add(enhanceFood);
        log.info("proxy food enhance content end");
        return realFoodProduce;
    }
}
