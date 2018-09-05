package com.zhuye.ershoufang.bean;

public class KanBean {
    /**
     * id : 主键id
     * mobile : 联系方式
     * mianji : 面积
     * create_time : 时间
     * face : 头像
     * view : 0表示未购买查看过 1已购买查看
     */

    private String id;
    private String mobile;
    private String mianji;
    private String create_time;
    private String face;
    private String view;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMianji() {
        return mianji;
    }

    public void setMianji(String mianji) {
        this.mianji = mianji;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
