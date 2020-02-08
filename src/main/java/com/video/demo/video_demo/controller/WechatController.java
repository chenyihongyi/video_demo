package com.video.demo.video_demo.controller;

import com.video.demo.video_demo.config.WeChatConfig;
import com.video.demo.video_demo.domain.JsonData;
import com.video.demo.video_demo.domain.User;
import com.video.demo.video_demo.service.UserService;
import com.video.demo.video_demo.utils.JwtUtils;
import com.video.demo.video_demo.utils.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/4 5:34
 */
@Controller
@RequestMapping("/api/v1/wechat")
public class WechatController {

    @Autowired
    private WeChatConfig weChatConfig;

    private UserService userService;

    /**
     * 拼装微信扫一扫登录url
     * @param accessPage
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page",required = true)String accessPage) throws IOException {

        String redirectUrl = weChatConfig.getOpenRedirectUrl(); //获取开放平台重定向地址

        String callbackUrl = URLEncoder.encode(redirectUrl,"GBK"); //进行编码

        String qrcodeUrl = String.format(weChatConfig.getOpenQrcodeUrl(),weChatConfig.getOpenAppid(),callbackUrl,accessPage);

        return JsonData.buildSuccess(qrcodeUrl);
    }

    /**
     * 微信扫码登录，回调地址
     * @param code
     * @param state
     * @param response
     * @throws IOException
     */
    @GetMapping("/user/callback")
    public void wechatUserCallback(@RequestParam(value = "code", required = true) String code,String state,HttpServletResponse response) throws IOException {
//        System.out.println("code="+code);
//        System.out.println("state="+state);
        User user = userService.saveWeChatUser(code);
        if (user != null) {
            //生成jwt
            String token = JwtUtils.geneJsonWebToken(user);

            // state 当前用户的页面地址，需要拼接 http://  这样才不会站内跳转
            response.sendRedirect(state+"?token="+token+"&head_img="+user.getHeadImg()+"&name="+URLEncoder.encode(user.getName(),"UTF-8"));
        }
    }

    /**
     * 微信支付回调
     * @param request
     * @param response
     * @throws Exception
     */
    //GetMapping用这个注解会报错
    @RequestMapping("/order/callback")  //回调要用post方式,微信文档没有写回调的通知方式，可以用这个注解@RequestMapping
    public void orderCallback(HttpServletRequest request, HttpServletResponse response) throws Exception{
        InputStream inputStream = request.getInputStream();

        //BufferedReader是包装设计模式，性能更高
        BufferedReader in =  new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        StringBuffer sb = new StringBuffer();
        String line;
        while((line = in.readLine()) !=null){
            sb.append(line);
        }
        in.close();
        inputStream.close();
        Map<String, String> callbackMap = WXPayUtil.xmlToMap(sb.toString());
        System.out.println(callbackMap.toString());
    }
}
