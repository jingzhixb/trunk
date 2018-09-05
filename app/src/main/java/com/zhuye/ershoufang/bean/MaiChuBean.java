package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/8 0008.
 */

public class MaiChuBean {
    /**
     * life_id : id
     * xiaoqu : 小区
     * huxing : 户型
     * louceng : 楼层
     * num1 : 面积
     * num2 : 售价|租金
     * select1 : 卖房--装修 出租-装修情况
     * select2 : 卖房-朝向 出租-付款方式
     * select3 : 卖房-房屋类型 出租方式
     * contact : 联系人
     * mobile : 手机号
     * addr : 详细地址
     * photo : ["图片"]
     * jd_name : 接单人名
     * jd_mobile : 接单手机号
     */

    private String life_id;
    private String xiaoqu;
    private String huxing;
    private String louceng;
    private String num1;
    private String num2;
    private String select1;
    private String select2;
    private String select3;

    public String getSelect4() {
        return select4;
    }

    public void setSelect4(String select4) {
        this.select4 = select4;
    }

    private String select4;
    private String contact;
    private String mobile;
    private String addr;
    private String jd_name;
    private String jd_mobile;
    private List<String> photo;

    public String getLife_id() {
        return life_id;
    }

    public void setLife_id(String life_id) {
        this.life_id = life_id;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getHuxing() {
        return huxing;
    }

    public void setHuxing(String huxing) {
        this.huxing = huxing;
    }

    public String getLouceng() {
        return louceng;
    }

    public void setLouceng(String louceng) {
        this.louceng = louceng;
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

    public String getJd_name() {
        return jd_name;
    }

    public void setJd_name(String jd_name) {
        this.jd_name = jd_name;
    }

    public String getJd_mobile() {
        return jd_mobile;
    }

    public void setJd_mobile(String jd_mobile) {
        this.jd_mobile = jd_mobile;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }
}
