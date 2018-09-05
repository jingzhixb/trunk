package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/7 0007.
 */

public class ZhuangxiuJiaJuBean {
    /**
     * user_id : id
     * shop : 家具商名称
     * shop_face : 头像
     * shop_detail : 介绍
     */


    private String user_id;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    private String shop_id;
    private String shop;
    private String shop_face;
    private String shop_detail;
    private String shop_img;
    private int cang;

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public int getCang() {
        return cang;
    }

    public void setCang(int cang) {
        this.cang = cang;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getShop_face() {
        return shop_face;
    }

    public void setShop_face(String shop_face) {
        this.shop_face = shop_face;
    }

    public String getShop_detail() {
        return shop_detail;
    }

    public void setShop_detail(String shop_detail) {
        this.shop_detail = shop_detail;
    }
}
