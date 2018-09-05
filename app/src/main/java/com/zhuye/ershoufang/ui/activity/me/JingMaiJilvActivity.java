package com.zhuye.ershoufang.ui.activity.me;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.JiLvAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.BidderDetailBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.CommonHome2Activity;
import com.zhuye.ershoufang.ui.activity.home.CommonHomeActivity;
import com.zhuye.ershoufang.ui.fragment.Common2Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JingMaiJilvActivity extends BaseActivity {

    private static final int GETDATA = 7985;
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

    BidderDetailBean bean;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                bean = (BidderDetailBean) base;
                if(bean.getData().getJingbiao()!=null&&bean.getData().getJingbiao().size()>0){
                    bean.getData().getJingbiao().get(0).setQubie(true);
                    adapter.addData(bean.getData().getJingbiao());
                }
                break;
        }
    }

    @Override
    protected int getResId() {
        return R.layout.common;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"记录");
    }

    String id;
    @Override
    protected void initData() {
        super.initData();
        adapter = new JiLvAdapter(R.layout.jilv_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        View header = LayoutInflater.from(this).inflate(R.layout.jilv_header,null);
        adapter.addHeaderView(header);
        id = getIntent().getStringExtra("id");
        CommonApi.getInstance().bidder_detail(id, getToken(), this, GETDATA);
    }




    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

}
