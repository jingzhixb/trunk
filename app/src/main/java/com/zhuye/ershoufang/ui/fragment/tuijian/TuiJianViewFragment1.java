package com.zhuye.ershoufang.ui.fragment.tuijian;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TuiJianViewAdapter;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.XinFangDetailActivity;
import com.zhuye.ershoufang.ui.fragment.TuiJianViewFragment;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class TuiJianViewFragment1 extends TuiJianViewFragment<Common5Bean> {




    private  Integer select=1;
    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prce1,prce2,select,page,"","1",TuiJianViewFragment1.this,LIST);
    }

    @Override
    protected void getClickPrice(String prce1, String prce2) {
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prce1,prce2,select,1,"","1",TuiJianViewFragment1.this,LIST);

    }



    @Override
    protected void clickhuxing(View view) {
        dat.clear();
        dat.add("住宅");
        dat.add("商铺");
        dat.add("写字楼");
        dat.add("工业厂房");
        alertWindow(view, dat, 11);
//        if(selectBean2CommonListBean!=null&&selectBean2CommonListBean.getData()!=null){
//            for (SelectBean2 selectBean2: selectBean2CommonListBean.getData()){
//                dat.add(selectBean2.getAttr_name());
//            }
//            alertWindow(view, dat, 11);
//        }
    }

    @Override
    protected void shuaxin(int position) {
        select = position+1;
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prce1,prce2,select,1,"","1",TuiJianViewFragment1.this,LIST);
    }


    @Override
        protected void initView() {
            adapte = new TuiJianViewAdapter(R.layout.home_xinfang_item);
            recycle.setAdapter(adapte);
            recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
            leixingtv.setText("房型");

    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prce1,prce2,select,++page,"","1",TuiJianViewFragment1.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prce1,prce2,select,1,"","1",TuiJianViewFragment1.this,REFRESHBASE);
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(select==null){
                    return;
                }
                switch (select){
                    case 1:
                        Intent intent = new Intent(getActivity(), XinFangDetailActivity.class);
                        intent.putExtra("id",list.get(position).getId());
                        startActivity(intent);
                        break;
                    case 2:

                        break;

                    case 3:

                        break;
                    case 4:

                        break;
                }

            }
        });
    }
}
