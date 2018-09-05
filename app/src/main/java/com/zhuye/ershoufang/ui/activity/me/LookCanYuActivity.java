package com.zhuye.ershoufang.ui.activity.me;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.CanYuAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.CanYnBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LookCanYuActivity extends Common2Activity<CanYnBean> {
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

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_look_can_yu);
//    }

    @Override
    protected int getResId() {
        return R.layout.common;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"参与人");

        adapter = new CanYuAdapter(R.layout.kan_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

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
        CommonApi.getInstance().view_part(getToken(),++page,this,LOADMOREBASE,true);
    }
    @Override
    protected void onRefresh() {
        CommonApi.getInstance().view_part(getToken(),1,this,REFRESHBASE,true);
    }
}
