package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

public class ChuZuBean {
    /**
     * life_id : 房源id
     * cate_id : 类别 10：工业厂房 12:写字楼 13：商铺
     * title : 标题
     * city_id : 城市id
     * area_id : 区域id
     * business_id : 街道id
     * text1 : 商铺-楼层 写字楼--楼层
     * text2 :  商铺-总楼层 写字楼--总楼层
     * text3 : 商铺-楼盘名称 写字楼--楼盘名称
     * text4 : 商铺-面宽
     * num1 :  商铺-租金 写字楼--租金 厂房-租金
     * num2 :  商铺-面积 写字楼--物业费 厂房-面积
     * num3 : 商铺-物业费 写字楼--面积
     * select1 :  写字楼--楼层id
     * select2 :  商铺-状态id
     * select3 :  写字楼--付款方式id 厂房-付款方式id
     * select5 :  商铺-配置id
     * select6 : 商铺-人群id
     * contact : 联系人
     * mobile : 手机号
     * addr : 详细地址
     * lng : 经度
     * lat : 纬度
     * xiaoqu : 小区
     * fj_select5 :  商铺-配置填写信息
     * fj_select6 : 商铺-人群填写信息
     * select1_name :  写字楼--楼层名称
     * select2_name :  商铺-状态名称
     * select3_name :  写字楼--付款方式名称 厂房-付款方式名称
     * select5_name : [" 商铺-配置数组"]
     * select6_name : ["商铺-人群数组"]
     * photo : [{"photo":"图片集数组"},{"photo":"2016/12/12/thumb_584e0ca41fb5a.jpg"},{"photo":"2017/06/20/thumb_5948e1079a04b.png"}]
     * details : 详情
     */

    private String life_id;
    private String cate_id;
    private String title;
    private String city_id;
    private String area_id;
    private String business_id;
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String num1;
    private String num2;
    private String num3;
    private String select1;
    private String select2;
    private String select3;
    private String select5;
    private String select6;
    private String contact;
    private String mobile;
    private String addr;
    private String lng;
    private String lat;
    private String xiaoqu;
    private String fj_select5;
    private String fj_select6;
    private String select1_name;
    private String select2_name;
    private String select3_name;
    private String details;
    private List<String> select5_name;
    private List<String> select6_name;
//    private List<String> fj_select5;
//    private List<String> fj_select6;
    private List<PhotoBean> photo;

    public String getLife_id() {
        return life_id;
    }

    public void setLife_id(String life_id) {
        this.life_id = life_id;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getNum3() {
        return num3;
    }

    public void setNum3(String num3) {
        this.num3 = num3;
    }

    public String getSelect1() {
        return select1;
    }

    public void setSelect1(String select1) {
        this.select1 = select1;
    }

    public String getSelect2() {
        return select2;
    }

    public void setSelect2(String select2) {
        this.select2 = select2;
    }

    public String getSelect3() {
        return select3;
    }

    public void setSelect3(String select3) {
        this.select3 = select3;
    }

    public String getSelect5() {
        return select5;
    }

    public void setSelect5(String select5) {
        this.select5 = select5;
    }

    public String getSelect6() {
        return select6;
    }

    public void setSelect6(String select6) {
        this.select6 = select6;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getFj_select5() {
        return fj_select5;
    }

    public void setFj_select5(String fj_select5) {
        this.fj_select5 = fj_select5;
    }

    public String getFj_select6() {
        return fj_select6;
    }

    public void setFj_select6(String fj_select6) {
        this.fj_select6 = fj_select6;
    }

    public String getSelect1_name() {
        return select1_name;
    }

    public void setSelect1_name(String select1_name) {
        this.select1_name = select1_name;
    }

    public String getSelect2_name() {
        return select2_name;
    }

    public void setSelect2_name(String select2_name) {
        this.select2_name = select2_name;
    }

    public String getSelect3_name() {
        return select3_name;
    }

    public void setSelect3_name(String select3_name) {
        this.select3_name = select3_name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getSelect5_name() {
        return select5_name;
    }

    public void setSelect5_name(List<String> select5_name) {
        this.select5_name = select5_name;
    }

    public List<String> getSelect6_name() {
        return select6_name;
    }

    public void setSelect6_name(List<String> select6_name) {
        this.select6_name = select6_name;
    }

    public List<PhotoBean> getPhoto() {
        return photo;
    }

    public void setPhoto(List<PhotoBean> photo) {
        this.photo = photo;
    }

    public static class PhotoBean {
        /**
         * photo : 图片集数组
         */

        private String photo;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }
}
