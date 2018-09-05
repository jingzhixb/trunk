package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/2/3 0003.
 */

public class Base {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Notify getNotify() {
        return notify;
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }

    public int code ;

    public int errorcode;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String message;


    public Notify notify;
}
