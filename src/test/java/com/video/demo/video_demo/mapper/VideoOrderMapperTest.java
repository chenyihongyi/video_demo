package com.video.demo.video_demo.mapper;

import com.video.demo.video_demo.domain.VideoOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/7 9:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoOrderMapperTest {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Test
    public void insert() {
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setDel(0);
        videoOrder.setTotalFee(111);
        videoOrder.setHeadImg("https:hangzhoualiyun.wechatpay.com");
        videoOrder.setVideoTitle("微信支付");
        videoOrderMapper.insert(videoOrder);
        assertNotNull(videoOrder.getId());
    }

    @Test
    public void findById() {
        VideoOrder videoOrder = videoOrderMapper.findById(1);
        assertNotNull(videoOrder);
    }

    @Test
    public void findByOutTradeNo() {

    }

    @Test
    public void del() {
    }

    @Test
    public void findMyOrderList() {
    }

    @Test
    public void updateVideoOrderByOutTradeNo() {
    }
}