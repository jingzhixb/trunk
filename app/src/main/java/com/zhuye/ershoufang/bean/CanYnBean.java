package com.zhuye.ershoufang.bean;

public class CanYnBean {
    /**
     * user_id : 用户id
     * mobile : 手机号
     * nickname : 昵称
     * face : 头像
     */

    private String user_id;
    private String mobile;
    private String nickname;
    private String face;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }
}
