package com.zhuye.ershoufang.ui.activity.me;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.ZhuangXiuKanAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.KanBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class MeYiKanActivity extends Common2Activity<KanBean> {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;


    @Override
    protected int getResId() {
        return R.layout.common;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"已查看");

        adapter = new ZhuangXiuKanAdapter(R.layout.kan_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        CommonApi.getInstance().view_log(getToken(),page,this,LIST,true);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();

    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().view_log(getToken(),++page,this,LOADMOREBASE,true);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().view_log(getToken(),1,this,REFRESHBASE,true);
    }
}
