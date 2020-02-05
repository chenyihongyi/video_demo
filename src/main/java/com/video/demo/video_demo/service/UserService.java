package com.video.demo.video_demo.service;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/6 5:57
 */

import com.video.demo.video_demo.domain.User;

/**
 * 用户业务接口类
 */
public interface UserService {

    User saveWeChatUser(String code);
}
