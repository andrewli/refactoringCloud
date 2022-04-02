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

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author liudongwei
 * @Type FuncService
 * @Desc
 * @date 2022-03-28 21:23
 */
@Slf4j
@Component
public class FuncService {

    public void doing() {
        String[] strArr = {"zhangsan", "lisi", "wangwu"};
        List<String> strList = Arrays.stream(strArr).collect(Collectors.toList());

        // 加上异步线程执行
        Consumer<List<String>> consumer = (list) -> {
            for (String s : list) {
                log.info("element is :{}", s);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    log.error("execute error:{}", e);
                }
            }
        };
        allocate(strList, consumer);
    }

    private  <T> void allocate(T t, Consumer<T> consumer) {
        Assert.notNull(consumer, "[Assertion failed] - the consumer method  argument is required; it must not be null");
        consumer.accept(t);
    }


}
