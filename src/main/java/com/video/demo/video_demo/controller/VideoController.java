package com.video.demo.video_demo.controller;

import com.video.demo.video_demo.domain.Video;
import com.video.demo.video_demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/2 2:00
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("page")
    public Object pageVideo(){
        return videoService.findAll();
    }

    @GetMapping("find_by_id")
    public Object findById(int videoId){
        return videoService.findById(videoId);
    }

    @DeleteMapping("del_by_id")
    public Object delById(int videoId){

        return videoService.delete(videoId);
    }

    @PutMapping("update_by_id")
    public Object update(int videoId, String title){
        Video video = new Video();
        video.setId(videoId);
        video.setTitle(title);
        return videoService.update(video);
    }

    @PostMapping("save")
    public Object save(String title){
        Video video = new Video();
        video.setTitle(title);
        return videoService.save(video);
    }

}
