/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/30
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

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

/**
 * @author liudongwei
 * @Type Jnanoid
 * @Desc A unique string ID generator for Java.
 * @date 2022-03-30 17:05
 */
public class Jnanoid {

    public static String randomId() {
        return NanoIdUtils.randomNanoId();
    }

    public static void main(String[] args) {
        String s = randomId();
        System.out.println(s);
    }

}
