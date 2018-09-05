package com.zhuye.ershoufang.ui.activity.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.GongChangAdapter2;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GongYechangFangActivity2 extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.tablayout)
    SmartTabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.refresh)
    LinearLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.activity_gong_yechang_fang3;
    }


    @Override
    protected void initData() {
        super.initData();
        GongChangAdapter2 changAdapter2 = new GongChangAdapter2(getSupportFragmentManager(),this);
        viewpager.setAdapter(changAdapter2);
        tablayout.setViewPager(viewpager);
    }

    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("工业厂房");
        subtitle.setVisibility(View.GONE);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
