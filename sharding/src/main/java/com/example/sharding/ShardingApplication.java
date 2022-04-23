package com.example.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan({"com.baidu.fsg.uid","com.example.sharding.dao"})
@SpringBootApplication
public class ShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }

}
