package com.video.demo.video_demo.service.impl;

import com.video.demo.video_demo.domain.Video;
import com.video.demo.video_demo.mapper.VideoMapper;
import com.video.demo.video_demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/2 2:36
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    @Override
    public Video findById(int id) {
        return videoMapper.findById(id);
    }

    @Override
    public int update(Video video) {
        return videoMapper.update(video);
    }

    @Override
    public int delete(int id) {
        return videoMapper.delete(id);
    }

    @Override
    public int save(Video video) {
        int rows = videoMapper.save(video);
        System.out.println("保存对象的id= " + video.getId());
        return rows;
    }
}
