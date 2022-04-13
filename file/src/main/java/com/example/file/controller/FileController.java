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

package com.example.file.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.file.common.Result;
import com.example.file.common.ResultCode;
import com.example.file.config.OssConfig;
import com.example.file.util.FileUtil;
import com.example.file.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author liudongwei
 * @Type TestController
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@RestController
public class FileController {

    public static final String YYYYMMDD = "yyyyMMdd";

    
//    @Autowired
//    private AmazonS3Client client;

    @Autowired
    private AmazonS3 client;

    @Autowired
    private OssConfig ossConfig;

    @PostMapping("upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        try {
            
            String uploadUrl = acquireUploadFileUrl(file);
            return Result.create(uploadUrl);
        } catch (Exception e) {
            log.error("upload file error:{}", e);
            return Result.error(ResultCode.PARAMETER_ILLEGAL, "上传文件失败");
        }
    }

    public String acquireUploadFileUrl(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        String storeDirectory = DateTimeFormatter.ofPattern(YYYYMMDD).format(LocalDate.now());
        String fileStoreName = storeDirectory.concat("/").concat(UUID.generateUUID().toLowerCase()).concat(fileExtension);

        String bucketName = ossConfig.getBucketName();
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
        return url.toString().substring(0, url.toString().indexOf("?"));
    }


    @GetMapping("/download")
    public void downLoadFileFromUrl(HttpServletResponse response,
                                    HttpServletRequest request,
                                    @RequestParam("fileName") String fileName,
                                    @RequestParam("fileUrl") String fileUrl) {
        downLoad(request, response, fileName, fileUrl);
    }


    public void downLoad(HttpServletRequest request, HttpServletResponse response, String fileName, String fileUrl) {
        log.info("file downLoad fileName:{},fileUrl:{}", fileName, fileUrl);
        response.setCharacterEncoding("utf8");
        FileUtil.setChinaFileName(request, response, fileName);
        InputStream inputStream = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(fileUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setRequestMethod("GET");
            conn.connect();
            inputStream = conn.getInputStream();
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            log.error("file download err", e);
        } finally {
            IOUtils.closeQuietly(inputStream);
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

}

