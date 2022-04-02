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

import com.example.demo.vo.QuestionCallbackVo;

/**
 * @author liudongwei
 * @Type QuestionCallback
 * @Desc
 * @date 2022-03-28 17:15
 */
public interface QuestionCallback {

    /**
    * 老师向学生提问问题
    * @Param []
    * @Return void
    */
    void askQuestion();


    /**
    * 学生回答问题回调老师接口，告知老师答案
    * @Param [result]
    * @Return void
    */
    void askCallback(QuestionCallbackVo questionCallback);

}
