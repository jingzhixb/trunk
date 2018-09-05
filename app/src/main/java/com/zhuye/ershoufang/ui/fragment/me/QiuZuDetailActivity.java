package com.zhuye.ershoufang.ui.fragment.me;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.FangZiBean;
import com.zhuye.ershoufang.bean.MaiChuBean;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QiuZuDetailActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.xiaoqu)
    TextView xiaoqu;
    @BindView(R.id.mianji)
    TextView mianji;
    @BindView(R.id.huxing)
    TextView huxing;
    @BindView(R.id.shoujia)
    TextView shoujia;
    @BindView(R.id.louceng)
    TextView louceng;
    @BindView(R.id.zhuangxiu)
    TextView zhuangxiu;
    @BindView(R.id.fukuan)
    TextView fukuan;
    @BindView(R.id.chuzu)
    TextView chuzu;
    @BindView(R.id.zuqi)
    TextView zuqi;

    @Override
    protected int getResId() {
        return R.layout.activity_qiu_zu_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "详情");
        String id = getIntent().getStringExtra("id");
//        CommonApi.getInstance().mall_detail(id, this, INIT);
        CommonApi.getInstance().mall_detail(id,this, INIT);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();

    }


    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case INIT:
                CommonObjectBean<FangZiBean> bean = (CommonObjectBean<FangZiBean>) base;
                setText(xiaoqu, bean.getData().getXiaoqu());
                setText(mianji, bean.getData().getNum1()+"m²");

                setText(huxing, bean.getData().getHuxing());
                setText(shoujia, bean.getData().getNum2()+"元/月");
                setText(louceng, bean.getData().getLouceng());

                setText(zhuangxiu, bean.getData().getSelect1());
                setText(fukuan, bean.getData().getSelect2());
                setText(chuzu, bean.getData().getSelect3());
                setText(zuqi, bean.getData().getSelect4());
                break;
        }
    }
}
