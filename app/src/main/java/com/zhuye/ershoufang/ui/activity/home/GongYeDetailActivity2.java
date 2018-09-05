package com.zhuye.ershoufang.ui.activity.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.WebActivity;

public class GongYeDetailActivity2 extends WebActivity {
    @Override
    public String getUrlName() {
        return "gongchang2";
    }


    @Override
    protected void getShareData() {
        CommonApi.getInstance().share(id,"1",GongYeDetailActivity2.this,SHARE,false);
    }

    @Override
    protected void jieshuba() {
        super.jieshuba();
        finish();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    protected String getZiId() {
        return id;
    }

    String id ="";
    String type ="";
    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        type = getIntent().getStringExtra("type");
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    @Override
    protected void javashoucang() {

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gong_ye_detail2);
//    }
//
//    @Override
//    protected int getResId() {
//        return 0;
//    }
}
