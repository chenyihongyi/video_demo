package com.video.demo.video_demo.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.video.demo.video_demo.dto.VideoOrderDto;
import com.video.demo.video_demo.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

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
    public void saveOrder(@RequestParam(value="video_id", required = true)int videoId,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception{
       // String ip = IpUtils.getIpAddr(request);
       // int userId = request.getAttribute("user_id");
        int userId = 1; //临时写死
        String ip = "120.25.1.38";
        VideoOrderDto videoOrderDto = new VideoOrderDto();
        videoOrderDto.setUserId(userId);
        videoOrderDto.setVideoId(videoId);
        videoOrderDto.setIp(ip);
        String codeUrl = videoOrderService.save(videoOrderDto);

        if (codeUrl == null) {
            throw new NullPointerException();
        }
        try {
            //生成二维码
            Map<EncodeHintType, Object> hints = new HashMap<>();

            //设置纠错等级
            hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
            //编码类型
            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");

            BitMatrix bitMatrix = new MultiFormatWriter().encode(codeUrl,BarcodeFormat.QR_CODE,400,400,hints);
            OutputStream out = response.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix,"png",out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
