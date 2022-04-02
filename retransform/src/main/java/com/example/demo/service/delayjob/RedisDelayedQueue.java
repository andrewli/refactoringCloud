/*
 * Project: sky
 *
 * File Created at 2021/3/27
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.delayjob;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@Service
public class RedisDelayedQueue {

    @Autowired
    RedissonClient redissonClient;

    /**
     * note: 一个类的延时队列作为一个队列名称
     *
     * @param t
     * @param delay
     * @param timeUnit
     * @param <T>
     */
    public <T> void addQueue(T t, long delay, TimeUnit timeUnit) {
        RBlockingQueue<T> blockingFairQueue = redissonClient.getBlockingQueue(t.getClass().getName());
        RDelayedQueue<T> delayedQueue = redissonClient.getDelayedQueue(blockingFairQueue);
        delayedQueue.offer(t, delay, timeUnit);
    }

    /**
     *  note：不推荐这种写法，延时任务都是由一个线程进行串行执行，应该把任务封装为任务放进线程池中处理
     */
    /*public <T> void consumeQueue(String queueName, TaskEventListener taskEventListener) {
        RBlockingQueue<T> blockingFairQueue = redissonClient.getBlockingQueue(queueName);
        new Thread(() -> {
            log.info("delay queue name:{} start,thread:{}--------->", queueName, Thread.currentThread().getName());
            while (true) {
                try {
                    if (blockingFairQueue.isEmpty()) {
                        continue;
                    }
                    T t = blockingFairQueue.take();
                    log.info("redis queue pop a job:{}", t);
                    taskEventListener.invoke(t);
                } catch (InterruptedException e) {
                    log.error("delay queue name:{} err:{}", queueName, e);
                    continue;
                }
            }
        }).start();
    }*/


    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    public <T> void consumeQueue(String queueName, TaskEventListener taskEventListener) {
        log.info("redis delay queue name:{}", queueName);
        RBlockingQueue<T> blockingFairQueue = redissonClient.getBlockingQueue(queueName);

        CompletableFuture.runAsync(() -> {
            for (; ; ) {
                try {
                    T t = blockingFairQueue.take();
                    log.debug("thread:{} redis queue pop a job:{}", Thread.currentThread().getId(), t);
                    Runnable r = () -> {
                        taskEventListener.invoke(t);
                    };
                    threadPoolExecutor.submit(r);
                } catch (InterruptedException e) {
                    log.error("delay queue:{} pop a job error:{}", queueName, e);
                    continue;
                }
            }
        }, threadPoolExecutor);

    }
}
