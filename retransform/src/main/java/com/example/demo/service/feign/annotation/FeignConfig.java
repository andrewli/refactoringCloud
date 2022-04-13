/*
 * Project: transform
 *
 * File Created at 2021/1/13
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.feign.annotation;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

/**
 * @author liudongwei
 * @Type FeignConfig
 * @Desc
 * @date
 */
@Slf4j
public class FeignConfig {

    /*
   <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>
    <dependency>
        <groupId>io.github.openfeign</groupId>
        <artifactId>feign-httpclient</artifactId>
    </dependency>
    feign ：spring-cloud-starter-openfeign 默认通过jdk中的HttpURLConnection 发起请求,参见 feign.Client.Default#execute，缺少池化处理
            通过引入feign-httpclient 增加池化处理，参加org.springframework.cloud.openfeign.FeignAutoConfiguration.HttpClientFeignConfiguration.feignClient 池化配置
            使用feign-httpclient 默认池化配置maxRoute、maxConnection即可，不需要再配置文件中添加feign.httpclient.enabled=true，不加也是true
            feign-httpclient 版本需要与spring-cloud-starter-openfeign 版本保持一致，无论是否有池化处理，feign都是可以访问 http/https 的请求
     FeignConfig 的配置若加上@Configuration 则表示全局配置，建议不加，在@FeignClient 的 configuration 加上，表示该类包含的接口使用该feign配置
     reference : https://www.cnblogs.com/notayeser/p/12410919.html
    */

    @Bean
    public RequestInterceptor getRequestInterceptor() {
        return new ClientInterceptor();
    }

    class ClientInterceptor implements RequestInterceptor {

        @Override
        public void apply(RequestTemplate template) {
            Request request = template.request();
            log.info("The request : {} , param ：{} ", request.toString(),template.queries());

            /*
            // header：获取header参数 ，设置自定义参数
            Map<String, Collection<String>> headers = template.headers();
            template.header("ACCESS_TOKEN","123");

            // get：获取到get请求体参数 ，设置自定义参数
            if (template.method().equals(Request.HttpMethod.GET.name())) {
                Map<String, Collection<String>> queries = template.queries();
                String sign = "自定义签名";
                template.query("sign", sign);
            }

            // post：获取post请求体参数 ,设置自定义参数
            if (template.method().equals(Request.HttpMethod.POST.name())) {
                String bodyStr = new String(template.body(),StandardCharsets.UTF_8);
                JSONObject postBody = JSONObject.parseObject(bodyStr, JSONObject.class);
                postBody.put("sign", "123");
                template.body(postBody.toJSONString());
            }
           */
        }
    }
}

