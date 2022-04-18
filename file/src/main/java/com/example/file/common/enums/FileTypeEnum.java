/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/16
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.file.common.enums;

/**
 * @author liudongwei
 * @Type FileTypeEnum
 * @Desc
 * @date 2022-04-16 18:06
 */
public enum FileTypeEnum {

    XLSX(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    CSV(".csv", "application/csv"),
    XLS(".xls", "application/vnd.ms-excel;charset=utf-8"),
    DOCX(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    DOC(".doc", "application/msword");

    private String suffix;
    private String contentType;

    FileTypeEnum(String suffix, String contentType) {
        this.suffix = suffix;
        this.contentType = contentType;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public static FileTypeEnum getEnum(String suffix) {
        for (FileTypeEnum defaultEnum : FileTypeEnum.values()) {
            if (defaultEnum.getSuffix().equals(suffix)) {
                return defaultEnum;
            }
        }
        return null;
    }
}
