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

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.DeviceUserSyncMapper;
import com.example.demo.model.DeviceUserSync;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;

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
    try括号内的资源会在try语句结束后自动释放,Cursor 自动关闭：
    使用try后面跟随 () 括号，用来管理释放资源,所有实现Closeable的类声明都可以写在try的括号中（建议只把相关流声明放在小括号内），最常见的是流操作、socket操作等,括号中可以写多行语句
    无论try内是否抛出异常，try{} 大括号内执行结束后都会调用close方式关闭流：try{} 内容 -> close()方法 -> catch exception 处理 -> finally 处理
    开启一个 SqlSession （实际上也代表了一个数据库连接），并保证它最后能关闭
    使用 SqlSession 来获得 Mapper 对象,保证得到的 Cursor 对象是打开状态的

    NIO：可以使用非直接缓冲区(allocate) 和直接缓冲区(allocateDirect) 详见：https://www.cnblogs.com/shamo89/p/9612794.html
*/

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public static final String NEW_LINE = System.getProperty("line.separator");

    public static final String filePath = "D:\\apprun\\file\\test0409.txt";

    public void scan(int limit) {

        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Cursor<DeviceUserSync> cursor = sqlSession.getMapper(DeviceUserSyncMapper.class).scan(limit);
                FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
                FileChannel channel = fileOutputStream.getChannel();
        ) {
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            ByteBuffer byteBuffer =ByteBuffer.allocateDirect(1024);
            Iterator<DeviceUserSync> iterator = cursor.iterator();
            while (iterator.hasNext()) {
                DeviceUserSync e = iterator.next();
                log.info("load index:{}", cursor.getCurrentIndex());
                String lineText = JSONObject.toJSONString(e) + NEW_LINE;
                byteBuffer.put(lineText.getBytes());
                byteBuffer.flip();
                channel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            log.info("cursor query error:{}", e);
        }


      /*  try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Cursor<DeviceUserSync> cursor = sqlSession.getMapper(DeviceUserSyncMapper.class).scan(limit);
                FileOutputStream out = new FileOutputStream(filePath, true);
        ) {
            File file = new File(filePath);
                if (!file.getParentFile().exists()) {
                   file.getParentFile().mkdirs();
            }
            Iterator<DeviceUserSync> iterator = cursor.iterator();
            while (iterator.hasNext()) {
                DeviceUserSync e = iterator.next();
                log.info("load index:{}", cursor.getCurrentIndex());
                String lineText = JSONObject.toJSONString(e) + NEW_LINE;
                out.write(lineText.getBytes());
            }
        } catch (IOException e) {
            log.info("cursor query error:{}", e);
        }
*/
    }
}

