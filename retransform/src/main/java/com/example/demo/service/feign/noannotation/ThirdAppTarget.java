/*
 * Project: littlec-base
 *
 * File Created at 2020/5/15
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.feign.noannotation;

import feign.Request;
import feign.RequestTemplate;
import feign.Target;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liudongwei
 * @Type AiHouseTarget
 * @Desc
 * @date 2020年05月15日 13:35
 */
@Slf4j
public class ThirdAppTarget<T> implements Target<T> {

    private Class<T> clazz;

    private ServerProvider serverProvider;

    public ThirdAppTarget(Class<T> clazz, ServerProvider serverProvider) {
        this.clazz = clazz;
        this.serverProvider = serverProvider;
    }

    @Override
    public Class<T> type() {
        return clazz;
    }

    @Override
    public String name() {
        return serverProvider.getName();
    }

    @Override
    public String url() {
        return serverProvider.getUrl();
    }

    @Override
    public Request apply(RequestTemplate input) {

        if (input.url().indexOf("http") != 0) {
            input.target(url());
        }
        Request request = input.request();
        log.info("The request : {} ", request.toString());
        return request;
    }

}
