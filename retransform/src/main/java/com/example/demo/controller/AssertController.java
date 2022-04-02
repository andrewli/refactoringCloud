/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/29
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
import com.example.demo.vo.RegisterUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author liudongwei
 * @Type AssertController
 * @Desc
 * @date 2022-03-29 14:34
 */
@Slf4j
@RestController
public class AssertController extends BaseController {


    /**
     * Assert 的常用API: 不合法抛出IllegalArgumentException
     * @Param [name, address, ages]
     * @Return Result
     */
    @GetMapping("/assert/example")
    public Result sendMessage(@RequestParam(value = "name",required = false) String name,
                              @RequestParam(value = "address",required = false) String address,
                              @RequestParam(value = "ages",required = false) List<Integer> ages) {

        Assert.hasText(name, "name must not be null");
        Assert.notNull(address, "address must not be empty");
        Assert.noNullElements(ages, "ages must have a element");
        Assert.notEmpty(ages, "ages must have a element");
        return Result.create();
    }


    @PostMapping("/assert/register")
    public Result register(@Valid @RequestBody RegisterUserVo registerUserVo) {
        /*
           测试用户注册表单信息报错，通过@Valid注解，异常捕获实现返回错误结果
           用户注册，密码文明，加密方式，（1）md5+加盐  （2）Bcrypt 算法
           md5+加盐：缺点 因为每个密码都需要一个随机的盐值，所以需要积累密文对应的盐值， 而且明文相同，盐值相同，md5值一定相同
           Bcrypt 算法，优点不需要记录盐值，因为盐值记录在生成的密文中，不需要单独记录盐值
        */

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(registerUserVo.getPassWord());
        boolean match = bCryptPasswordEncoder.matches(registerUserVo.getPassWord(), encode);
        log.info("raw password:{} resolve encode password:{} match result:{}", registerUserVo.getPassWord(), encode, match);
        return Result.create();
    }
}
