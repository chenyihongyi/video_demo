package com.video.demo.video_demo.controller;

import com.video.demo.video_demo.config.WeChatConfig;
import com.video.demo.video_demo.domain.JsonData;
import com.video.demo.video_demo.mapper.VideoMapper;
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
    public JsonData testConfig(){
        System.out.println(weChatConfig.getAppId());
        return JsonData.buildSuccess(weChatConfig.getAppId());
    }

    @Autowired
    private VideoMapper videoMapper;

    @RequestMapping("test_db")
    public Object testDB(){
        return videoMapper.findAll();
    }
}
