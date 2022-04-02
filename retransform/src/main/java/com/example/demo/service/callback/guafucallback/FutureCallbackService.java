/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/30
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.callback.guafucallback;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author liudongwei
 * @Type FutureCallbackService
 * @Desc
 * @date 2022-03-30 12:18
 */
@Slf4j
@Component
public class FutureCallbackService {

    @Autowired
    private ListeningExecutorService listeningExecutorService;

    /**
     * Callabe :  define job
     * FutureCallback: define job callback
     * demo : common | exception
     * @Param []
     * @Return void
     */
    public void doJobCallback() {

        Callable<Integer> job = () -> {
            log.info("job-1 is executing");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                log.error("job-1 error:{}", e);
            }
            log.info("job-1 is done");
            return 100;
        };

        FutureCallback<Integer> futureCallback = new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                log.info("FutureCallback return result:{}", result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                log.error("FutureCallback throw Exception:{}", throwable);
            }
        };
        addJobCallback(job, futureCallback);

        addJobCallback(
                (Callable<String>) () -> {
                    log.info("job-2 start throw RuntimeException");
                    TimeUnit.SECONDS.sleep(5);
                    int i = 10 / 0;
                    return "success";
                },
                new FutureCallback<String>() {
                    @Override
                    public void onSuccess(@Nullable String result) {
                        log.info("FutureCallback return result:{}", result);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        log.error("FutureCallback throw Exception:{}", throwable);
                    }
                });

    }


    /**
     * Futures.addCallback()： 为任务绑定回调接口
     *
     * @Param [job, futureCallback]
     * @Return void
     */
    private void addJobCallback(Callable job, FutureCallback futureCallback) {
        ListenableFuture<Integer> future = listeningExecutorService.submit(job);
        Futures.addCallback(future, futureCallback, listeningExecutorService);
    }

}
