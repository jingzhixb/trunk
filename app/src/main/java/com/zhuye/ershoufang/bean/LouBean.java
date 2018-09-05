package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/15 0015.
 */

public class LouBean {


    /**
     * id : 28
     * uid : 103
     * title : 好好房子
     * city_id : 47515
     * area_id : 14
     * business_id : 15
     * price : 14
     * kdate : 2018-06-13 17:37
     * jdate : 2018-12-01 17:37
     * select : 2
     * mobile : 13676981716
     * create_time : 1528882753
     * address : 哈
     * lng : 116.38942948239402
     * lat : 39.91742281237473
     * is_onsale : 2
     * youhui : 2
     * youhui_starttime : 2018-06-13
     * youhui_endtime : 2018-06-13
     * peizhi : [""]
     * mianji : 1000
     * is_recommand : 0
     * audit : 1
     * recommand : null
     * city_name : 北京市
     * pro_id : 1
     * pro_name : 北京市
     * area_name : 西城区
     * business_name : 西长安街街道
     * huxing : [{"huxing":"1","img":"2018/06/13/thumb_5b20e63eb657c.jpg","hx_area":"1","miaoshu":"描述"},{"huxing":"2","img":"2018/06/13/thumb_5b20e63ee8a6b.jpg","hx_area":"14","miaoshu":"好吧"}]
     * xiaoguo : ["2018/06/13/thumb_5b20e63ed64ad.jpg"]
     * shijing : ["2018/06/13/thumb_5b20e63f9d514.jpg"]
     * guihua : ["2018/06/13/thumb_5b20e64080000.jpg"]
     * peitao : ["2018/06/13/thumb_5b20e640106a8.jpg"]
     * jiaotong : ["2018/06/13/thumb_5b20e641193f4.jpg"]
     */

    private String id;
    private String uid;
    private String title;
    private String city_id;
    private String area_id;
    private String business_id;
    private String price;
    private String kdate;
    private String jdate;
    private String select;
    private String mobile;
    private String create_time;
    private String address;
    private String lng;
    private String lat;
    private String is_onsale;
    private String youhui;
    private String youhui_starttime;
    private String youhui_endtime;
    private String mianji;
    private String is_recommand;
    private String audit;
    private Object recommand;
    private String city_name;
    private String pro_id;
    private String pro_name;
    private String area_name;
    private String business_name;
    private List<String> peizhi;
    private List<HuxingBean> huxing;
    private List<String> xiaoguo;
    private List<String> shijing;
    private List<String> guihua;
    private List<String> peitao;
    private List<String> jiaotong;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKdate() {
        return kdate;
    }

    public void setKdate(String kdate) {
        this.kdate = kdate;
    }

    public String getJdate() {
        return jdate;
    }

    public void setJdate(String jdate) {
        this.jdate = jdate;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getIs_onsale() {
        return is_onsale;
    }

    public void setIs_onsale(String is_onsale) {
        this.is_onsale = is_onsale;
    }

    public String getYouhui() {
        return youhui;
    }

    public void setYouhui(String youhui) {
        this.youhui = youhui;
    }

    public String getYouhui_starttime() {
        return youhui_starttime;
    }

    public void setYouhui_starttime(String youhui_starttime) {
        this.youhui_starttime = youhui_starttime;
    }

    public String getYouhui_endtime() {
        return youhui_endtime;
    }

    public void setYouhui_endtime(String youhui_endtime) {
        this.youhui_endtime = youhui_endtime;
    }

    public String getMianji() {
        return mianji;
    }

    public void setMianji(String mianji) {
        this.mianji = mianji;
    }

    public String getIs_recommand() {
        return is_recommand;
    }

    public void setIs_recommand(String is_recommand) {
        this.is_recommand = is_recommand;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public Object getRecommand() {
        return recommand;
    }

    public void setRecommand(Object recommand) {
        this.recommand = recommand;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
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

    public List<String> getPeizhi() {
        return peizhi;
    }

    public void setPeizhi(List<String> peizhi) {
        this.peizhi = peizhi;
    }

    public List<HuxingBean> getHuxing() {
        return huxing;
    }

    public void setHuxing(List<HuxingBean> huxing) {
        this.huxing = huxing;
    }

    public List<String> getXiaoguo() {
        return xiaoguo;
    }

    public void setXiaoguo(List<String> xiaoguo) {
        this.xiaoguo = xiaoguo;
    }

    public List<String> getShijing() {
        return shijing;
    }

    public void setShijing(List<String> shijing) {
        this.shijing = shijing;
    }

    public List<String> getGuihua() {
        return guihua;
    }

    public void setGuihua(List<String> guihua) {
        this.guihua = guihua;
    }

    public List<String> getPeitao() {
        return peitao;
    }

    public void setPeitao(List<String> peitao) {
        this.peitao = peitao;
    }

    public List<String> getJiaotong() {
        return jiaotong;
    }

    public void setJiaotong(List<String> jiaotong) {
        this.jiaotong = jiaotong;
    }

    public static class HuxingBean {
        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        /**
         * huxing : 1
         * img : 2018/06/13/thumb_5b20e63eb657c.jpg
         * hx_area : 1
         * miaoshu : 描述
         */
        private String price;
        private String huxing;
        private String img;
        private String hx_area;
        private String miaoshu;

        public String getHuxing() {
            return huxing;
        }

        public void setHuxing(String huxing) {
            this.huxing = huxing;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getHx_area() {
            return hx_area;
        }

        public void setHx_area(String hx_area) {
            this.hx_area = hx_area;
        }

        public String getMiaoshu() {
            return miaoshu;
        }

        public void setMiaoshu(String miaoshu) {
            this.miaoshu = miaoshu;
        }
    }
}
