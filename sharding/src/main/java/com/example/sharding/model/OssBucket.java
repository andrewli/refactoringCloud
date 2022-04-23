package com.example.sharding.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class OssBucket implements Serializable {

    private static final long serialVersionUID = -1205226416664488559L;

    private Long id;

    private String accountName;

    private String bucketName;

    private Integer storeType;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

}
