package com.zhuye.ershoufang.ui.fragment.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangDetailActivity;

import butterknife.BindView;
import butterknife.Unbinder;

public class JingJiDetailFragment2 extends JingJiDetailFragment {


//    String id ;
//    @Override
//    public void setData2(String id) {
//        super.setData2(id);
//        this.id = id;
//        CommonApi.getInstance().xiala(id,"2",page,JingJiDetailFragment2.this,LIST,false);
//    }
//
//
//    @Override
//    protected void onRefresh() {
//        super.onRefresh();
//        CommonApi.getInstance().xiala(id,"2",1,JingJiDetailFragment2.this,REFRESHBASE,false);
//    }
//
//    @Override
//    protected void onLoadmore() {
//        super.onLoadmore();
//        CommonApi.getInstance().xiala(id,"2",++page,JingJiDetailFragment2.this,LOADMOREBASE,false);
//    }

    @Override
    protected void handleData() {
        super.handleData();
        if(bean!=null &&bean.getData().getZu()!=null&&bean.getData().getZu().size()>0){
            try {
                adapte.replaceData(bean.getData().getZu());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), ErShouFangDetailActivity.class);
                intent.putExtra("id",bean.getData().getZu().get(position).getLife_id());
                startActivity(intent);
            }
        });
    }
}
