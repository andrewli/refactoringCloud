
package com.example.demo.controller;


import com.example.demo.common.constant.Result;
import com.example.demo.service.proxy.cglibproxy.CglibProxyService;
import com.example.demo.service.proxy.jdkproxy.JdkProxyService;
import com.example.demo.service.proxy.staticproxy.StaticProxyService;
import com.example.demo.vo.Food;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liudongwei
 * @Type
 * @Desc 代理方式：静态代理 动态代理  cglib 代理  Reference：https://www.cnblogs.com/jiangwang001/p/15097298.html
 * @date 2021-09-26 17:42
 */
@Slf4j
@RestController
public class ProxyController extends BaseController {


    @Autowired
    private StaticProxyService staticProxyService;

    @Autowired
    private JdkProxyService jdkProxyService;

    @Autowired
    private CglibProxyService cglibProxyService;

    /**
    * 静态代理
    * @Param []
    * @Return Result
    */
    @GetMapping("/proxy/static/getFood")
    public Result staticGetFood() {
        List<Food> food = staticProxyService.getFood();
        return Result.create(food);
    }

    /**
    * jdk 动态代理
    * @Param []
    * @Return Result
    */
    @GetMapping("/proxy/jdk/getFood")
    public Result jdkGetFood() {
       jdkProxyService.dogBark();
        String dogEatFood = jdkProxyService.getDogEatFood();
        return Result.create(dogEatFood);
    }

    /**
    * cglib 代理
    * @Param []
    * @Return Result
    */
    @GetMapping("/proxy/cglib/getFood")
    public Result cglibGetFood() {
        String name = cglibProxyService.getName();
        return Result.create(name);
    }



}
