package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.XinPanAdapter;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class XinPanActivity extends Common2Activity<Common5Bean> {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.common;
    }

    String cate_id ;

    @Override
    protected void initView() {
        super.initView();
        cate_id = getIntent().getStringExtra("cate_id");
        if(cate_id.equals("2")){
            setText(ttitle,"商铺新盘");
        }else {
            setText(ttitle,"写字楼新盘");
        }
        hide(subtitle);

        adapter = new XinPanAdapter(R.layout.home_xinfang_item3);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }


    protected String business_id = null;
    protected String prices1;
    protected String prices2;
    protected String select1;
    protected  String yonghu;

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent(XinPanActivity.this, XinPanDetailActivity.class);
//                intent.putExtra("id",list.get(position).getId());
//                intent.putExtra("cate_id",cate_id);
//                startActivity(intent);
                // 跳转到新房详情
                Intent intent = new Intent(XinPanActivity.this, XinFangDetailActivity.class);
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
//        CommonApi.getInstance().indexnewhouse2(cate_id,getQuId(),page,business_id,prices1,prices2,select1,yonghu,"",
//                XinPanActivity.this,LIST);
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prices1,prices2,Integer.parseInt(cate_id),page,"",is_recommand,
                XinPanActivity.this,LIST);
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }
   String is_recommand;
    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prices1,prices2,Integer.parseInt(cate_id),++page,"",is_recommand,
                XinPanActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prices1,prices2,Integer.parseInt(cate_id),1,"",is_recommand,
                XinPanActivity.this,REFRESHBASE);
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
