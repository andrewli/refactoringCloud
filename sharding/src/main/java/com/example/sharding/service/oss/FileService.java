/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/23
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.sharding.service.oss;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.sharding.common.enums.StoreTypeEnum;
import com.example.sharding.common.vo.StoreVo;
import com.example.sharding.service.StoreService;
import com.example.sharding.util.DateUtil;
import com.example.sharding.util.Jnanoid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author liudongwei
 * @Type FileService
 * @Desc
 * @date 2022-04-23 21:02
 */
@Slf4j
@Service
public class FileService {

    @Autowired
    private AmazonS3 client;

    @Autowired
    private LoadBucket loadBucket;

    @Autowired
    private BucketService bucketService;

    @Autowired
    private StoreService storeService;


    public JSONObject uploadFile(MultipartFile file, Integer storeType, Integer expireDays) throws IOException {
        StoreTypeEnum storeTypeEnum = StoreTypeEnum.get(storeType);
        Assert.notNull(storeTypeEnum, "存储类型不存在");
        String fileStoreName = generateStoreFileName(file.getOriginalFilename(), expireDays, storeTypeEnum);

        List<String> bucketNames = loadBucket.getBucketName(storeType);
        String bucketName = bucketService.acquireBucket(bucketNames);

        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType(file.getContentType());
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileStoreName, new ByteArrayInputStream(file.getBytes()), meta)
                .withCannedAcl(CannedAccessControlList.PublicRead);
        client.putObject(putObjectRequest);

        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, fileStoreName);
        Date fileExpiration = Date.from(LocalDateTime.now().plusYears(50).atZone(ZoneId.systemDefault()).toInstant());
        request.setExpiration(fileExpiration); // 预签名的URL链接过期时间
        URL url = client.generatePresignedUrl(request);
        log.info("upload url result = {}", url);
        String originalUrl = url.toString().substring(0, url.toString().indexOf("?"));

        StoreVo storeVo = new StoreVo();
        storeVo.setStoreType(storeType);
        JSONObject data = new JSONObject();
        data.put("sysUrl", originalUrl);
        data.put("originalUrl", originalUrl);
        storeVo.setData(data);
        Long fileUuid = storeService.add(storeVo);
        data.put("fileUuid", fileUuid);
        return data;

    }

    private String generateStoreFileName(String fileName, Integer expireDays, StoreTypeEnum storeTypeEnum) {
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        StringBuffer sb = new StringBuffer();
        sb.append(storeTypeEnum.name().toLowerCase());
        sb.append("/");
        sb.append(DateTimeFormatter.ofPattern(DateUtil.YYYYMMDD).format(LocalDate.now()));
        sb.append("/");
        sb.append(expireDays + "d");
        sb.append("/");
        sb.append(Jnanoid.randomId().toLowerCase());
        sb.append(fileExtension);
        return sb.toString();
    }

}

