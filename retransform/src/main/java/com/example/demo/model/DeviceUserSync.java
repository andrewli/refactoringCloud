package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liudongwei
 * @Type DeviceUserSync
 * @Desc
 * @date 2022-04-08 15:41
 */
@Data
public class DeviceUserSync implements Serializable {

    private Long id;

    private Long orgUuid;

    private String providerId;

    private Long categoryId;

    private Long userUuid;

    private Long deviceUuid;

    private Long authUuid;

    private Integer version;

    private Integer status;

    private Integer sendStatus;

    private Integer userType;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer doStatus;

    private Long statusChangeTime;


}