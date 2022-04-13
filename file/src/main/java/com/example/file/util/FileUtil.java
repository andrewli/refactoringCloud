/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/13
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.file.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @author liudongwei
 * @Type FileUtil
 * @Desc
 * @date 2022-04-13 13:22
 */
@Slf4j
public class FileUtil {

    public static void setChinaFileName(HttpServletRequest request, HttpServletResponse response, String fileName) {
        String browser = "";
        try {
            browser = request.getHeader("User-Agent");
            if (-1 < browser.indexOf("MSIE 6.0") || -1 < browser.indexOf("MSIE 7.0")) {
                // IE6, IE7 浏览器
                response.addHeader("content-disposition", "attachment;filename="
                        + new String(fileName.getBytes(), "ISO8859-1"));
            } else if (-1 < browser.indexOf("MSIE 8.0")) {
                // IE8
                response.addHeader("content-disposition",
                        "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("MSIE 9.0")) {
                // IE9
                response.addHeader("content-disposition",
                        "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("Chrome")) {
                // 谷歌
                response.addHeader("content-disposition", "attachment;filename*=UTF-8''"
                        + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("Safari")) {
                // 苹果
                response.addHeader("content-disposition", "attachment;filename="
                        + new String(fileName.getBytes(), "ISO8859-1"));
            } else {
                // 火狐或者其他的浏览器
                response.addHeader("content-disposition", "attachment;filename*=UTF-8''"
                        + URLEncoder.encode(fileName, "UTF-8"));
            }
        } catch (Exception e) {
            log.error("set china file name error:{}", e);
        }
    }

}
