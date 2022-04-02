/*
 *
 * File Created at 2018/9/6
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.example.demo.constant;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;

import java.io.Serializable;

@Data
public class Result<V> implements Serializable {

    private static final long serialVersionUID = -6013178372858137407L;
    private String traceId;
    private Integer recode;
    private String msg;
    private V data;


    public Result() {
        this.setMsg(ResultCode.SUCCESS.getMsg());
        this.setRecode(ResultCode.SUCCESS.getCode());
    }

    public Result(Integer recode, String msg) {
        super();
        this.msg = msg;
        this.recode = recode;
    }

    public Result(V data) {
        super();
        this.data = data;
    }
    
    /**
     * @return
     * */
    public static Result create(Object value) {
        Result result = new Result();
        result.setData(JSONObject.toJSON(value));
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setRecode(ResultCode.SUCCESS.getCode());
        result.setTraceId(TraceContext.traceId());
        return result;
    }

    /**
     * @return
     * */
    public static Result create() {
        return create(null);
    }

    /**
     * @return
     * */
    public static Result error(ResultCode resultCode, String message) {
        Result result = new Result();
        if (null == message || 0 == message.length()) {
            result.setMsg(resultCode.getMsg());
        } else {
            result.setMsg(message);
        }
        result.setRecode(resultCode.getCode());
        result.setTraceId(TraceContext.traceId());
        return result;
    }
    /**
     * @return
     * */
    public static Result fail(Object value) {
        Result result = new Result();
        result.setData(JSONObject.toJSON(value));
        result.setMsg(ResultCode.PARAMETER_ILLEGAL.getMsg());
        result.setRecode(ResultCode.PARAMETER_ILLEGAL.getCode());
        result.setTraceId(TraceContext.traceId());
        return result;
    }

    public boolean isSucc(){
        return ResultCode.SUCCESS.getCode().equals(this.recode);
    }

    public Integer getRecode() {
        return recode;
    }

    public void setRecode(Integer recode) {
        this.recode = recode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("Recode = %s, Msg = %s", String.valueOf(this.recode), this.msg);
    }

}
