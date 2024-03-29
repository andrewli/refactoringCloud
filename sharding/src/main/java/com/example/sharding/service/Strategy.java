/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/25
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.sharding.service;

/**
 * @author liudongwei
 * @Type Strategy
 * @Desc
 * @date 2022-03-25 20:33
 */
public interface Strategy<T> {


    Integer type();

    Long add(T t);

    T findByUuid( Long uuid);

    Long total();


}
