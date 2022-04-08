/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/8
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.dao;

import com.example.demo.model.DeviceUserSync;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

/**
 * @author liudongwei
 * @Type ActivityMapper
 * @Desc
 * @date 2022-04-08 15:38
 */
public interface DeviceUserSyncMapper {

    Cursor<DeviceUserSync> scan(@Param("limit") int limit);

}
