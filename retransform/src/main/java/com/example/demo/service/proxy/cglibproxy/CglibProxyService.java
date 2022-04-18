/*
 * Project: refactoringCloud
 *
 * File Created at 2022/4/18
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.proxy.cglibproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liudongwei
 * @Type JdkProxyService
 * @Desc
 * @date 2022-04-18 15:47
 */
@Slf4j
@Service
public class CglibProxyService {

      /*
       静态代理和JDK代理都需要某个对象实现一个接口，有时候代理对象只是一个单独对象，此时可以使用Cglib代理;
       Cglib代理可以称为子类代理，是在内存中构建一个子类对象，从而实现对目标对象功能的扩展;
       Cglib通过Enhancer 来生成代理类，通过实现MethodInterceptor接口，并实现其中的intercept方法，在此方法中可以添加增强方法，并可以利用反射Method或者MethodProxy继承类 来调用原方法;
    */


    @Autowired
    private CglibProxy cglibProxy;


    public String getName() {
        RealCat proxyInstance = cglibProxy.getProxyInstance(RealCat.class);
        return proxyInstance.myName();
    }


}
