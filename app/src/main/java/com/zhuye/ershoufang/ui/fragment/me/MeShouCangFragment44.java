package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.XieZiLoushouAdapter;
import com.zhuye.ershoufang.adapter.me.ZuFangshouAdapter;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.ChuShouActivity;
import com.zhuye.ershoufang.ui.activity.home.XinPanDetailActivity;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MeShouCangFragment44 extends CommonFragment<Common3Bean>{
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;
    @Override
    public BaseQuickAdapter getAdapter() {
        return adapte;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().building(getToken(),++page,MeShouCangFragment44.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().building(getToken(),1,MeShouCangFragment44.this,REFRESHBASE);
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().building(getToken(),page,MeShouCangFragment44.this,LIST);
    }

    @Override
    protected void initView() {
        adapte =  new XieZiLoushouAdapter(R.layout.home_xinfang_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), XinPanDetailActivity.class);
                intent.putExtra("id",list.get(position).getLife_id());
                intent.putExtra("cate_id",list.get(position).getCate_id());
                startActivity(intent);
            }
        });
    }
}
