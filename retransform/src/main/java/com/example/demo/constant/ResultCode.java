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


public enum ResultCode {

    SUCCESS(200, "操作成功"),
    DOING(201, "操作中"),
    ACCOUNT_LOGIN_ERROR(300, "登录失败"),
    ACCOUNT_AUTH_FAILURE(301, "账户鉴权失败"), //只有301错误码，客户端才会退出到登录页面
    ACCOUNT_IP_DENY(302, "ip白名单鉴权失败"),
    ACCOUNT_NO_OPERATION_AUTH(303, "缺少操作权限"),
    VERIFYCODE_FAILURE(304, "验证码错误"),
    ACCOUNT_FROZEN(305,"账户已冻结"),
    ACCOUNT_INVALID(306,"账户已失效"),
    PARAMETER_ILLEGAL(1000, "输入参数不合法"),
    MOULD_ILLEGAL(1001, "输入模板不正确"),
    SYSTEM_ERROR(1003, "系统异常"),
    DATA_NOT_EXIST(1004, "数据不存在"),
    OPEN_ERROR(601, "开门失败"),
    OPEN_TOO_OFTEN(602, "开门次数过多"),
    OPEN_NO_AUTH(603, "门禁不存在或无权限"),
    OPEN_NOT_ONLINE(604, "设备不在线"),
    OPEN_IN_OPERATION(605, "正在开锁，请稍等"),
    FREQUENT_OPERTION(606, "操作频繁"),
    CAM_NO_USERNAME(701, "没有绑定视频账号"),
    CAM_ERROR_USERNAME(702, "视频账号密码错误"),
    FILE_EXIST(801, "文件已经保存"),
    FILE_SIZE(802, "文件过大"),
    LACK_OF_SPACE(803, "空间不足"),
    //PROCESS_FAILURE(1003,"操作失败"),
    DB_ERROR(1006, "数据库异常"),
    NOTIFY_ERROR(1007, "消息发送失败"),
    THIRD_VALI_FAILURE(1008, "其他平台token到本平台校验错误"),
    HEALTH_QUERY_DATA_ERROR(1009, "没有数据或数据异常"),
    DELETED_USER(304, "token不存在，用户可能已被删除"),
    AREA_ERROR(1010, "用户区域信息异常"),
    ERROR_REMOTE_PROVIDER(1011, "厂商接口错误"),
    DETECT_PHOTO_FAILED(1012, "图片检测失败"),
    NOT_SUPPORTED(1013, "不支持"),
    UPLOAD_ERROR(1014, "上传失败"),
    DOWNLOAD_ERROR(1015, "下载失败"),
    NFC_NOT_SUPPORT(2, "对不起,您的SIM卡不支持"),
    NFC_SUCCESS(3, "开通成功"),
    NFC_UPDATED(4, "更换成功"),
    NFC_FAILURE(6, "操作失败"),
    VEDIO_TOKEN_INVALID(1101, "播放人数过多请等候"),
    VEDIO_TOKEN_OVERDUE(1102, "视频播放token已过期"),
    VEDIO_TOKEN_DUPLIATE(1104, "重复提交"),
    PULL_DEVICE_LOG_FAIL(1105, "获取设备日志失败"),
    UPDATE_ERROY(1106, "更新失败"),
    APPID_COMMUNITYUUID_FAILURE(1107, "AppID和CommunityUuid校验失败"),
    POSITIVE(1200,"检测阳性"),
    NEGATIVE_EXPIRED(1201,"阴性已过期"),
    FAIL(1202,"接口调用失败"),
    UNPAID(1203,"存在待缴费账单"),
    RCSCAM_HEJIAQIN_RECH(1301,"调用和家亲设备接口异常"),
    UNREGIST_ERROR(1401,"用户注销失败");
    private Integer code;
    private String msg;

    private ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultCode getEnum(Integer code) {
        for (ResultCode retEnum : ResultCode.values()) {
            if (retEnum.getCode().equals(code)) {
                return retEnum;
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
