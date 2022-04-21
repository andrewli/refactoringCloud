/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/20
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author liudongwei
 * @Type RetryableService
 * @Desc
 * @date 2022-04-20 19:55
 */
@Slf4j
@Service
public class RetryService {


    /**
     value：抛出指定异常才会重试
     include：和value一样，默认为空，当exclude也为空时，默认所有异常
     exclude：指定不处理的异常
     maxAttempts：最大重试次数，默认3次
     backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。

     当重试耗尽时，通过@Recover注解实现重试回调(RecoveryCallback)，用于@Retryable重试失败后处理方法。如果不需要回调方法，可以直接不写回调方法
     方法内不能使用try catch，只能往外抛异常
    */

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    public int retryDemo(int code) throws Exception {
        log.info("retryDemo start：{}", LocalTime.now());
        if (code == 0) {
            throw new Exception("retry throw exception");
        }
        log.info("retryDemo end：{}", LocalTime.now());
        return 200;
    }


    /**
     重试回调处理结果: 示例中模拟进行回调日志记录
     方法的返回值必须与@Retryable方法一致
     方法的第一个参数，必须是Throwable类型的，建议是与@Retryable配置的异常一致，其他的参数，需要哪个参数，写进去就可以了（@Recover方法中有的）
     该回调方法与重试方法写在同一个实现类里面
     */

    @Recover
    public int retryDemoRecover(Exception e, int code){
        log.error("Retry failed , param code:{} , callback do record , error:{}",code, e);
        log.info("try 3 times error,callback return the result ");
        return 400;
    }

}
