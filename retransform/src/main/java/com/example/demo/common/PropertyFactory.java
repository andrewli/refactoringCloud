/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/22
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author liudongwei
 * @Type PropertyFactory
 * @Desc
 * @date 2022-03-22 19:15
 */
public class PropertyFactory {
    private static final Logger logger = LoggerFactory.getLogger(com.sankuai.inf.leaf.common.PropertyFactory.class);
    private static final Properties prop = new Properties();
    static {
        try {
            prop.load(com.sankuai.inf.leaf.common.PropertyFactory.class.getClassLoader().getResourceAsStream("leaf.properties"));
        } catch (IOException e) {
            logger.warn("Load Properties Ex", e);
        }
    }
    public static Properties getProperties() {
        return prop;
    }
}
