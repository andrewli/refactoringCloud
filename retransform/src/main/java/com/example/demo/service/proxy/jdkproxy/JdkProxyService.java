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

package com.example.demo.service.proxy.jdkproxy;

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
public class JdkProxyService {

      /*
        动态代理具有如下特点：
        JDK动态代理对象不需要实现接口，只有目标对象需要实现接口;
        实现基于接口的动态代理需要利用JDK中的API，在JVM内存中动态的构建Proxy对象;
        需要使用到 java.lang.reflect.Proxy，和其newProxyInstance方法，但是该方法需要接收三个参数;

        InvocationHandler 参数含义：接收的三个参数依次为：
        ClassLoader loader：指定当前目标对象使用类加载器，获取加载器的方法是固定的;
        Class<?>[] interfaces：目标对象实现的接口的类型，使用泛型方式确认类型;
        InvocationHandler h：事件处理，执行目标对象的方法时，会触发事件处理器的方法，会把当前执行目标对象的方法作为参数传入;

        代理对象不需要实现接口，但是目标对象一定要实现接口，否则不能用动态代理;
        动态代理的方式中，所有的函数调用最终都会经过 invoke 函数的转发，因此可以在这里做一些需要增强的操作，比如日志系统、事务、拦截器、权限控制等;
        JDK 动态代理缺点：
        只能代理实现了某个接口的实现类，并且代理类也只能代理接口中实现的方法，要是实现类中有自己私有的方法，而接口中没有的话，该方法不能进行代理调用;
        如果需要使用的就需要使用cglib 代理
    */


    @Autowired
    private JdkProxyDog jdkProxyDog;

    public String getDogEatFood() {
        IDog jdkProxyDogProxy = jdkProxyDog.getProxy();
        return jdkProxyDogProxy.eat();
    }

    public void dogBark() {
        IDog jdkProxyDogProxy = jdkProxyDog.getProxy();
        jdkProxyDogProxy.bark();
    }


}
