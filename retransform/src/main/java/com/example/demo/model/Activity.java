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

package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liudongwei
 * @Type Activity
 * @Desc
 * @date 2022-04-08 15:41
 */
@Data
public class Activity implements Serializable {

    private Long id;

    private String name;

    private String communityName;

    private Long communityUuid;

    private String mobile;

    private String activityTheme;

    private String activityContent;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;

}
