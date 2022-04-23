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

import lombok.Data;

import java.io.Serializable;

/**
 * @author liudongwei
 * @Type StoreVo
 * @Desc
 * @date 2022-04-23 11:45
 */
@Data
public class StoreVo<T> implements Serializable {

    private Integer storeType;

    private T data;


}
