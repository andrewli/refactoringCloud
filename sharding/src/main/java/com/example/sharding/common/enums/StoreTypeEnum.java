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

package com.example.sharding.common.enums;

import com.example.sharding.common.vo.Desc;
import com.example.sharding.model.AccessRecord;
import com.example.sharding.model.Face;
import com.example.sharding.model.Log;
import com.example.sharding.model.Sys;
import com.example.sharding.model.VehicleRecord;

/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021年02月23日 17:43
 */
public enum StoreTypeEnum {


    FACE(0, new Desc("人脸照片", Face.class)),
    ACCESS_RECORD(1, new Desc("门禁通行记录", AccessRecord.class)),
    VEHICLE_RECORD(2, new Desc("车辆通行记录", VehicleRecord.class)),
    LOG(3, new Desc("日志", Log.class)),
    SYS(4, new Desc("系统资源", Sys.class)),
    ;


    private Integer code;
    private Desc desc;

    StoreTypeEnum(Integer code, Desc desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Desc getDesc() {
        return desc;
    }

    public void setDesc(Desc desc) {
        this.desc = desc;
    }

    public static StoreTypeEnum get(Integer code) {
        for (StoreTypeEnum defaultEnum : StoreTypeEnum.values()) {
            if (defaultEnum.getCode().equals(code)) {
                return defaultEnum;
            }
        }
        return null;
    }

}



