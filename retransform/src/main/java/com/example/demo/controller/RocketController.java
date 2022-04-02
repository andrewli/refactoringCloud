/*
 * Project: sky5
 *
 * File Created at 2021/3/3
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
import com.example.demo.service.rocketmq.RockeMqProducer;
import com.example.demo.util.Jnanoid;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author liudongwei
 * @Type RocketController
 * @Desc
 * @date 2021年03月03日 15:30
 */
@RestController
public class RocketController {


    @Autowired
    private RockeMqProducer rockeMqProducer;


    @GetMapping("/rocketmq/access-topic/sendMessage")
    public Result sendMessage(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        User user = new User();
        user.setId(Jnanoid.randomId());
        user.setName(name);
        user.setAge(age);
        user.setDate(LocalDateTime.now());
        List<User> list = Collections.singletonList(user);
        rockeMqProducer.send(list);
        return Result.create();
    }

}
