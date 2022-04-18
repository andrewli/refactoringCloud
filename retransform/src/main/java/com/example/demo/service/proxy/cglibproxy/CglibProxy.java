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
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @author liudongwei
 * @Type CglibProxyCat
 * @Desc
 * @date 2022-04-18 17:44
 */
@Slf4j
@Service
public class CglibProxy implements MethodInterceptor {

    /**
     * 获取被代理后的目标类
     * @param clazz 目标类
     * @return
     */
    public <T> T getProxyInstance(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }


    /**
     * 定义一个cglib 回调实例，需要实现MethodInterceptor接口: 此处是this
     * 即代理中方法的访问会转发到该回调中，所有自定义的回调类必须继承MethodInterceptor接口并实现其intercept方法，这一点和jdk的InvocationHandler类似,参数如下;
     * Object obj：被代理的原对象
     * Method method：被调用的当前方法
     * Object[] args：该方法的参数集合
     * MethodProxy proxy：被调用方法的代理，它可以和method完成同样的事情，但是它使用FastClass机制非反射执行方法，效率高 reference:https://www.cnblogs.com/yangming1996/p/6824249.html
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("cglib proxy enhance content start");
        Object object = methodProxy.invokeSuper(o, objects); // 目标类的方法调用，获取结果
        return object;
    }

}
