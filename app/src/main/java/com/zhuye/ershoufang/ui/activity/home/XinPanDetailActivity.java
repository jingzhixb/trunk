package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.WebActivity;

public class XinPanDetailActivity extends WebActivity {


    String id;
    String cate_id;
    @Override
    protected void initView() {
        super.initView();
        id = getIntent().getStringExtra("id");
        cate_id = getIntent().getStringExtra("cate_id");
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    @Override
    protected void jieshuba() {
        super.jieshuba();
        finish();
    }

    @Override
    protected String getZiId() {
        return id;
    }

    @Override
    public String getUrlName() {
        String url = "";
        if(cate_id.equals("13")){
            // 商铺出租
            url = "xiezilou2";
        }else if(cate_id.equals("7")){
            // 商铺出售
            url = "xiezilou3";
        }else if(cate_id.equals("12")){
            // 写字楼出租
            url = "xiezilou5";
        }else if(cate_id.equals("6")){
            // 写字楼出售
            url = "xiezilou6";
        }else if(cate_id.equals("2")){
            // 商铺新增
            url = "xiezilou1";
        }else if(cate_id.equals("3")){
            // 写字楼新增
            url = "xiezilou4";
        }
        return url;
    }

    @Override
    protected void getShareData() {
        super.getShareData();
        CommonApi.getInstance().share(id,"1",XinPanDetailActivity.this,SHARE,false);
    }

    @Override
    protected void javashoucang() {
        //CommonApi.getInstance().share(id,"1",XinPanDetailActivity.this,SHARE,false);
    }
}
