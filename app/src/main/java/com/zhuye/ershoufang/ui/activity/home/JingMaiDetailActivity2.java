package com.zhuye.ershoufang.ui.activity.home;

import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.WebActivity;

public class JingMaiDetailActivity2 extends WebActivity {

    @Override
    public String getUrlName() {
        return "jingmai-detail";
    }

    @Override
    protected void javashoucang() {

    }



    String id ="";
    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    @Override
    protected void getShareData() {
        super.getShareData();
        CommonApi.getInstance().share(id,"1",JingMaiDetailActivity2.this,SHARE,false);
    }

    @Override
    protected String getZiId() {
        return id;
    }
}
