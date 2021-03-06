package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

public class MaiFangBean {
    /**
     * life_id : 房源id
     * cate_id : 3表示二手房
     * title : 标题
     * text1 : 二手-单价
     * text2 : 二手房--楼层
     * text3 : 二手房--总楼层
     * text4 : 二手房--单位房供
     * num1 : 二手房-售价
     * num2 : 二手房-面积
     * num3 : 二手房-首付
     * num4 : 二手房-月供
     * select1 : 单选 二手房--房屋类型
     * select2 : 单选 二手房--朝向 id
     * select3 : 单选 二手房--装修程度 id
     * select4 : 单选 二手房--年代 id
     * select5 : 多选（以，拼接）二手房--房源优劣 商铺-配置 id
     * contact : 联系人
     * mobile : 手机号
     * addr : 详细地址
     * xiaoqu : 小区
     * xiaoqu_id : 小区id
     * fj_select5 : select5 客户自己填写信息
     * select1_name : 单选 二手房--房屋类型
     * select2_name : 单选 二手房--朝向
     * select3_name : 单选 二手房--装修程度
     * select4_name : 单选 二手房--年代 名称
     * select5_name : ["二手房--房源优劣 商铺-配置 名称"]
     * select6_name : ["多选（以，拼接） 商铺-人群 名称数组"]
     * photo : [{"photo":"二手房室内图 写字楼|商铺|厂房图片"},{"photo":"2017/04/06/thumb_58e5f8b39ce12.png"},{"photo":"2017/04/06/thumb_58e5f8be4add0.png"},{"photo":"2017/04/06/thumb_58e5f8c89abbd.png"}]
     * pt : [{"photo":"二手房户型图"}]
     * ppt : [{"photo":"二手房环境图"}]
     * details : 二手房：核心热卖 其他：详情
     * dd : 二手房：业主心态
     */

    private String life_id;
    private String cate_id;
    private String title;
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String num1;
    private String num2;
    private String num3;
    private String num4;
    private String select1;
    private String select2;
    private String select3;
    private String select4;
    private String select5;
    private String contact;
    private String mobile;
    private String addr;
    private String xiaoqu;
    private String xiaoqu_id;
    private String fj_select5;
    private String select1_name;
    private String select2_name;
    private String select3_name;
    private String select4_name;
    private String details;
    private String dd;
    private List<String> select5_name;
    private List<String> select6_name;
    private List<PhotoBean> photo;
    private List<PtBean> pt;
    private List<PptBean> ppt;

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

    public String getNum4() {
        return num4;
    }

    public void setNum4(String num4) {
        this.num4 = num4;
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

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
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

    public List<PtBean> getPt() {
        return pt;
    }

    public void setPt(List<PtBean> pt) {
        this.pt = pt;
    }

    public List<PptBean> getPpt() {
        return ppt;
    }

    public void setPpt(List<PptBean> ppt) {
        this.ppt = ppt;
    }

    public static class PhotoBean {
        /**
         * photo : 二手房室内图 写字楼|商铺|厂房图片
         */

        private String photo;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }

    public static class PtBean {
        /**
         * photo : 二手房户型图
         */

        private String photo;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }

    public static class PptBean {
        /**
         * photo : 二手房环境图
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
