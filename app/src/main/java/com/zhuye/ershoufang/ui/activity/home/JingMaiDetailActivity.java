package com.zhuye.ershoufang.ui.activity.home;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.data.CommonApi;

public class JingMaiDetailActivity extends BaseActivity {

    private static final int GETDATA = 1545;

    @Override
    protected int getResId() {
        return R.layout.activity_jing_mai_detail;
    }


    String id;
    @Override
    protected void initData() {
        super.initData();
        //Integer posi =  getTData(1);
        id = getIntent().getStringExtra("id");

        CommonApi.getInstance().bidder_detail(id,getToken(),JingMaiDetailActivity.this,GETDATA);

    }


}
