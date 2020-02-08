package com.video.demo.video_demo.exception;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/9 4:27
 */

/**
 * 自定义异常类
 */
public class XdException extends RuntimeException{

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 异常消息
     */
    private String msg;

    public XdException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
