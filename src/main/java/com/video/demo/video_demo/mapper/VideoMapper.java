package com.video.demo.video_demo.mapper;

import com.video.demo.video_demo.domain.Video;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/2 4:30
 */
public interface VideoMapper {

    @Select("select * from video")
    List<Video> findAll();
}
