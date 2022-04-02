/*
 * Project: AIHouse
 *
 * File Created at 2021/3/30
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */



package com.example.demo.service.delayjob;


/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021-09-26 17:42
 */
public interface TaskEventListener<T> {


    void invoke(T t);
}

