package com.video.demo.video_demo.service;

import com.video.demo.video_demo.domain.VideoOrder;
import com.video.demo.video_demo.dto.VideoOrderDto;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/8 6:56
 */

/**
 * 订单接口
 */
public interface VideoOrderService {

    /**
     * 下单接口
     * @param videoOrderDto
     * @return
     * @throws Exception
     */
    String save(VideoOrderDto videoOrderDto) throws Exception;

    /**
     * 根据流水号查找订单
     * @param outTradeNo
     * @return
     */
    VideoOrder findByOutTrade(String outTradeNo);

    /**
     * 根据流水号更新订单
     * @param videoOrder
     * @return
     */
    int updateVideoOrderByOutTradeNo(VideoOrder videoOrder);
}
