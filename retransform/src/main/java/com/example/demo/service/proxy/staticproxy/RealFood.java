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
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author liudongwei
 * @Type RealFood
 * @Desc
 * @date 2022-04-18 15:37
 */
@Slf4j
@Service
public class RealFood implements IFood {

    @Override
    public List<Food> produce() {
        Food food = new Food();
        food.setName("apple");
        food.setColor("red");
        return Collections.singletonList(food);
    }

}
