/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/15
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

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Pattern;

/**
 * @author liudongwei
 * @Type OssConfig
 * @Desc
 * @date 2022-03-15 18:47
 */
@Slf4j
@Data
@ConfigurationProperties(prefix = "oss")
@Configuration
public class OssConfig {

    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String endPoint;

    @Bean
    public AmazonS3Client createClient() {
        ClientConfiguration opts = new ClientConfiguration();
        opts.setSignerOverride("S3SignerType");
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3Client client = new AmazonS3Client(credentials, opts);
        client.setEndpoint(endPoint);

        if (!Pattern.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}", endPoint)) {
            S3ClientOptions options = new S3ClientOptions();
            options.setPathStyleAccess(true);
            client.setS3ClientOptions(options);
        }

        boolean exists = client.doesBucketExist(bucketName);
        if (!exists) {
            CreateBucketRequest request = new CreateBucketRequest(bucketName);
            request.setCannedAcl(CannedAccessControlList.PublicRead);// ACL:公共读私有写
            client.createBucket(request);
        }
        return client;
    }

}
