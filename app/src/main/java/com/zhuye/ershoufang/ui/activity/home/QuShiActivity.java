package com.zhuye.ershoufang.ui.activity.home;

import com.zhuye.ershoufang.ui.activity.WebActivity;

public class QuShiActivity extends WebActivity {
    @Override
    public String getUrlName() {
        return "qushi";
    }


    @Override
    protected void initData() {
        super.initData();
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    @Override
    protected void jieshuba() {
        finish();
    }

    @Override
    protected void javashoucang() {

    }

//    @BindView(R.id.back)
//    ImageView back;
//    @BindView(R.id.ttitle)
//    TextView ttitle;
//    @BindView(R.id.subtitle)
//    TextView subtitle;
//    @BindView(R.id.location)
//    TextView location;
//    @BindView(R.id.ll)
//    RelativeLayout ll;
//    @BindView(R.id.content)
//    RelativeLayout content;
//
//    @Override
//    protected int getResId() {
//        return R.layout.activity_qu_shi;
//    }
//
//    @Override
//    protected void initData() {
//        super.initData();
//        //图形的处理
//
//    }
//
//    @Override
//    protected void initView() {
//        super.initView();
//        hide(subtitle);
//        setText(ttitle,"房价趋势");
//    }
//
//    @OnClick(R.id.back)
//    public void onViewClicked() {
//    }
}
