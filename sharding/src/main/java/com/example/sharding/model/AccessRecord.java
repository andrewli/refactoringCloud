package com.example.sharding.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class AccessRecord implements Serializable {

    private static final long serialVersionUID = -1205226416664488559L;

    private Long id;

    private Long uuid;

    private String sysUrl;

    private String originalUrl;

    private Integer isDelete;

    private Date create_time;


}
