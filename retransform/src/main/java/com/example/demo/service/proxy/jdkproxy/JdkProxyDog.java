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

package com.example.demo.service.proxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;


/**
 * @author liudongwei
 * @Type JdkProxyDog
 * @Desc
 * @date 2022-04-18 15:55
 */
@Slf4j
@Service
public class JdkProxyDog {

    @Autowired
    private IDog target;

    public IDog getProxy() {
        return (IDog) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    log.info("enhance method content start");
                    return method.invoke(target, args);
                });
    }

}
