/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/28
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.callback;

/**
 * @author liudongwei
 * @Type IStudent
 * @Desc
 * @date 2022-03-28 17:17
 */
public interface IStudent {


    /**
     * 学生解决问题
     * @Param [teacher]
     * @Return void
     */
    void resloveQuestion(QuestionCallback questionCallback);
}
