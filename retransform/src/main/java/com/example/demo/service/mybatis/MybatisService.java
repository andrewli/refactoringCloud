/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/8
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.mybatis;

import com.example.demo.dao.DeviceUserSyncMapper;
import com.example.demo.model.DeviceUserSync;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author liudongwei
 * @Type MybatisService
 * @Desc
 * @date 2022-04-08 15:32
 */
@Service
@Slf4j
public class MybatisService {

/*
    try括号内的资源会在try语句结束后自动释放,Cursor 自动关闭
    使用try后面跟随 () 括号，用来管理释放资源,所有实现Closeable的类声明都可以写在try的括号中，最常见的是流操作、socket操作等,括号中可以写多行语句
    开启一个 SqlSession （实际上也代表了一个数据库连接），并保证它最后能关闭
    使用 SqlSession 来获得 Mapper 对象,保证得到的 Cursor 对象是打开状态的
*/

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void scan(int limit) {
        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Cursor<DeviceUserSync> cursor = sqlSession.getMapper(DeviceUserSyncMapper.class).scan(limit)
        ) {
            cursor.forEach(e -> {
                log.info("load ");

            });
        } catch (IOException e) {
            log.info("cursor query error:{}", e);
        }


    }
}
