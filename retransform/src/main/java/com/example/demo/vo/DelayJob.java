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

package com.example.demo.vo;

import lombok.Data;

/**
 * @author liudongwei
 * @Type DelayJob
 * @Desc
 * @date 2022-03-30 21:45
 */
@Data
public class DelayJob<V> {

    private Long delayTime;

    private V data;

}
