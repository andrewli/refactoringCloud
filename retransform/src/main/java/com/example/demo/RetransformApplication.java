package com.example.demo;

import com.example.demo.service.channel.OrderSink;
import com.example.demo.service.channel.OrderSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({OrderSink.class, OrderSource.class})
@MapperScan("com.baidu.fsg.uid")
@SpringBootApplication
public class RetransformApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetransformApplication.class, args);
    }

}
