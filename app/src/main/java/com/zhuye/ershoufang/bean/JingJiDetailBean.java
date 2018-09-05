package com.zhuye.ershoufang.bean;

import java.util.List;

public class JingJiDetailBean {
    /**
     * user_id : 经纪人id
     * face : 头像
     * true_name : 姓名
     * shop : 店铺名称
     * city_id : 城市id
     * area_id : 区域id
     * business_id : 街道id
     * score : 分
     * main_business : 0住宅 1商业地产
     * area_name : 区域名称
     * declaration : 宣言
     * intro : 简介
     * year : 工作年限
     * company : 公司
     * xiaoqu : 主营小区
     * fanwei : 主营范围
     * mall : [{"life_id":"卖房id","cate_id":"类别","photo":"图片","title":"标题","area_name":"市","business_name":"街道","num1":"售价","num2":"面积","select1":"室","select5":["房源特色数组",""],"url":""}]
     * zu : [{"life_id":"租房id","cate_id":"类别","photo":"图片","title":"标题","area_name":"市","business_name":"街道","num1":"租金","num2":"1.0","select1":"","select5":["特色"],"url":""}]
     */

    private String user_id;

    public String getLife_count() {
        return life_count;
    }

    public void setLife_count(String life_count) {
        this.life_count = life_count;
    }

    private String life_count;
    private String face;
    private String true_name;
    private String shop;
    private String city_id;
    private String area_id;
    private String business_id;
    private String score;
    private String main_business;
    private String area_name;
    private String declaration;
    private String intro;
    private String year;
    private String company;
    private String xiaoqu;
    private String fanwei;
    private List<MallBean> mall;
    private List<MallBean> zu;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMain_business() {
        return main_business;
    }

    public void setMain_business(String main_business) {
        this.main_business = main_business;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getFanwei() {
        return fanwei;
    }

    public void setFanwei(String fanwei) {
        this.fanwei = fanwei;
    }

    public List<MallBean> getMall() {
        return mall;
    }

    public void setMall(List<MallBean> mall) {
        this.mall = mall;
    }

    public List<MallBean> getZu() {
        return zu;
    }

    public void setZu(List<MallBean> zu) {
        this.zu = zu;
    }

    public static class MallBean {
        /**
         * life_id : 卖房id
         * cate_id : 类别
         * photo : 图片
         * title : 标题
         * area_name : 市
         * business_name : 街道
         * num1 : 售价
         * num2 : 面积
         * select1 : 室
         * select5 : ["房源特色数组",""]
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

    public static class ZuBean {
        /**
         * life_id : 租房id
         * cate_id : 类别
         * photo : 图片
         * title : 标题
         * area_name : 市
         * business_name : 街道
         * num1 : 租金
         * num2 : 1.0
         * select1 :
         * select5 : ["特色"]
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
}
