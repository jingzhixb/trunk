package com.zhuye.ershoufang.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ChangFangAdapter;
import com.zhuye.ershoufang.adapter.home.ChangFangAdapter2;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.GongYeDetailActivity2;
import com.zhuye.ershoufang.ui.activity.home.GongYechangFangActivity;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class CommonGongChFragment extends CommonFragment<Common3Bean> {
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.footer)
    ClassicsFooter footer;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;



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
        CommonApi.getInstance().plant_list(getCateId(),getQuId(),++page,key,this
                ,LOADMOREBASE);
    }


    String key ;
    @Override
    protected void onRefresh() {
        CommonApi.getInstance().plant_list(getCateId(),getQuId(),1,key,this
                ,REFRESHBASE);

    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().plant_list(getCateId(),getQuId(),page,key,this
                ,LIST);
    }

    protected abstract String getCateId();




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
                String shushou = "1";
                if(getCateId().equals("8")){
                    shushou = "1";
                }else if(getCateId().equals("10")){
                    shushou = "2";
                }
                Intent intent = new Intent(getActivity(), GongYeDetailActivity2.class);
                intent.putExtra("id",list.get(position).getLife_id());
                intent.putExtra("type",shushou);
                startActivity(intent);

            }
        });
    }
}
