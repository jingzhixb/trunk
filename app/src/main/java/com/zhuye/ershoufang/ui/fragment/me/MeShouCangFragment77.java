package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ZhuangXiuAdapter;
import com.zhuye.ershoufang.bean.ZhuangxiuJiaJuBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.ZhuangXiuDetailActivity;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MeShouCangFragment77 extends CommonFragment<ZhuangxiuJiaJuBean>{
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
        CommonApi.getInstance().shop_collect(getToken(),++page,3,MeShouCangFragment77.this, LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().shop_collect(getToken(),1,3,MeShouCangFragment77.this, REFRESHBASE);
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().shop_collect(getToken(),page,3,MeShouCangFragment77.this, LIST);
    }

    @Override
    protected void initView() {
        adapte = new ZhuangXiuAdapter(R.layout.zhuangxiu_item);
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
                Intent intent = new Intent(getActivity(),ZhuangXiuDetailActivity.class);
                intent.putExtra("id",list.get(position).getShop_id());
                intent.putExtra("type","2");
                startActivity(intent);
            }
        });

    }
}
