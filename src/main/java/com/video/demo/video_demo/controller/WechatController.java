package com.video.demo.video_demo.controller;

import com.video.demo.video_demo.config.WeChatConfig;
import com.video.demo.video_demo.domain.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/4 5:34
 */
@Controller
@RequestMapping("/api/v1/wechat")
public class WechatController {

    private WeChatConfig weChatConfig;

    /**
     * 拼装微信扫一扫登录url
     * @param accessPage
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page", required = true) String accessPage) throws UnsupportedEncodingException {

        String redirectUrl = weChatConfig.getOpenRedirectUrl(); //获取开放平台重定向地址

        String callbackUrl = URLEncoder.encode(redirectUrl,"GBK");

        String qrcodeUrl = String.format(weChatConfig.getOpenRedirectUrl(),weChatConfig.getOpenAppid(),callbackUrl,accessPage);

        return JsonData.buildSuccess(qrcodeUrl);
    }
}
