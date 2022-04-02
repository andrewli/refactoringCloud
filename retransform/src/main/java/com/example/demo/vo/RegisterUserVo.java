/*
 * Project: sky5
 *
 * File Created at 2021/12/15
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author liudongwei
 * @Type RegisterUserVo
 * @Desc
 * @date 2021-12-15 19:37
 */
@Data
public class RegisterUserVo {

    // 通过异常处理机制，

    @NotEmpty(message = "用户名不能为空")
    @Length(min = 6, max = 18, message = "用户名必须是6-18位")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码必须是6-18位")
    private String passWord;

    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp = "^[1]([3-9][0-9]{9})$",message = "手机号码不正确")
    private String phone;


}
