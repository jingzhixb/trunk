package com.zhuye.ershoufang.bean;

public class SingleChooseBean {
    private String content;
    private String price1;
    private String price2;

    public SingleChooseBean() {
    }

    public SingleChooseBean(String content, String price1, String price2, Boolean choose) {
        this.content = content;
        this.price1 = price1;
        this.price2 = price2;
        this.choose = choose;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getChoose() {
        return choose;
    }

    public void setChoose(Boolean choose) {
        this.choose = choose;
    }

    private Boolean choose = false;
}
