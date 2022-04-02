/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/27
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

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liudongwei
 * @Type OrderMessage
 * @Desc
 * @date 2022-03-27 16:13
 */
@Data
public class OrderMessage implements Serializable {

    private String orderId;           // 订单编号
    private String note;              // 订单留言
    private LocalDateTime dateTime;  // 下单时间

}
