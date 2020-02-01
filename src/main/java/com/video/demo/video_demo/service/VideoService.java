package com.video.demo.video_demo.service;

import com.video.demo.video_demo.domain.Video;

import java.util.List;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/2 2:35
 */
public interface VideoService {

    List<Video> findAll();

    Video findById(int id);

    int update(Video video);

    int delete(int id);

    int save(Video video);

}
