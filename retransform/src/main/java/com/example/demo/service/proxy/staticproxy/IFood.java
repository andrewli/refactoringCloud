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

import java.util.List;

/**
 * @author liudongwei
 * @Type IFood
 * @Desc
 * @date 2022-04-18 15:14
 */
public interface IFood {

    List<Food> produce();

}
