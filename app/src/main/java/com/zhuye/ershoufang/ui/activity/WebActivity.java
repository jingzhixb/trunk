package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.ShareBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangActivity;
import com.zhuye.ershoufang.ui.activity.home.FangDaiJiSuanActivity;
import com.zhuye.ershoufang.ui.activity.home.ZuFangActivity;
import com.zhuye.ershoufang.ui.activity.me.ChuZuActivity;
import com.zhuye.ershoufang.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

public abstract class WebActivity extends BaseActivity {
    protected static final int COLLECT = 9456;
    private static final int YOUHUI = 988;
    protected static final int SHARE = 956;
    @BindView(R.id.webview)
    protected WebView webview;
    @BindView(R.id.back)
    protected  ImageView back;
    @BindView(R.id.ttitle)
    protected TextView ttitle;
    @BindView(R.id.subtitle)
    protected TextView subtitle;
    @BindView(R.id.root)
   protected LinearLayout root;

    @Override
    protected int getResId() {
        return R.layout.activity_web;
    }

    private ImmersionBar mImmersionBar;

    @Override
    protected void initData() {
        super.initData();
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

//        webview.loadUrl("file:///android_asset/index.html");
        webview.setWebViewClient(new ExampleWebViewClient());
        if(getFromLocal()){
            webview.loadUrl("file:///android_asset/" + getUrlName() + ".html");
        }else {
            webview.loadUrl(getUrlName());
        }
        root.setVisibility(View.GONE);
    }

    @Override
    protected void initView() {
        super.initView();
        //mImmersionBar = ImmersionBar.with(this);
        // mImmersionBar.init();   //所有子类都将继承这些相同的属性
    }

    protected Boolean getFromLocal() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private class ExampleWebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }
    }

    public abstract String getUrlName();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            //mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进
        }
//        公用一个的处理
        webview.destroy();
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }


    private UMShareListener  umShareListener = new UMShareListener(){
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            LogUtils.i(share_media.toString());
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            LogUtils.i(throwable.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {

        }
    };

    public class AndroidBridge //这个类中提供各种js可调用的方法。
    {
        @JavascriptInterface
        public void jisuan(){
            start(FangDaiJiSuanActivity.class);
        }

        @JavascriptInterface
        public void jieshu(){
            jieshuba();
        }

        @JavascriptInterface
        public String gettype(){
            return getType();
        }

        @JavascriptInterface
        public void lookmore(String nei){
            if(nei.equals("1")){
                start(ErShouFangActivity.class);
            }else if(nei.equals("2")){
                start(ZuFangActivity.class);
            }
            }


        @JavascriptInterface
        public String getId()
        {
            return getZiId();
//            handler.post(new Runnable(){
//                public void run()
//                {
//                    Log.d("ZW", "calAndroid("+arg+")");
//                    textView5.setText(arg);
//                }
//            });
        }
        @JavascriptInterface
        public String getToken1(){
            return getToken();
        }

        @JavascriptInterface
        public String getQuI(){
            return getQuId();
        }
        @JavascriptInterface
        public void toas(String content){
            toast(content);
        }

        @JavascriptInterface
        public void shoucang(){
          //  toast("shoucang");
            //            //CommonApi.getInstance().collect(getToken(),"1",id,XinFangDetailActivity.this,SHOUCANG);
            //            //// TODO: 2018/5/23 0023
            //
            //            //javashoucang();
            webview.loadUrl("javascript:yishoucang()");
        }
        @JavascriptInterface
        public void share(){
            getShareData();


//            if(Thread.currentThread()== Looper.getMainLooper().getThread()){
//                Toast.makeText(XinFangDetailActivity.this,"手长",Toast.LENGTH_SHORT).show();
//            }else {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(XinFangDetailActivity.this,"手长",Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
        }
        @JavascriptInterface
        public String getBase(){
            return getBaseUrl();
        }


        @JavascriptInterface
        public void chat(String id){
            //toast(id+"");
            if(isNeedLogin()){
                start(LoginActivity.class);
            }else {
                RongIM.getInstance().startConversation(WebActivity.this
                        , Conversation.ConversationType.PRIVATE,getZiId(),"");
            }
            }

        @JavascriptInterface
        public void chat(String id,String name){
            if(isNeedLogin()){
                start(LoginActivity.class);
            }else {
                RongIM.getInstance().startConversation(WebActivity.this
                        , Conversation.ConversationType.PRIVATE,id,name);
            }
        }

        @JavascriptInterface
        public void chat(){
            // toast(totoken);
            toast("chat");
//            RongIM.getInstance().startConversation(XinFangDetailActivity.this
//            ,Conversation.ConversationType.PRIVATE,totoken,"sadfasdf");

//            if(Thread.currentThread()== Looper.getMainLooper().getThread()){
//                Toast.makeText(XinFangDetailActivity.this,"手长",Toast.LENGTH_SHORT).show();
//            }else {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(XinFangDetailActivity.this,"手长",Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
        }
        @JavascriptInterface
        public void callphone(String mobile){
            //toast("callphone");
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+mobile));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


        @JavascriptInterface
        public void finis(){
           jieshu();
        }

        @JavascriptInterface
        public void callAndroid222(final String arg,final  String arg2)
        {
//            handler.post(new Runnable(){
//                public void run()
//                {
//                    Log.d("zwzw", "callAndroid222("+arg+","+arg2+")");
//                    textView5.setText(arg);
//                }
//            });
        }

        @JavascriptInterface
        public void login(){
            start(LoginActivity.class);
        }

        @JavascriptInterface
        public void youhui(String number){
            if(isNeedLogin()){
                start(LoginActivity.class);
            }else {
                CommonApi.getInstance().discount(getToken(),getZiId(),number,WebActivity.this,YOUHUI);
            }

            }
    }

    protected void jieshuba() {

    }

    protected String getType() {
        return "";
    }

    protected void jieshu() {
    }

    protected void getShareData() {

    }

    protected abstract void javashoucang();


    protected String getZiId() {
        return "1";
    }


    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case YOUHUI:
                toast(base.getMessage());
                break;
            case COLLECT:
                toast(base.getMessage());
                break;

            case SHARE:
                CommonObjectBean<ShareBean> bean = (CommonObjectBean<ShareBean>) base;
                UMImage image = new UMImage(WebActivity.this, NetWorkUrl.IMAGEURL+bean.getData().getPhoto());//网络图片
                UMWeb web = new UMWeb(bean.getData().getUrl());
                web.setTitle(bean.getData().getTitle());//标题
                web.setThumb(image);  //缩略图
               // web.setDescription(bean.getData().get);//描述
                new ShareAction(WebActivity.this).withMedia(web)
                        .setDisplayList(SHARE_MEDIA.QZONE,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                        .setCallback(umShareListener).open();
                break;
        }
    }

    public String getBaseUrl(){
        return NetWorkUrl.BASE;
    }
    public String getBaseUrlImg(){
        return NetWorkUrl.IMG;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
