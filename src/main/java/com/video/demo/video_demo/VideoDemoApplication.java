package com.video.demo.video_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.video.demo.video_demo.mapper")
//开启事务管理
@EnableTransactionManagement
public class VideoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoDemoApplication.class,args);
    }

}
