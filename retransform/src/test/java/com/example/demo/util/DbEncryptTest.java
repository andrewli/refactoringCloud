/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/24
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.util;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liudongwei
 * @Type DbEncryptTest
 * @Desc 生成配置文件加密的结果
 * @date 2022-03-24 14:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbEncryptTest {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:mysql://127.0.0.1:3306/smartzone?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("root");
        System.out.println("database url: " + url);
        System.out.println("database name: " + name);
        System.out.println("database password: " + password);

        /*
        database url: XvZBUryYzbSAovrITTrOQn8knoFG55l0Qmiet8uckmKvAsLIKj3gNZTnoR8D1WPLFf/K5gLDMv7VpEaxUsuUx4Infry0yCmGTmxLDpNuYE1fA6OsTFJnitbje2BH/oFp79lUUAlduyvbS0khLrnF6FrwvF3moKyZvGIU1EBhHTh2/DxBIKAN9Q==
        database name: bI49ou62TB7lAmqVj+6HLg==
        database password: +zQcABDNbHs2W7QAEp3T1Q==
        */
    }

}
