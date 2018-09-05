package com.zhuye.ershoufang.ui.activity.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.JingJiDetailAdapter;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LookFangYuanActivity extends BaseActivity {

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

    @Override
    protected int getResId() {
        return R.layout.activity_look_fang_yuan;
    }
    String id;
    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        JingJiDetailAdapter adapter1 = new JingJiDetailAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(adapter1);
        tablayout.setViewPager(viewpager);
        adapter1.setData(id);
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"房源详情");
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
