package com.zhuye.ershoufang.ui.activity.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.HomeWendaAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.ui.activity.me.TiWen2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeWenDaActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.tablayout)
    SmartTabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.refresh)
    LinearLayout refresh;
    @BindView(R.id.tiwen)
    Button tiwen;

    @Override
    protected int getResId() {
        return R.layout.activity_home_wen_da;
    }

    HomeWendaAdapter adapter;


    @Override
    protected void onResume() {
        super.onResume();
        adapter.setData(cur);
    }

    @Override
    protected void initView() {
        super.initView();
        adapter = new HomeWendaAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(adapter);
        tablayout.setViewPager(viewpager);

        hide(subtitle);
        hide(ttitle);
    }


    int cur = 0;
    @Override
    protected void initListener() {
        super.initListener();
        tablayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                cur = position;
                adapter.setData(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.tiwen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tiwen:
                start(TiWen2Activity.class);
                break;
        }
    }
}
