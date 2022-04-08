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

package com.example.demo.controller;

import com.example.demo.constant.Result;
import com.example.demo.service.callback.FuncService;
import com.example.demo.service.callback.Teacher;
import com.example.demo.service.callback.guacallback.FutureCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type CallbackController
 * @Desc 回调的核心: 双向调用，回调的核心就是回调方将本身即this传递给调用方，这样调用方就可以在调用完毕之后告诉回调方它想要知道的信息
 *       类A的a()方法调用类B的b()方法
 *       类B的b()方法执行完毕主动调用类A的callback()方法
 * @date 2022-03-28 16:42
 */
@RestController
public class CallbackController {


    // 场景1：老师向众多学生提问，学生回答问题后将结果反馈给老师
    @Autowired
    private Teacher teacher;

    @GetMapping("/teacher/askQuestion")
    public Result askQuestion() {
        teacher.askQuestion();
        return Result.create();
    }


    // 场景2：方法参数传入函数体

    @Autowired
    private FuncService funcService;

    @GetMapping("/allocate/apply")
    public Result teacherApply() {
        funcService.doing();
        return Result.create();
    }


    @Autowired
    private FutureCallbackService futureCallbackService;

    /**
    * google FutureCallback usage
    * @Param []
    * @Return Result
    */
    @GetMapping("/guava/callback")
    public Result guaCallback() {
        futureCallbackService.doJobCallback();
        return Result.create();
    }

}
