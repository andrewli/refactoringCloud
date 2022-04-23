/*
 * Project: retransformDemo
 *
 * File Created at 2021/9/26
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.sharding.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.sharding.common.Result;
import com.example.sharding.common.ResultCode;
import com.example.sharding.service.StoreService;
import com.example.sharding.service.oss.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liudongwei
 * @Type TestController
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@RestController
public class FileController extends BaseController {


    @Autowired
    private FileService fileService;

    @Autowired
    private StoreService storeService;

    @PostMapping("upload")
    public Result upload(@RequestParam("file") MultipartFile file,
                         @RequestParam("storeType") Integer storeType,
                         @RequestParam("expireDays") Integer expireDays) {
        try {
            JSONObject uploadRes = fileService.uploadFile(file, storeType, expireDays);
            return Result.create(uploadRes);
        } catch (Exception e) {
            log.error("upload file error:{}", e);
            return Result.error(ResultCode.PARAMETER_ILLEGAL, "上传文件失败");
        }
    }


    @GetMapping("/query")
    public Result get(@RequestParam("type")Integer type, @RequestParam("uuid") Long uuid) {
        return Result.create(storeService.findByUuid(type,uuid));
    }

    @GetMapping("/total")
    public Result total(@RequestParam("type")Integer type) {
        return Result.create(storeService.total(type));
    }


}

