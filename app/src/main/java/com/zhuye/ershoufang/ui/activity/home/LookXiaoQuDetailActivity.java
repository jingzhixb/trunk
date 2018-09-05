package com.zhuye.ershoufang.ui.activity.home;

import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.WebActivity;

public class LookXiaoQuDetailActivity extends WebActivity {


    @Override
    public String getUrlName() {
        return "ershou-xiaoqu";
    }
    String id ="";
    @Override
    protected void javashoucang() {

    }
    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    @Override
    protected String getZiId() {
        return id;
    }

    @Override
    protected void getShareData() {
        super.getShareData();
        CommonApi.getInstance().share(id,"1",LookXiaoQuDetailActivity.this,SHARE,false);
    }

    @Override
    protected void jieshuba() {
        super.jieshuba();
        finish();
    }
}
