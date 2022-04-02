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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author liudongwei
 * @Type Student1
 * @Desc
 * @date 2022-03-28 17:30
 */
@Slf4j
@Component
public class Student1 implements IStudent {

    @Override
    public void resloveQuestion(QuestionCallback questionCallback) {
        //  学生处理思考问题的时间，以 sleep 模拟
        try {
            TimeUnit.SECONDS.sleep( 15);
        } catch (InterruptedException e) {
            log.info("error info:{}", e);
        }
        log.info("student-1 sleep end");

        QuestionCallbackVo questionCallbackVo = new QuestionCallbackVo();
        questionCallbackVo.setStudentId("123-abc");
        questionCallbackVo.setStudentName("zhangsan");
        questionCallbackVo.setAnswerResult("student-1's answer is " + questionCallbackVo.getStudentId());
        questionCallback.askCallback(questionCallbackVo);
    }
}
