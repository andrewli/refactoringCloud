/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/23
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.sharding.common.vo;

/**
 * @author liudongwei
 * @Type Desc
 * @Desc
 * @date 2022-04-23 12:18
 */

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Desc {
    private String description;
    private Class classType;
}
