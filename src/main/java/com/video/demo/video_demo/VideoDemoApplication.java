package com.video.demo.video_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.video.demo.video_demo.mapper")
public class VideoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoDemoApplication.class,args);
    }

}
