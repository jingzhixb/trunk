package com.zhuye.ershoufang.ui.fragment.home;

import android.support.v7.widget.LinearLayoutManager;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ChangFangAdapter;

public class GongChangFarament2 extends CommonGongChFragment {
    @Override
    protected String getCateId() {
        return "8";
    }

    @Override
    protected void initView() {
        adapte = new ChangFangAdapter(R.layout.home_xinfang_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
