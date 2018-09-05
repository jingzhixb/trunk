package com.zhuye.ershoufang.bean;

import java.util.List;

public class JingJilBean {
    /**
     * life_id : 房源id
     * cate_id : 类别
     * photo : 图片
     * title : 标题
     * area_name : 市
     * business_name : 区
     * num1 : 售价|租金
     * num2 : 面积
     * select1 : 房屋类型
     * select5 : ["特点"]
     * url :
     */

    private String life_id;
    private String cate_id;
    private String photo;
    private String title;
    private String area_name;
    private String business_name;
    private String num1;
    private String num2;
    private String select1;
    private String url;
    private List<String> select5;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getSelect5() {
        return select5;
    }

    public void setSelect5(List<String> select5) {
        this.select5 = select5;
    }
}
