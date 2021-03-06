package com.video.demo.video_demo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/2 3:23
 */
public class Comment implements Serializable {

    private Integer id;

    /**
     * 内容
     */
    private String content;

    private Integer userId;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 昵称
     */
    private String name;

    /**
     * 评分，10分满分
     */
    private Double point;

    /**
     * 点赞数
     */
    private Integer up;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 视频id
     */
    private Integer videoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
