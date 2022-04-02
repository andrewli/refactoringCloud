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

package com.example.demo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liudongwei
 * @Type QuestionCallback
 * @Desc
 * @date 2022-03-28 17:27
 */
@Data
public class QuestionCallbackVo implements Serializable {

    private String studentId;

    private String studentName;

    private String answerResult;

}
