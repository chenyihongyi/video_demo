package com.video.demo.video_demo.exception;

import com.video.demo.video_demo.domain.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/9 4:31
 */
@ControllerAdvice
public class XdExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData Handler(Exception e){

        if(e instanceof XdException){
            XdException xdException =  (XdException)e;
            return JsonData.buildError(xdException.getMsg(),xdException.getCode());
        }else{
            return JsonData.buildError("全局异常，未知错误");
        }
    }
}
