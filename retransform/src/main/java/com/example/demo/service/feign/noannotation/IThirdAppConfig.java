/*
 * Project: littlec-base
 *
 * File Created at 2020/5/11
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.feign.noannotation;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * @author liudongwei
 * @Type AiHouseConfig
 * @Desc
 * @date 2020年05月11日 22:00
 */
@Slf4j
@Service
public class IThirdAppConfig {

    /**
     <dependency>
         <groupId>io.github.openfeign</groupId>
         <artifactId>feign-core</artifactId>
         <version>10.12</version>
     </dependency>
     <dependency>
         <groupId>io.github.openfeign</groupId>
         <artifactId>feign-jackson</artifactId>
         <version>10.12</version>
     </dependency>
     feign原生方式：原生方式如果采用jackson进行decode和encode，引入jackson jar包，两者版本保持一致
     原生方式只支持http请求，如果需要支持访问https，需要额外进行https 配置
     原生方式无论是否引入feign-httpclient jar包，都是默认采用jdk中的HttpURLConnection 发起请求,参见 feign.Client.Default#execute，缺少池化处理
     若要使用springMvc注解，则配置contract为springMvc的contract

     (1) 不采用池化处理：
      默认通过jdk中的HttpURLConnection 发起请求,参见 feign.Client.Default#execute，若访问https 请求，配置.client(new Client.Default(sslSocketFactory(), hostnameVerifier()))
     (2) 采用池化处理：引入如下jar 包
     <dependency>
         <groupId>io.github.openfeign</groupId>
         <artifactId>feign-httpclient</artifactId>
     </dependency>
     配置 .client(new ApacheHttpClient(HttpClientBuilder.create().build()))，里面对SSL做了自动化配置
     发起请求 feign.httpclient.ApacheHttpClient.execute
     */

    /**
     * 在decode中复写decode，获取返回值值为token失效码，可以加上重新获取token的逻辑
     *
     * @Param []
     * @Return IThirdApp
     */
    @Bean
    public IThirdApp ThirdAppHttpStub() {
        IThirdApp httpStub = Feign.builder()
             // .client(new Client.Default(sslSocketFactory(), hostnameVerifier()))
                .client(new ApacheHttpClient(HttpClientBuilder.create().build()))
                .retryer(Retryer.NEVER_RETRY)
                .options(new Request.Options(10L, TimeUnit.SECONDS, 60L, TimeUnit.SECONDS, true))
             //  .contract(new SpringMvcContract())
                .requestInterceptor(new FeignInterceptor())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(new ThirdAppTarget<>(IThirdApp.class, new ServerProvider("https://free-api.heweather.net", "weather api")));

        return httpStub;
    }

    private SSLSocketFactory sslSocketFactory() {
        SSLContext sslcontext;
        try {
            sslcontext = SSLContext.getInstance("SSL", "SunJSSE");
            sslcontext.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

            }}, new java.security.SecureRandom());
        } catch (Exception e1) {
            throw new RuntimeException("Unable to creat ssl config.", e1);
        }
        return sslcontext.getSocketFactory();
    }

    private HostnameVerifier hostnameVerifier() {
        NoopHostnameVerifier noopHostnameVerifier = new NoopHostnameVerifier();
        return noopHostnameVerifier;
    }

}

