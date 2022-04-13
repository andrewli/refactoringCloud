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

package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.constant.Result;
import com.example.demo.common.constant.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author liudongwei
 * @Type BaseController
 * @Desc
 * @date 2021-12-15 19:46
 */
@Slf4j
@RestControllerAdvice
public class BaseController {


    @Autowired
    protected HttpServletResponse response;

    /**
    *  @Valid 指定捕获表单数据提交异常，使用herbinate validator 工具
    */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public void validationBodyException(MethodArgumentNotValidException e) {
        Map<String, String> bindExceptionResult = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                String feildName = fieldError.getField();
                String exceptionMessage = fieldError.getDefaultMessage();
                bindExceptionResult.put(feildName, exceptionMessage);
            });
            Result result = Result.error(ResultCode.SYSTEM_ERROR, bindExceptionResult.toString());
            printToPage(response, result);
        }
    }


    /**
     *  获取 controller 层的 IllegalArgumentException 异常
     */
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseBody
    public void IllegalArgumentExceptionException(IllegalArgumentException e) {
        String eMessage = e.getMessage();
        Result result = Result.error(ResultCode.SYSTEM_ERROR, eMessage);
        printToPage(response, result);
    }


    /**
     * exception 捕获所有异常
     */
    @ExceptionHandler
    @ResponseBody
    public void exception(HttpServletResponse response, Exception exception) {

        response.setContentType("application/json;charset=utf-8");
        try {
            log.error("BaseController 执行失败 {}", exception);
            Result result = Result.error(ResultCode.SYSTEM_ERROR, exception.getMessage());
            response.reset();
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(result));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            log.error("记录失败异常", exception);
        }
    }

    /**
     * 将错误结果返回给页面
     *
     * @Param [servletResponse, result]
     * @Return void
     */
    protected void printToPage(ServletResponse servletResponse, Result result) {
        try {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(result));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            log.error("记录失败异常", result);
        }
    }

}
