/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/14
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.feign.noannotation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liudongwei
 * @Type ServerProvider
 * @Desc
 * @date 2022-04-14 17:32
 */
@Data
@AllArgsConstructor
public class ServerProvider {

    private String url;

    private String name;
}
