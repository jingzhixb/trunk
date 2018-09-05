package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.FangChanBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.ChangeMobile1Activity;
import com.zhuye.ershoufang.weidtet.MyInputView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MeFangChanCenterActivity extends BaseActivity {

    private static final int GETDATA = 999;
    private static final int EDIT = 1238;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.zhanghao)
    MyInputView zhanghao;
    @BindView(R.id.shenfenrenzh)
    MyInputView shenfenrenzh;
    @BindView(R.id.yingyezhizhao)
    MyInputView yingyezhizhao;
    @BindView(R.id.edit)
    Button edit;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.mingcheng)
    MyInputView mingcheng;

    @Override
    protected int getResId() {
        return R.layout.activity_me_fang_chan_center;

    }

    CommonObjectBean<FangChanBean> bean;

    @Override
    protected void initData() {
        super.initData();
        zhanghao.setRightArrow();
        zhanghao.nocanChange();
        CommonApi.getInstance().fangchandata(getToken(), MeFangChanCenterActivity.this, GETDATA);
    }


    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case GETDATA:
                bean = (CommonObjectBean<FangChanBean>) base;
                zhanghao.setContent(bean.getData().getAccount());
                break;
            case EDIT:
                toast(base.getMessage());
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "个人信息");
    }

    public void setTrueOrFalse(View view,Boolean trueorfalse){
        view.setFocusable(trueorfalse);
        view.setClickable(trueorfalse);
    }
    Boolean bianji = true;
    @OnClick({R.id.back, R.id.edit,R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.subtitle:
                if(mingcheng.getString()){
                    CommonApi.getInstance().data_sub(getToken(),mingcheng.getContent(),MeFangChanCenterActivity.this,EDIT,true);
                }
                break;
            case R.id.back:
                finish();
                break;
            case R.id.edit:
                if(bianji ==true){
//                    xingxiang.setClickable(true);
//                    xingxiang.setFocusable(true);
//                    setTrueOrFalse(xingxiang,true);
                    setTrueOrFalse(mingcheng,true);
//                    setTrueOrFalse(shangjiajianjie,true);
                    // TODO: 2018/6/5 0005 切换有问题
                    edit.setText("取消");
                    subtitle.setVisibility(View.VISIBLE);
                    subtitle.setText("提交");
                }else {
//                    setTrueOrFalse(xingxiang,false);
                    setTrueOrFalse(mingcheng,false);
//                    setTrueOrFalse(shangjiajianjie,false);

                    edit.setText("编辑");
                    subtitle.setVisibility(View.INVISIBLE);

                }
                bianji = !bianji;
                break;

        }

    }


    @Override
    protected void initListener() {
        super.initListener();
        zhanghao.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeFangChanCenterActivity.this, ChangeMobile1Activity.class);
                intent.putExtra("mobile", bean.getData().getAccount());
                startActivity(intent);
            }
        });
        shenfenrenzh.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeFangChanCenterActivity.this, MeLookShenFenActivity.class);
                intent.putExtra("path", bean.getData().getCard_img());
                intent.putExtra("type", 1);
                startActivity(intent);
            }
        });
        yingyezhizhao.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeFangChanCenterActivity.this, MeLookShenFenActivity.class);
                intent.putExtra("path", bean.getData().getLicense());
                intent.putExtra("type", 2);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
