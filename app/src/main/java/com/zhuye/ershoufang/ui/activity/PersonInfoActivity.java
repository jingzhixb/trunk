package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.UploadImgBean;
import com.zhuye.ershoufang.bean.ZiLiaoBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.me.JiaJuCenterActivity;
import com.zhuye.ershoufang.utils.FilesUtil;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class PersonInfoActivity extends BaseActivity {

    private static final int INFO = 100;
    private static final int EDITMESSAGE = 1456;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.touxing)
    RoundedCornerImageView touxing;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.sex)
    EditText sex;
    @BindView(R.id.state)
    TextView state;
    @BindView(R.id.go)
    ImageView go;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.edit)
    Button edit;

    @Override
    protected int getResId() {
        return R.layout.activity_person_info;
    }


    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "个人资料");
        setText(subtitle, "提交");
//        hide(subtitle);
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().ziliao(SharedPreferencesUtil.getInstance().getString("token2"), this, INFO,true);
    }

    private Boolean wancheng = false;

    private Boolean canedit =  true;
    public void setTrueOrFalse(View view,Boolean trueorfalse){
        view.setFocusable(trueorfalse);
        view.setClickable(trueorfalse);
    }
    @OnClick({R.id.touxing,R.id.back, R.id.subtitle, R.id.go,R.id.edit})
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
                case R.id.edit:
//                if(canedit ==true){
////                    xingxiang.setClickable(true);
////                    xingxiang.setFocusable(true);
//                    setTrueOrFalse(name,true);
//                    setTrueOrFalse(sex,true);
////                    setTrueOrFalse(shangjiajianjie,true);
//                    edit.setText("取消");
//                    subtitle.setVisibility(View.VISIBLE);
//                    subtitle.setText("提交");
//                }else {
//                    setTrueOrFalse(name,false);
//                    setTrueOrFalse(sex,false);
////                    setTrueOrFalse(shangjiajianjie,false);
//
//                    edit.setText("编辑");
//                    subtitle.setVisibility(View.INVISIBLE);
//
//                }
//                canedit = !canedit;
                break;
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                //start(EditInfoActivity.class);
                // 提交数据


                if(!TextUtils.isEmpty(getString(name))){
                    if(!TextUtils.isEmpty(getString(sex))){

                        if (getString(sex).equals("女")){
                            sss = 2;
                        }else {
                            sss = 1;
                        }
                        if(photos==null|| TextUtils.isEmpty(photos.get(0))){
                            // 没有提交信息

                            CommonApi.getInstance().edit_zl(getToken(),getString(name),bean.getData().getFace(),
                                    sss,PersonInfoActivity.this,EDITMESSAGE);
                        }else {

                            OkGo.<String>post(NetWorkUrl.BASE+"index.php/App/index/upimg")
//                    .params("","")
                                    .params("file",FilesUtil.getSmallBitmap(
                                            PersonInfoActivity.this, photos.get(0))).execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    UploadImgBean bean2 = new Gson().fromJson(response.body(),UploadImgBean.class);
                                    if(bean2.getCode() == 200){
                                        CommonApi.getInstance().edit_zl(getToken(),getString(name),bean2.getData().getFace(),
                                                sss,PersonInfoActivity.this,EDITMESSAGE);
                                    }
                                }

                                @Override
                                public void onError(Response<String> response) {
                                    super.onError(response);
                                }
                            });



                        }

                    }else {
                        toast("请输入性别");
                    }
                }else {
                    toast("请输入姓名");
                }

//                wancheng = !wancheng;
//                if (wancheng) {
//
//
//                } else {
//
//                }
                break;
            case R.id.go:
                start(BangDingActivity.class);
                break;
        }
    }

    int sss = 1;
    ArrayList<String> photos;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode){
//            case 100:
//                // TODO: 2018/6/5 0005 可能不用xuanze
//                xingx = data.getStringExtra("file");
//                break;
//        }

        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                Glide.with(PersonInfoActivity.this).load(FilesUtil.getSmallBitmap(PersonInfoActivity.this, photos.get(0))).into(touxing);

            }
        }
    }
    ZiLiaoBean bean;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case EDITMESSAGE:
                toast(base.getMessage());
                break;
                case INFO:
              bean  = (ZiLiaoBean) base;
                name.setText(bean.getData().getNickname());
                // String se = "男";
                setText(sex, bean.getData().getSex().equals("1") ? "男" : "女");
                setText(state, bean.getData().getSex().equals("1") ? "已绑定" : "未绑定");
                if(bean.getData().getFace().startsWith("http")){
                    Glide.with(PersonInfoActivity.this).load(bean.getData().getFace()).into(touxing);
                }else {
                    Glide.with(PersonInfoActivity.this).load(NetWorkUrl.IMAGEURL +bean.getData().getFace()).into(touxing);
                }
                break;
        }
    }
}
