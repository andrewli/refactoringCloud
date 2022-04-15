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

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liudongwei
 * @Type FeignInterceptor
 * @Desc
 * @date 2020年05月15日 13:50
 */
@Slf4j
@Data
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        if (template.url().contains("/gateway/token/query")) {
            return;
        }
        try {
            // 对 header param body 进行拦截处理  例如：template.header("ACCESS_TOKEN", "");
        } catch (Exception e) {
            log.error("interceptor error:{}", e);
            throw new RuntimeException("request interceptor error:{}", e);
        }
    }
}
