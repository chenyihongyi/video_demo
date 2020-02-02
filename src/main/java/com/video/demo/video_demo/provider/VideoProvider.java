package com.video.demo.video_demo.provider;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/3 3:28
 */

import com.video.demo.video_demo.domain.Video;
import org.apache.ibatis.jdbc.SQL;

/**
 * video构建动态sql语句
 */
public class VideoProvider {

    public String updateVideo(final Video video) {
        return new SQL() {
            {
                UPDATE("video");

                //条件写法
                if (video.getTitle() != null) {
                    SET("title=#{title}");
                }
                if (video.getSummary() != null) {
                    SET("summary=#{summary}");
                }
                if(video.getCoverImg() !=null){
                    SET("cover_img=#{coverImg}");
                }
                if(video.getPrice() !=null){
                    SET("price=#{price}");
                }
                if(video.getOnline() !=null){
                    SET("online=#{online}");
                }
                if(video.getPoint() !=null){
                    SET("point=#{point}");
                }
                WHERE("id=#{id}");
                }}.toString();
        }
    }
