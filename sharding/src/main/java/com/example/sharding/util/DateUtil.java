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

package com.example.sharding.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liudongwei
 * @Type DateUtil
 * @Desc
 * @date 2022-04-23 20:59
 */
@Slf4j
public class DateUtil {


    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final ThreadLocal<Map<String, DateFormat>> dateFormatThreadLocal = new ThreadLocal();

    public DateUtil() {
    }

    private static DateFormat getDateFormat(String pattern) {
        if (pattern != null && pattern.trim().length() != 0) {
            Map<String, DateFormat> dateFormatMap = (Map) dateFormatThreadLocal.get();
            if (dateFormatMap != null && ((Map) dateFormatMap).containsKey(pattern)) {
                return (DateFormat) ((Map) dateFormatMap).get(pattern);
            } else {
                synchronized (dateFormatThreadLocal) {
                    if (dateFormatMap == null) {
                        dateFormatMap = new HashMap();
                    }

                    ((Map) dateFormatMap).put(pattern, new SimpleDateFormat(pattern));
                    dateFormatThreadLocal.set(dateFormatMap);
                }

                return (DateFormat) ((Map) dateFormatMap).get(pattern);
            }
        } else {
            throw new IllegalArgumentException("pattern cannot be empty.");
        }
    }

    public static String formatDate(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static String formatDateTime(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date date, String patten) {
        return getDateFormat(patten).format(date);
    }

    public static Date parseDate(String dateString) {
        return parse(dateString, "yyyy-MM-dd");
    }

    public static Date parseDateTime(String dateString) {
        return parse(dateString, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parse(String dateString, String pattern) {
        try {
            Date date = getDateFormat(pattern).parse(dateString);
            return date;
        } catch (Exception var3) {
            log.warn("parse date error, dateString = {}, pattern={}; errorMsg = {}", new Object[]{dateString, pattern, var3.getMessage()});
            return null;
        }
    }

    public static Date addYears(Date date, int amount) {
        return add(date, 1, amount);
    }

    public static Date addMonths(Date date, int amount) {
        return add(date, 2, amount);
    }

    public static Date addDays(Date date, int amount) {
        return add(date, 5, amount);
    }

    public static Date addHours(Date date, int amount) {
        return add(date, 11, amount);
    }

    public static Date addMinutes(Date date, int amount) {
        return add(date, 12, amount);
    }

    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            return null;
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }


}
