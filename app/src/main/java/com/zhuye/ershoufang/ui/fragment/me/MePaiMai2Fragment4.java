package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MyPaiMaiItemAdapterliu;
import com.zhuye.ershoufang.bean.MybidderBean;
import com.zhuye.ershoufang.ui.activity.me.AddPaiMaiActivity;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MePaiMai2Fragment4 extends MePaiMai2Fragment<MybidderBean> {

    @Override
    protected int getType() {
        return 4;
    }


    @Override
    protected void initView() {
        adapte = new MyPaiMaiItemAdapterliu(R.layout.me_paimai_item3);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.bianji:
                        Intent intent = new Intent(getActivity(), AddPaiMaiActivity.class);
                        intent.putExtra("type","1");
                        intent.putExtra("id",list.get(position).getId());
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    protected String getPaiId(int position) {
        return list.get(position).getId();
    }
}
