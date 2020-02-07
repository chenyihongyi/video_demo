package com.video.demo.video_demo.controller;

import com.video.demo.video_demo.domain.JsonData;
import com.video.demo.video_demo.dto.VideoOrderDto;
import com.video.demo.video_demo.service.VideoOrderService;
import com.video.demo.video_demo.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/6 9:42
 */
@RestController
//@RequestMapping("/user/api/v1/order")
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    @GetMapping("add")
    public JsonData saveOrder(@RequestParam(value="video_id", required = true)int videoId,
                              HttpServletRequest request) throws Exception{
        String ip = IpUtils.getIpAddr(request);
       // int userId = request.getAttribute("user_id");
        int userId = 1;
        VideoOrderDto videoOrderDto = new VideoOrderDto();
        videoOrderDto.setUserId(userId);
        videoOrderDto.setVideoId(videoId);
        videoOrderDto.setIp(ip);
        videoOrderService.save(videoOrderDto);

        return JsonData.buildSuccess("下单成功");
    }
}
