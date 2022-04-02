/*
 * Project: retransformDemo
 *
 * File Created at 2022/4/1
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.xxljob.service;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liudongwei
 * @Type XxlJob
 * @Desc
 * @date 2022-04-01 18:33
 */
@Slf4j
@Component
public class XxlJobCollection {

    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler() throws Exception {
        String param = XxlJobHelper.getJobParam();
        XxlJobHelper.log("XXL-JOB, HHHHHHHH：{}", param);
        return ReturnT.SUCCESS;
    }

    @XxlJob("demoJobHandler2")
    public ReturnT<String> demoJobHandler2() throws Exception {
        String param = XxlJobHelper.getJobParam();
        XxlJobHelper.log(" >>>>>>> {}", param);
        return ReturnT.SUCCESS;
    }
}
