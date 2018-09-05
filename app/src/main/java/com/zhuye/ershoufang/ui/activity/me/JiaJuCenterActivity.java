package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.PersonInfoBean;
import com.zhuye.ershoufang.bean.UploadImgBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.FilesUtil;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyLinTv2View;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class JiaJuCenterActivity extends BaseActivity {


    private static final int GETDATA = 999;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.touxing)
    RoundedCornerImageView touxing;
    @BindView(R.id.xingxiang)
    MyInputView xingxiang;
    @BindView(R.id.mingcheng)
    MyInputView mingcheng;
    @BindView(R.id.shangjiajianjie)
    MyLinTv2View shangjiajianjie;
    @BindView(R.id.zhanghao)
    MyInputView zhanghao;
    @BindView(R.id.shenfenrenzh)
    MyInputView shenfenrenzh;
    @BindView(R.id.yingyezhizhao)
    MyInputView yingyezhizhao;
    @BindView(R.id.edit)
    Button edit;

    @Override
    protected int getResId() {
        return R.layout.activity_jia_ju_center;
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().message(getToken(),this,GETDATA);
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"个人信息");
        zhanghao.nocanChange();
    }

    Boolean bianji = true;
    String shop_img;
    String shop_face;
    @OnClick({R.id.back, R.id.edit,R.id.subtitle,R.id.touxing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.touxing:
                PhotoPicker.builder()
                        .setPhotoCount(1)
                        .setShowCamera(true)
                        .setShowGif(true)
                        .setPreviewEnabled(false)
                        .start(this, PhotoPicker.REQUEST_CODE);
                break;
                case R.id.subtitle:
                    //提交信息
                    if(mingcheng.getString()){
                        if(xingx==null|| TextUtils.isEmpty(xingx)){
                            xingx = bean.getData().getShop_img();

                            if(photos==null|| TextUtils.isEmpty(photos.get(0))){
                                shop_face = bean.getData().getShop_face();

                                CommonApi.getInstance().sub_message(getToken(),mingcheng.getContent(),
                                        xingx,shop_face,JiaJuCenterActivity.this,ADD,true);
                            }else {
                                OkGo.<String>post(NetWorkUrl.BASE+"index.php/App/index/upimg")
//                    .params("","")
                                        .params("file",FilesUtil.getSmallBitmap(
                                                JiaJuCenterActivity.this, photos.get(0)))
                                        .execute(new StringCallback() {
                                            @Override
                                            public void onSuccess(Response<String> response) {
                                                Log.i("asd",response.body());
                                                //{"data":{"face":"2018\/06\/04\/thumb_5b1525b5efd3b.jpg"},"message":"","code":"200"}
                                                UploadImgBean  bean2 = new Gson().fromJson(response.body(),UploadImgBean.class);
                                                if(bean2.getCode() == 200){
                                                    CommonApi.getInstance().sub_message(getToken(),mingcheng.getContent(),
                                                            bean.getData().getShop_img(),bean2.getData().getFace(),JiaJuCenterActivity.this,ADD,true);

//                                                switch (type){
//                                                    case 1:
//                                                        CommonApi.getInstance().jiajuedit(getToken(),bean.getData().getFace(),getString(mingcheng),getString(jianjie)
//                                                                ,id,JiaJuCenterActivity.this,ADDD);
//                                                        break;
//                                                    case 2:
//                                                        CommonApi.getInstance().jiajufabu(getToken(), bean.getData().getFace(), getString(mingcheng)
//                                                                , getString(jianjie), JiaJuCenterActivity.this, ADDD);
//                                                        break;
//                                                }
                                                }
                                            }

                                            @Override
                                            public void onError(Response<String> response) {
                                                super.onError(response);
                                                Log.i("asd",response.body());
                                            }
                                        });
                            }


                        }else {
                            OkGo.<String>post(NetWorkUrl.BASE+"index.php/App/index/upimg")
//                    .params("","")
                                    .params("file",FilesUtil.getSmallBitmap(
                                            JiaJuCenterActivity.this, photos.get(0)))
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(Response<String> response) {
                                            Log.i("asd",response.body());
                                            //{"data":{"face":"2018\/06\/04\/thumb_5b1525b5efd3b.jpg"},"message":"","code":"200"}
                                            UploadImgBean   bean1 = new Gson().fromJson(response.body(),UploadImgBean.class);
                                            if(bean1.getCode() == 200){
//                                                switch (type){
//                                                    case 1:
//                                                        CommonApi.getInstance().jiajuedit(getToken(),bean.getData().getFace(),getString(mingcheng),getString(jianjie)
//                                                                ,id,JiaJuCenterActivity.this,ADDD);
//                                                        break;
//                                                    case 2:
//                                                        CommonApi.getInstance().jiajufabu(getToken(), bean.getData().getFace(), getString(mingcheng)
//                                                                , getString(jianjie), JiaJuCenterActivity.this, ADDD);
//                                                        break;
//                                                }

                                                if(photos==null|| TextUtils.isEmpty(photos.get(0))){
                                                    shop_face = bean.getData().getShop_face();
                                                    CommonApi.getInstance().sub_message(getToken(),mingcheng.getContent(),
                                                            bean1.getData().getFace(),shop_face,JiaJuCenterActivity.this,ADD,true);
                                                }else {
                                                    OkGo.<String>post(NetWorkUrl.BASE+"index.php/App/index/upimg")
//                    .params("","")
                                                            .params("file",FilesUtil.getSmallBitmap(
                                                                    JiaJuCenterActivity.this, photos.get(0)))
                                                            .execute(new StringCallback() {
                                                                @Override
                                                                public void onSuccess(Response<String> response) {
                                                                    Log.i("asd",response.body());
                                                                    //{"data":{"face":"2018\/06\/04\/thumb_5b1525b5efd3b.jpg"},"message":"","code":"200"}
                                                                    UploadImgBean  bean2 = new Gson().fromJson(response.body(),UploadImgBean.class);
                                                                    if(bean2.getCode() == 200){
                                                                        CommonApi.getInstance().sub_message(getToken(),mingcheng.getContent(),
                                                                                bean1.getData().getFace(),bean2.getData().getFace(),JiaJuCenterActivity.this,ADD,true);

//                                                switch (type){
//                                                    case 1:
//                                                        CommonApi.getInstance().jiajuedit(getToken(),bean.getData().getFace(),getString(mingcheng),getString(jianjie)
//                                                                ,id,JiaJuCenterActivity.this,ADDD);
//                                                        break;
//                                                    case 2:
//                                                        CommonApi.getInstance().jiajufabu(getToken(), bean.getData().getFace(), getString(mingcheng)
//                                                                , getString(jianjie), JiaJuCenterActivity.this, ADDD);
//                                                        break;
//                                                }
                                                                    }
                                                                }

                                                                @Override
                                                                public void onError(Response<String> response) {
                                                                    super.onError(response);
                                                                    Log.i("asd",response.body());
                                                                }
                                                            });
                                                }
                                            }
                                        }

                                        @Override
                                        public void onError(Response<String> response) {
                                            super.onError(response);
                                            Log.i("asd",response.body());
                                        }
                                    });
                        }





                    }

                break;

             case R.id.back:
                finish();
                break;
            case R.id.edit:
                if(bianji ==true){
//                    xingxiang.setClickable(true);
//                    xingxiang.setFocusable(true);
                    setTrueOrFalse(xingxiang,true);
                    setTrueOrFalse(mingcheng,true);
                    setTrueOrFalse(shangjiajianjie,true);
                    edit.setText("取消");
                    subtitle.setVisibility(View.VISIBLE);
                    subtitle.setText("提交");
                }else {
                    setTrueOrFalse(xingxiang,false);
                    setTrueOrFalse(mingcheng,false);
                    setTrueOrFalse(shangjiajianjie,false);

                    edit.setText("编辑");
                    subtitle.setVisibility(View.INVISIBLE);

                }
                bianji = !bianji;
                break;
        }
    }

    public void setTrueOrFalse(View view,Boolean trueorfalse){
        view.setFocusable(trueorfalse);
        view.setClickable(trueorfalse);
    }

    CommonObjectBean<PersonInfoBean> bean;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                bean = (CommonObjectBean<PersonInfoBean>) base;
                Glide.with(JiaJuCenterActivity.this).
                        load(NetWorkUrl.IMAGEURL+bean.getData().getShop_face()).
                        into(touxing);
                mingcheng.setContent(bean.getData().getShop());
                shangjiajianjie.setContext(bean.getData().getShop_detail());
                zhanghao.setContent(bean.getData().getAccount());
                break;

            case ADD:
                toast(base.getMessage());
                break;
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        shenfenrenzh.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
               // toast("sdfasdf");
                Intent  intent = new Intent(JiaJuCenterActivity.this,MeLookShenFenActivity.class);
                intent.putExtra("path",bean.getData().getCard_img());
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
        yingyezhizhao.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(JiaJuCenterActivity.this,MeLookShenFenActivity.class);
                intent.putExtra("path",bean.getData().getLicense());
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });

        xingxiang.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(JiaJuCenterActivity.this,MeLookShenFenActivity.class);
              //  intent.putExtra("path","");
                intent.putExtra("path",bean.getData().getShop_img());
                intent.putExtra("type",3);
                startActivityForResult(intent,100);
            }
        });
    }

    String xingx ="";
    ArrayList<String> photos;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:
                // TODO: 2018/6/5 0005 可能不用xuanze
                xingx = data.getStringExtra("file");
                break;
        }

        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                Glide.with(JiaJuCenterActivity.this).load(FilesUtil.getSmallBitmap(JiaJuCenterActivity.this, photos.get(0))).into(touxing);

                }
            }
    }
}
