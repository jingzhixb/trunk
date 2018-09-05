package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.LouPanBeans;
import com.zhuye.ershoufang.bean.MianBean;
import com.zhuye.ershoufang.bean.UploadImgBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.FilesUtil;
import com.zhuye.ershoufang.weidtet.DataBean;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyLinTv2View;
import com.zhuye.ershoufang.weidtet.MySelectTvView;
import com.zhuye.ershoufang.weidtet.MyTvSelectView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class AddMianFeiKanActivity extends BaseActivity {

    private static final int GETDATA = 605;
    private static final int FABU = 606;
    private static final int GETDATA1 = 607;
    private static final int EDIT = 608;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.title)
    MyInputView title;
    @BindView(R.id.youshi)
    MySelectTvView youshi;
    @BindView(R.id.suozailoupan)
    MyTvSelectView suozailoupan;
    @BindView(R.id.rexian)
    MyInputView rexian;
    @BindView(R.id.youhui)
    MyInputView youhui;
    @BindView(R.id.kaishishijian)
    MyInputView kaishishijian;
    @BindView(R.id.huodongguize)
    MyLinTv2View huodongguize;
    @BindView(R.id.mianze)
    MyLinTv2View mianze;
    @BindView(R.id.dizhi)
    MyLinTv2View dizhi;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.loupanleixing)
    MySelectTvView loupanleixing;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.arrow)
    ImageView arrow;
    @BindView(R.id.canyugo)
    RelativeLayout canyugo;
    @BindView(R.id.tou)
    ImageView tou;
//    @BindView(R.id.my)
//    MyDongTaiView my;


    @Override
    protected int getResId() {
        return R.layout.activity_add_mian_fei_kan;
    }

    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "新增发布");
        hide(subtitle);
    }
    ArrayList<String> photos;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                Glide.with(AddMianFeiKanActivity.this).load(FilesUtil.getSmallBitmap(AddMianFeiKanActivity.this, photos.get(0))).into(tou);
                }
        }
    }

    @OnClick({R.id.back, R.id.ttitle, R.id.fabu, R.id.canyugo,R.id.tou})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tou:
                PhotoPicker.builder()
                        .setPhotoCount(1)
                        .setShowCamera(true)
                        .setShowGif(true)
                        .setPreviewEnabled(false)
                        .start(this, PhotoPicker.REQUEST_CODE);
                break;
            case R.id.canyugo:
                start(LookCanYuActivity.class);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.ttitle:
                //my.addView(1);
                break;

            case R.id.fabu:
                if (title.getString() && youshi.hasPhoto() &&
                        suozailoupan.isChange() &&
                        rexian.getString() &&
                        youhui.getString() &&
                        kaishishijian.getString() &&
                        huodongguize.getString() &&
                        mianze.getString() &&
                        dizhi.getString()) {

                    if (type.equals("1")) {
                        if(photos==null|| photos.size()<1 ){
                            toast("请选择图片");
                            return;
                        }else {
                            OkGo.<String>post(NetWorkUrl.BASE+"index.php/App/index/upimg")
//                    .params("","")
                                    .params("file",FilesUtil.getSmallBitmap(
                                            AddMianFeiKanActivity.this, photos.get(0)))
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onError(Response<String> response) {
                                            super.onError(response);
                                        }
                                        @Override
                                        public void onSuccess(Response<String> response) {
                                            UploadImgBean bean1 = new Gson().fromJson(response.body(),UploadImgBean.class);
                                            if(bean1.getCode() == 200){
                                                CommonApi.getInstance().view_fabu(getToken(), suozailoupan.getId() + "", bean1.getData().getFace(),
                                                        title.getContent(), youshi.getPhoto(), loupanleixing.getPhoto(), rexian.getContent(), kaishishijian.getContent(),
                                                        huodongguize.getContent(), mianze.getContent(), dizhi.getContent(), youhui.getContent(), AddMianFeiKanActivity.this
                                                        , FABU);
//                                                if (type.equals("1")) {
//                                                    CommonApi.getInstance().view_fabu(getToken(), suozailoupan.getId() + "", "",
//                                                            title.getContent(), youshi.getPhoto(), loupanleixing.getPhoto(), rexian.getContent(), kaishishijian.getContent(),
//                                                            huodongguize.getContent(), mianze.getContent(), dizhi.getContent(), youhui.getContent(), AddMianFeiKanActivity.this
//                                                            , FABU);
//                                                } else if (type.equals("2")) {
//                                                    CommonApi.getInstance().view_sub(getToken(), suozailoupan.getId() + "", "",
//                                                            title.getContent(), youshi.getPhoto(), loupanleixing.getPhoto(), rexian.getContent(), kaishishijian.getContent(),
//                                                            huodongguize.getContent(), mianze.getContent(), dizhi.getContent(), youhui.getContent(),
//                                                            id,
//                                                            AddMianFeiKanActivity.this
//                                                            , EDIT);
//                                                }

                                            }
                                        }
                                    });
                        }
                    }else if (type.equals("2")){
                        if(photos==null|| photos.size()<1 ){
                            CommonApi.getInstance().view_sub(getToken(), suozailoupan.getId() + "", bean1.getData().getPhoto(),
                              title.getContent(), youshi.getPhoto(), loupanleixing.getPhoto(), rexian.getContent(),
                                    kaishishijian.getContent()==null?bean1.getData().getStart_time(): kaishishijian.getContent(),
                                 huodongguize.getContent(), mianze.getContent(), dizhi.getContent(), youhui.getContent(),
                                                            id,
                                                            AddMianFeiKanActivity.this
                                                            , EDIT);
                        }else {

                            // TODO: 2018/6/5 0005 编辑失败
                            OkGo.<String>post(NetWorkUrl.BASE+"index.php/App/index/upimg")
//                    .params("","")
                                    .params("file",FilesUtil.getSmallBitmap(
                                            AddMianFeiKanActivity.this, photos.get(0)))
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(Response<String> response) {
                                            UploadImgBean bean11 = new Gson().fromJson(response.body(),UploadImgBean.class);
                                            if(bean11.getCode() == 200){
                                                CommonApi.getInstance().view_sub(getToken(),
                                                        suozailoupan.getId() + "",
                                                        bean11.getData().getFace(),
                                                        title.getContent(), youshi.getPhoto(), loupanleixing.getPhoto(), rexian.getContent(),
                                                        kaishishijian.getContent()==null?bean1.getData().getStart_time(): kaishishijian.getContent(),
                                                        huodongguize.getContent(), mianze.getContent(), dizhi.getContent(), youhui.getContent(),
                                                        id,
                                                        AddMianFeiKanActivity.this
                                                        , EDIT);
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
                break;
        }
    }

    String id;
    String type;

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().view_loupan(getToken(), AddMianFeiKanActivity.this, GETDATA);

        type = getIntent().getStringExtra("type");
        if (type.equals("2")) {
            id = getIntent().getStringExtra("id");
            canyugo.setVisibility(View.VISIBLE);
            CommonApi.getInstance().hview_view(getToken(), id, this, GETDATA1);
            setText(ttitle, "看房编辑");
        }
    }

    CommonListBean<LouPanBeans> bean;
    CommonObjectBean<MianBean> bean1;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {

            case EDIT:

                toast(base.getMessage());
                break;

            case GETDATA1:
                bean1 = (CommonObjectBean<MianBean>) base;
                // TODO: 2018/5/16 0016 设置数据
                title.setContent(bean1.getData().getTitle());
                rexian.setContent(bean1.getData().getMobile());
                youhui.setContent(bean1.getData().getYouhui());
                huodongguize.setContext(bean1.getData().getGuize());
                mianze.setContext(bean1.getData().getSm());
                dizhi.setContext(bean1.getData().getAddr());
                number.setText(bean1.getData().getCount());
                Glide.with(AddMianFeiKanActivity.this).load(NetWorkUrl.IMAGEURL+bean1.getData().getPhoto()).into(tou);

                kaishishijian.setContent(bean1.getData().getStart_time());
                youshi.setPhoto(bean1.getData().getYoulie());
                loupanleixing.setPhoto(bean1.getData().getLeixing());

                // TODO: 2018/6/5 0005 参与人设置
                break;

            case GETDATA:
                bean = (CommonListBean<LouPanBeans>) base;
                if (bean.getData() == null || bean.getData().size() == 0) {
                    toast("请先添加楼盘");
                    return;
                }
                // TODO: 2018/5/14 0014  将title 转化为name
                List<DataBean> data = new ArrayList<>();
                for (int i = 0; i < bean.data.size(); i++) {
                    data.add(new DataBean(Integer.parseInt(bean.data.get(i).getId()), bean.data.get(i).getTitle()));
                }
                suozailoupan.setData(data);
                break;

            case FABU:
                toast(base.getMessage());

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
