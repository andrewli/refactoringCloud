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


package com.example.demo.service.lock;

import com.example.demo.common.constant.Result;
import com.example.demo.common.constant.ResultCode;
import com.example.demo.service.delayjob.RedisDelayedQueue;
import com.example.demo.util.Jnanoid;
import com.example.demo.vo.DelayJob;
import com.example.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@Service
public class LockService {


    public static int count = 0;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedisDelayedQueue redisDelayedQueue;

    /**
     * 通过加锁，并发调用i++,返回值
     *
     * @Param []
     * @Return int
     * <p>
     * 读写锁只关心 key , 和代码 readWriteLock 是否多次获取无关
     * @Param [redisKey]
     * @Return void
     */
    public Result lock() {

        RLock lock = redissonClient.getLock("commonLock");
        try {
            if (lock.tryLock(3, 120, TimeUnit.SECONDS)) {

                return Result.create(count++);
            } else {
                return Result.error(ResultCode.PARAMETER_ILLEGAL, "程序执行中，稍后重试");
            }
        } catch (InterruptedException e) {
            log.error("error:{}", e);
            return Result.error(ResultCode.PARAMETER_ILLEGAL, "error");
        } finally {
            if (lock != null && lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    /**
     * 读写锁只关心 key , 和代码 readWriteLock 是否多次获取无关
     *
     * @Param [redisKey]
     * @Return void
     */
    public void readLock(String redisKey) {

        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(redisKey);
        RLock readLock = readWriteLock.readLock();
        try {
            readLock.lock(10, TimeUnit.SECONDS);
            log.info("read lock entry, threadId:{},time:{}", Thread.currentThread().getId(), System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            log.info("thread:{} read unlock,time:{}", Thread.currentThread().getId(), System.currentTimeMillis());
            if (readLock != null && readLock.isLocked() && readLock.isHeldByCurrentThread()) {
                readLock.unlock();
            }
        }

    }

    public void writeLock(String redisKey) {
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(redisKey);
        RLock writeLock = readWriteLock.writeLock();
        try {
            writeLock.lock(40, TimeUnit.SECONDS);
            log.info("write lock entry, threadId:{},time:{}", Thread.currentThread().getId(), System.currentTimeMillis());
            Thread.sleep(30000);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            log.info("thread:{} write unlock,time:{}", Thread.currentThread().getId(), System.currentTimeMillis());
            if (writeLock != null && writeLock.isLocked() && writeLock.isHeldByCurrentThread()) {
                writeLock.unlock();
            }
        }
    }


    public void offerDelayJob(DelayJob delayJob) {

        redisDelayedQueue.addQueue(delayJob.getData(), delayJob.getDelayTime(), TimeUnit.SECONDS);

    }


    /**
    * redisTemplate 用法
    * @Param [key]
    * @Return void
    */
    public void setJsonContent(String key) {
        User user = new User();
        user.setId(Jnanoid.randomId());
        user.setAge(88);
        user.setName("小胖孩");
        user.setDate(LocalDateTime.now());
        redisTemplate.opsForValue().set(key, user);
    }
}
