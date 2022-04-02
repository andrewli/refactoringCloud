/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/15
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.util;

/**
 * @author liudongwei
 * @Type UUID
 * @Desc
 * @date 2022-03-15 19:53
 */
public class UUID {

    public static synchronized String generateUUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
