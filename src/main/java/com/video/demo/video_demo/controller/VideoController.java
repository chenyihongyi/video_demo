package com.video.demo.video_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/2 2:00
 */
@RestController
public class VideoController {

    @RequestMapping("test")
    public String test(){
        System.out.println("xdclass.com");
        return "hello elvis, welcome to videotest.com";
    }

}
