package com.video.demo.video_demo.controller.admin;

import com.video.demo.video_demo.domain.Video;
import com.video.demo.video_demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/3 2:14
 */
@RestController
@RequestMapping("/admin/api/v1/video")
public class VideoAdminController {

    @Autowired
    private VideoService videoService;

    /**
     * 根据id删除视频
     * @param videoId
     * @return
     */
    @DeleteMapping("del_by_id")
    public Object delById(@RequestParam(value = "video_id", required = true) int videoId) {
        return videoService.delete(videoId);
    }

    /**
     * 根据id更新视频
     * @param video
     * @return
     */
    @PutMapping("update_by_id")
    public Object update(@RequestBody Video video){
        return videoService.update(video);
    }

    /**
     * 保存视频对象
     * @param video
     * @return
     */
    @PostMapping("save")
    public Object save(@RequestBody Video video) {
        return videoService.save(video);
    }

}
