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

package com.example.sharding.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    private String endPoint;


    /**
     * 新版 S3 配置：1.11.506
     *
     * @Param []
     * @Return AmazonS3
     */
    @Bean
    public AmazonS3 amazonS3Client() {
        ClientConfiguration config = new ClientConfiguration();
        config.setSignerOverride("S3SignerType");
        AwsClientBuilder.EndpointConfiguration endpointConfig = new AwsClientBuilder.EndpointConfiguration(endPoint, Regions.CN_NORTH_1.getName());
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);

        AmazonS3 client = AmazonS3Client.builder()
                .withEndpointConfiguration(endpointConfig)
                .withClientConfiguration(config)
                .withCredentials(awsCredentialsProvider)
                .disableChunkedEncoding()
                .withPathStyleAccessEnabled(true)
                .build();

        return client;
    }


}
