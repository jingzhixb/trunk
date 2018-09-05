package com.zhuye.ershoufang.ui.fragment.me;

import android.support.v7.widget.LinearLayoutManager;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MyPaiMaiItemAdapter3;
import com.zhuye.ershoufang.bean.PaiMaiBean;
import com.zhuye.ershoufang.data.CommonApi;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MePaiMai1Fragment3 extends MePaiMai1Fragment<PaiMaiBean> {

    @Override
    protected String getPaiId(int position) {
        return list.get(position).getBidder_id();
    }
    @Override
    protected void initView() {
        //me_maifang_item
        adapte = new MyPaiMaiItemAdapter3(R.layout.me_paimai_item1);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }

    @Override
    protected int getType() {
        return 1;
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().bidder_bond(getToken(),page,MePaiMai1Fragment3.this,LIST);
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().bidder_bond(getToken(),++page,MePaiMai1Fragment3.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().bidder_bond(getToken(),1,MePaiMai1Fragment3.this,REFRESHBASE);
    }
}
