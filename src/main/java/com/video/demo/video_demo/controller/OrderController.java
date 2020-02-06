package com.video.demo.video_demo.controller;

import com.video.demo.video_demo.domain.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/6 9:42
 */
@RestController
@RequestMapping("/user/api/v1/order")
public class OrderController {

    @GetMapping("add")
    public JsonData saveOrder(){
        return JsonData.buildSuccess("下单成功");
    }
}
