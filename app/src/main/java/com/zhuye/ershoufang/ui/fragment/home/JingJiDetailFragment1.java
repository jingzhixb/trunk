package com.zhuye.ershoufang.ui.fragment.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangActivity;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangDetailActivity;

import butterknife.BindView;
import butterknife.Unbinder;

public class JingJiDetailFragment1 extends JingJiDetailFragment {


//    String id ;
//    @Override
//    public void setData2(String id) {
//        super.setData2(id);
//        this.id = id;
//        CommonApi.getInstance().xiala(id,"1",page,JingJiDetailFragment1.this,LIST,false);
//    }
//
//    @Override
//    protected void onRefresh() {
//        super.onRefresh();
//        CommonApi.getInstance().xiala(id,"1",1,JingJiDetailFragment1.this,REFRESHBASE,false);
//    }
//
//    @Override
//    protected void onLoadmore() {
//        super.onLoadmore();
//        CommonApi.getInstance().xiala(id,"1",++page,JingJiDetailFragment1.this,LOADMOREBASE,false);
//    }

    @Override
    protected void handleData() {
        super.handleData();
        if(bean!=null &&bean.getData().getMall()!=null&&bean.getData().getMall().size()>0){
            adapte.replaceData(bean.getData().getMall());
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), ErShouFangDetailActivity.class);
                intent.putExtra("id",bean.getData().getMall().get(position).getLife_id());
                startActivity(intent);
            }
        });
    }
}
