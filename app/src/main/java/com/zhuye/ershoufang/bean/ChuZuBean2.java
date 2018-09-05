package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

public class ChuZuBean2 {
    /**
     * life_id : 房源id
     * cate_id : 类别4：出租
     * title : 标题
     * text1 : 出租-楼层
     * text2 : 出租-总楼层
     * num1 : 出租-租金
     * num2 : 出租-面积
     * select1 : 出租-房屋类型id
     * select2 : 出租-装修程度id
     * select3 : 出租-租金压副id
     * select4 : 出租-租赁方式id
     * select5 : 出租-配套设置id
     * select6 : 商铺-人群id
     * contact : 联系人
     * mobile : 手机号
     * addr : 详细地址
     * xiaoqu : 小区
     * xiaoqu_id : 小区id
     * fj_select5 : 出租-配套设置客户填写信息
     * yaoqiu : 出租-要求
     * select1_name : 出租-房屋类型名称
     * select2_name : 出租-装修程度名称
     * select3_name : 出租-租金压副名称
     * select4_name : 出租-租赁方式名称
     * select5_name : ["出租-配套设置数组 商铺-配置数组"]
     * photo : [{"photo":"图片集数组"},{"photo":"2016/12/12/thumb_584e0ca41fb5a.jpg"},{"photo":"2017/06/20/thumb_5948e1079a04b.png"}]
     * details : 详情
     */

    private String life_id;
    private String cate_id;
    private String title;
    private String text1;
    private String text2;
    private String num1;
    private String num2;
    private String select1;
    private String select2;
    private String select3;
    private String select4;
    private String select5;
    private String select6;
    private String contact;
    private String mobile;
    private String addr;
    private String xiaoqu;
    private String xiaoqu_id;
    private String fj_select5;
    private String yaoqiu;
    private String select1_name;
    private String select2_name;
    private String select3_name;
    private String select4_name;
    private String details;
    private List<String> select5_name;
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

    public String getSelect4() {
        return select4;
    }

    public void setSelect4(String select4) {
        this.select4 = select4;
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

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getXiaoqu_id() {
        return xiaoqu_id;
    }

    public void setXiaoqu_id(String xiaoqu_id) {
        this.xiaoqu_id = xiaoqu_id;
    }

    public String getFj_select5() {
        return fj_select5;
    }

    public void setFj_select5(String fj_select5) {
        this.fj_select5 = fj_select5;
    }

    public String getYaoqiu() {
        return yaoqiu;
    }

    public void setYaoqiu(String yaoqiu) {
        this.yaoqiu = yaoqiu;
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

    public String getSelect4_name() {
        return select4_name;
    }

    public void setSelect4_name(String select4_name) {
        this.select4_name = select4_name;
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
