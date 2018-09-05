package com.zhuye.ershoufang.weidtet;

import java.util.List;

/**
 * Created by Administrator on 2018/5/12 0012.
 */

public class MyRecycleBean  extends MyRecycleBean2{
    public List<String> filepath;
    public String miaoshua;
    public String mian;
    public String name;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String price;

    public String filename;
    public List<String> getFilepath() {
        return filepath;
    }

    public void setFilepath(List<String> filepath) {
        this.filepath = filepath;
    }

    public String getMiaoshua() {
        return miaoshua;
    }

    public void setMiaoshua(String miaoshua) {
        this.miaoshua = miaoshua;
    }

    public String getMian() {
        return mian;
    }

    public void setMian(String mian) {
        this.mian = mian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyRecycleBean() {
    }

    public MyRecycleBean(List<String> filepath, String miaoshua, String mian,String price) {
        this.filepath = filepath;
        this.miaoshua = miaoshua;
        this.mian = mian;
        this.price = price;
    }
}
