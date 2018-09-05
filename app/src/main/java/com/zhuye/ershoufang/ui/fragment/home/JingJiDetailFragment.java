package com.zhuye.ershoufang.ui.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.JingjiDtailAdapter2;
import com.zhuye.ershoufang.adapter.home.JingjiDtailAdapter3;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.JingJiDetailBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.JingJiRen2DetailActivity;
import com.zhuye.ershoufang.ui.fragment.Common2Fragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class JingJiDetailFragment extends Common2Fragment<JingJiDetailBean.MallBean> {
    private static final int GETDATA1 = 78745;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;

    @Override
    protected void initView() {
        adapte = new JingjiDtailAdapter2(R.layout.home_xinfang_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }


    public void setData(List<JingJiDetailBean.MallBean> data){
        adapte.addData(data);
    }

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

    }

    @Override
    protected void onRefresh() {

    }

    CommonObjectBean<JingJiDetailBean>  bean;
    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case GETDATA1:
                 bean = (CommonObjectBean<JingJiDetailBean>) o;
                handleData();
                break;
        }
    }

    protected void handleData() {

    }

    public void setData2(String id) {
      CommonApi.getInstance().agent_detail(id, JingJiDetailFragment.this, GETDATA1, false);
    }
}
