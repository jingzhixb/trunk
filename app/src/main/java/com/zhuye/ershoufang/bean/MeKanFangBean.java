package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class MeKanFangBean {
    /**
     * id : 6
     * photo : 2018/06/13/thumb_5b20c905b2d06.jpg
     * title : 请看好房子
     * loupan_id : 25
     * addr : 不好看
     * youlie : ["好位置","校区当"]
     * price : 100000
     */

    private String id;
    private String photo;
    private String title;
    private String loupan_id;
    private String addr;
    private String price;
    private List<String> youlie;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLoupan_id() {
        return loupan_id;
    }

    public void setLoupan_id(String loupan_id) {
        this.loupan_id = loupan_id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getYoulie() {
        return youlie;
    }

    public void setYoulie(List<String> youlie) {
        this.youlie = youlie;
    }
//    /**
//     * id : 4
//     * photo :
//     * title : 户口
//     * loupan_id : 20
//     * addr : 领
//     * youlie : [{"id":"4","photo":"","title":"户口","loupan_id":"20","addr":"领","youlie":"寒门"}]
//     * price : 14
//     */
//
//    private String id;
//    private String photo;
//    private String title;
//    private String loupan_id;
//    private String addr;
//    private String price;
//    private List<YoulieBean> youlie;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(String photo) {
//        this.photo = photo;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getLoupan_id() {
//        return loupan_id;
//    }
//
//    public void setLoupan_id(String loupan_id) {
//        this.loupan_id = loupan_id;
//    }
//
//    public String getAddr() {
//        return addr;
//    }
//
//    public void setAddr(String addr) {
//        this.addr = addr;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public List<YoulieBean> getYoulie() {
//        return youlie;
//    }
//
//    public void setYoulie(List<YoulieBean> youlie) {
//        this.youlie = youlie;
//    }
//
//    public static class YoulieBean {
//        /**
//         * id : 4
//         * photo :
//         * title : 户口
//         * loupan_id : 20
//         * addr : 领
//         * youlie : 寒门
//         */
//
//        private String id;
//        private String photo;
//        private String title;
//        private String loupan_id;
//        private String addr;
//        private String youlie;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getPhoto() {
//            return photo;
//        }
//
//        public void setPhoto(String photo) {
//            this.photo = photo;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getLoupan_id() {
//            return loupan_id;
//        }
//
//        public void setLoupan_id(String loupan_id) {
//            this.loupan_id = loupan_id;
//        }
//
//        public String getAddr() {
//            return addr;
//        }
//
//        public void setAddr(String addr) {
//            this.addr = addr;
//        }
//
//        public String getYoulie() {
//            return youlie;
//        }
//
//        public void setYoulie(String youlie) {
//            this.youlie = youlie;
//        }
//    }


//    /**
//     * id : 免费看房id
//     * photo : 图片
//     * title : 标题
//     * loupan_id : 楼盘id
//     * addr : 地址
//     * youlie : ["优劣数组"]
//     * price : 单价
//     *
//     * {"data":[{"id":"4","photo":"","title":"\u6237\u53e3","loupan_id":"20","addr":"\u9886","youlie":["\u53f7"],"price":"14"},{"id":"3","photo":"","title":"\u597d2\u4e86","loupan_id":"16","addr":"km","youlie":{"1":"\u5bd2\u95e8"},"price":"14"},{"id":"2","photo":"","title":"\u597d\u5427","loupan_id":"17","addr":"\u54af","youlie":[],"price":"14"}],"message":"","code":"200"}
//     */
//
//    private String id;
//    private String photo;
//    private String title;
//    private String loupan_id;
//    private String addr;
//    private String price;
//    private List<String> youlie;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(String photo) {
//        this.photo = photo;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getLoupan_id() {
//        return loupan_id;
//    }
//
//    public void setLoupan_id(String loupan_id) {
//        this.loupan_id = loupan_id;
//    }
//
//    public String getAddr() {
//        return addr;
//    }
//
//    public void setAddr(String addr) {
//        this.addr = addr;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public List<String> getYoulie() {
//        return youlie;
//    }
//
//    public void setYoulie(List<String> youlie) {
//        this.youlie = youlie;
//    }


}
