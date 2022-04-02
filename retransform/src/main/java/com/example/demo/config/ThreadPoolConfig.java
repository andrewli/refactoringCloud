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

package com.example.demo.config;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liudongwei
 * @Type ThreadPoolConfig
 * @Desc
 * @date 2022-03-28 22:35
 */
@Configuration
public class ThreadPoolConfig {


    /*
     为什么启动一个线程池，提交一个任务后，Main方法不会退出？
     ①工作线程不会死（不设置线程存活时间，默认情况下），会一直拿任务，所以工作线程会一直活着
     ②工作线程拿任务的时候，默认情况下，因为用的是BlockingQueue的take()拿不到任务会阻塞
     ③core 核心线程总数不是程序初始化就启动创建完成，而是分配任务的时候创建的，任务数 < core 核心数，就会一直在线程池中创建任务，直到 > core,就会放到 workqueue 队列中
     ④使用线程池后，若core 线程创建结束后，因为①和②的原因，线程会因为while 循环和 workqueue.take() 不断取任务和阻塞取任务，一直存活，为了避免线程池资源泄漏，一定使用全屋线程池，而不是局部线程池变量

     execute 和 submit 区别：
     ①submit在执行过程中与execute不一样，不会抛出异常而是把异常保存在成员变量中，在FutureTask.get()阻塞获取的时候再把异常抛出来
     ②Spring的@Schedule注解的内部实现就是使用submit，因此，如果你构建的任务内部有未检查异常，是永远也拿不到这个异常的
     ③execute直接抛出异常之后线程就死掉了，submit保存异常线程没有死掉，CompletableFuture.runAsync() 也是会保存线程异常信息的，通过get()获取到异常信息，不会让线程死掉

    */

    /**
     * @Param []
     * @Return ThreadPoolExecutor
     */
    @Bean
    ThreadPoolExecutor createThreadPoolExecutor() {
        return new ThreadPoolExecutor(
                10,
                10,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1000));
    }

    /**
    * google FutureCallback usage
    * @Param [threadPoolExecutor]
    * @Return ListeningExecutorService
    */
    @Bean
    ListeningExecutorService createListeningExecutor(ThreadPoolExecutor threadPoolExecutor) {
        return MoreExecutors.listeningDecorator(threadPoolExecutor);
    }


}
