package com.zhuye.ershoufang.ui.activity.home;

import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.WebActivity;

public class ErShouFangDetailActivity extends WebActivity {

    @Override
    public String getUrlName() {
        return "ershou-detail";
    }

    @Override
    protected void javashoucang() {

    }

    @Override
    protected void jieshuba() {
        finish();
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
        CommonApi.getInstance().share(id,"1",ErShouFangDetailActivity.this,SHARE,false);

    }

    @Override
    protected String getZiId() {
        return id;
    }

    //    protected class AndroidBridge {
//        @JavascriptInterface
//        public String getId() {
//            return id;
//        }
//
//        @JavascriptInterface
//        public String getToken(){
//            return getToken();
//        }
//
//        @JavascriptInterface
//        public void callAndroid222(final String arg,final  String arg2) {
////            handler.post(new Runnable(){
////                public void run()
////                {
////                    Log.d("zwzw", "callAndroid222("+arg+","+arg2+")");
////                    textView5.setText(arg);
////                }
////          });
//        }
//    }
}
