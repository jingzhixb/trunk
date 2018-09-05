package com.zhuye.ershoufang.ui.activity.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.ui.activity.WebActivity;

public class MianFeiKanDetailActivity extends WebActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mian_fei_kan_detail);
//    }


    String id ="";
    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    @Override
    public String getUrlName() {
        return "mianfei-detail2";
    }

    @Override
    protected String getZiId() {
        return id;
    }

    @Override
    protected void javashoucang() {

    }

    @Override
    protected void jieshuba() {
        finish();
    }
}
