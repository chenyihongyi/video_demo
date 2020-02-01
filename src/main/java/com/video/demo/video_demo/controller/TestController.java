package com.video.demo.video_demo.controller;

import com.video.demo.video_demo.config.WeChatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/2 3:55
 */
@RestController
public class TestController {

    @RequestMapping("test")
    public String test(){
        System.out.println("xdclass.com");
        return "hello elvis, welcome to videotest.com";
    }

    @Autowired
    private WeChatConfig weChatConfig;

    @RequestMapping("test_config")
    public String testConfig(){
        System.out.println(weChatConfig.getAppId());
        return "hello, weChatConfig";
    }

}
