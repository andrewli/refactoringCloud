/*
 * Project: AIHouse
 *
 * File Created at 2021/2/23
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.common.enums;

/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021年02月23日 17:43
 */
public enum ActivityOptionEnum {


//    活动：渠道组织名称

    TOUTIAO(0,"头条"),
    WEIXIN(1, "微信");


    private Integer code;
    private String desc;

    ActivityOptionEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ActivityOptionEnum getEnum(Integer code) {
        for (ActivityOptionEnum defaultEnum : ActivityOptionEnum.values()) {
            if (defaultEnum.getCode().equals(code)) {
                return defaultEnum;
            }
        }
        return null;
    }

    public static ActivityOptionEnum getEnum(String desc) {
        for (ActivityOptionEnum e : ActivityOptionEnum.values()) {
            if (e.getDesc().equals(desc)) {
                return e;
            }
        }
        return null;
    }



}



