package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.Common2Adapter;
import com.zhuye.ershoufang.adapter.home.GangXuAdapter;
import com.zhuye.ershoufang.bean.CommonBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class GangXuActivity extends Common2Activity<CommonBean> {

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
        setText(ttitle,"刚需房");

        adapter = new GangXuAdapter(R.layout.gangxu_item);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().activity(getQuId(),
                2,page,GangXuActivity.this
         ,LIST);
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
        CommonApi.getInstance().activity(getQuId(),
                2,++page,GangXuActivity.this
                ,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().activity(getQuId(),
                2,1,GangXuActivity.this
                ,REFRESHBASE);
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(GangXuActivity.this, XinFangDetailActivity.class);
                intent.putExtra("id",list.get(position).getId()+"");
                startActivity(intent);
            }
        });
    }
}
