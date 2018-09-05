package com.zhuye.ershoufang.bean;

public class SelectBean2 {
    /**
     * attr_id : id
     * cate_id : 分类id
     * type : 种类
     * attr_name : 名称
     * orderby : 1
     */

    private String attr_id;
    private String cate_id;
    private String type;
    private String attr_name;
    private String orderby;

    public String getAttr_id() {
        return attr_id;
    }

    public void setAttr_id(String attr_id) {
        this.attr_id = attr_id;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttr_name() {
        return attr_name;
    }

    public void setAttr_name(String attr_name) {
        this.attr_name = attr_name;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
}
