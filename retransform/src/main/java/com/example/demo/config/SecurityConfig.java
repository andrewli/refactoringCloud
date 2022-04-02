/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/27
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

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author liudongwei
 * @Type SecurityConfig
 * @Desc http://127.0.0.1:8089/retransform/actuator/ 访问健康状态接口时需要认证
 * @date 2022-03-27 21:29
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 访问 EndPoint 地址，需要经过认证，并且拥有 ADMIN 角色
        http.requestMatcher(EndpointRequest.toAnyEndpoint())
                .authorizeRequests((requests) -> requests.anyRequest().hasRole("ADMIN"));
        //  开启 Basic Auth
        http.httpBasic();
    }

}
