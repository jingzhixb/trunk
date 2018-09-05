package com.zhuye.ershoufang.ui.fragment.tuijian;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TuiJianViewAdapter2;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.bean.SelectBean2;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangDetailActivity;
import com.zhuye.ershoufang.ui.fragment.TuiJianViewFragment;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class TuiJianViewFragment2 extends TuiJianViewFragment<Common3Bean> {

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().index("3",getQuId(),page,business_id,prce1,prce2,select1,yonghu,"","1",
                TuiJianViewFragment2.this,LIST,false);
    }

    @Override
    protected void getClickPrice(String prce1, String prce2) {
        CommonApi.getInstance().index("3",getQuId(),page,business_id,prce1,prce2,select1,yonghu,"","1",
                TuiJianViewFragment2.this,LIST,false);
    }

    @Override
    protected void clickhuxing(View view) {
        dat.clear();
        if(selectBean2CommonListBean!=null&&selectBean2CommonListBean.getData()!=null){
            for (SelectBean2 selectBean2: selectBean2CommonListBean.getData()){
                dat.add(selectBean2.getAttr_name());
            }
            alertWindow(view, dat, 11);
        }
    }

    @Override
    protected void shuaxin(int position) {

        select1 = selectBean2CommonListBean.getData().get(position).getAttr_id();
        CommonApi.getInstance().index("3",getQuId(),1,business_id,prce1,prce2,select1,yonghu,"","1",
                TuiJianViewFragment2.this,LIST,false);
    }


    @Override
    protected void initView() {
        adapte = new TuiJianViewAdapter2(R.layout.home_xinfang_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        leixingtv.setText("户型");
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().index("3",getQuId(),++page,business_id,prce1,prce2,select1,yonghu,"","1",
                TuiJianViewFragment2.this,LOADMOREBASE,true);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().index("3",getQuId(),1,business_id,prce1,prce2,select1,yonghu,"","1",
                TuiJianViewFragment2.this,REFRESHBASE,true);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), ErShouFangDetailActivity.class);
                intent.putExtra("id",list.get(position).getLife_id());
                startActivity(intent);
            }
        });
    }
}
