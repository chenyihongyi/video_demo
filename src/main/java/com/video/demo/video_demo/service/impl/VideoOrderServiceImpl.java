package com.video.demo.video_demo.service.impl;

import com.video.demo.video_demo.config.WeChatConfig;
import com.video.demo.video_demo.domain.User;
import com.video.demo.video_demo.domain.Video;
import com.video.demo.video_demo.domain.VideoOrder;
import com.video.demo.video_demo.dto.VideoOrderDto;
import com.video.demo.video_demo.mapper.UserMapper;
import com.video.demo.video_demo.mapper.VideoMapper;
import com.video.demo.video_demo.mapper.VideoOrderMapper;
import com.video.demo.video_demo.service.VideoOrderService;
import com.video.demo.video_demo.utils.CommonUtils;
import com.video.demo.video_demo.utils.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/8 7:03
 */
@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public VideoOrder save(VideoOrderDto videoOrderDto) throws Exception {

         //查找视频信息
        Video video = videoMapper.findById(videoOrderDto.getVideoId());

        //查找用户信息
        User user = userMapper.findById(videoOrderDto.getUserId());

        //生成订单
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setTotalFee(video.getPrice());
        videoOrder.setVideoImg(video.getCoverImg());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());
        videoOrder.setVideoId(video.getId());
        videoOrder.setState(0);
        videoOrder.setUserId(user.getId());
        videoOrder.setHeadImg(user.getHeadImg());
        videoOrder.setNickname(user.getName());

        videoOrder.setDel(0);
        videoOrder.setIp(videoOrderDto.getIp());
        videoOrder.setOutTradeNo(CommonUtils.generateUUID());

        videoOrderMapper.insert(videoOrder);

        unifiedOrder(videoOrder);

        //生成签名

        //统一下单

        //获取codeurl

        //生成二维码

        return null;
    }

    /**
     * 统一下单方法
     * @param videoOrder
     * @return
     * @throws Exception
     */
    private String unifiedOrder(VideoOrder videoOrder) throws Exception {

        //生成签名
        SortedMap<String, String> params = new TreeMap<>();
        params.put("appid",weChatConfig.getAppId());
        params.put("mch_id",weChatConfig.getMchId());
        params.put("nonce_str",CommonUtils.generateUUID());
        params.put("body",videoOrder.getVideoTitle());
        params.put("out_trade_no",videoOrder.getOutTradeNo());
        params.put("total_fee",videoOrder.getTotalFee().toString());
        params.put("spbill_create_ip",videoOrder.getIp());
        params.put("notify_url",weChatConfig.getPayCallbackUrl());
        params.put("trade_type","NATIVE");

        String sign = WXPayUtil.createSign(params,weChatConfig.getKey());
        params.put("sign",sign);

        //map转xml
        String payXml = WXPayUtil.mapToXml(params);

        System.out.println(payXml);
        

        return "";
    }
}
