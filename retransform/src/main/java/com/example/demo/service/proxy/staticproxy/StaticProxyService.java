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

import java.util.List;

/**
 * @author liudongwei
 * @Type StaticProxyService
 * @Desc
 * @date 2022-04-18 15:01
 */
@Slf4j
@Service
public class StaticProxyService {

    /*
        静态代理需要先定义接口，被代理对象与代理对象一起实现相同的接口，然后通过调用相同的方法来调用目标对象的方法
    */

    @Autowired
    private StaticProxyFood proxyFood;

    public List<Food> getFood() {
        return proxyFood.produce();

    }




}
