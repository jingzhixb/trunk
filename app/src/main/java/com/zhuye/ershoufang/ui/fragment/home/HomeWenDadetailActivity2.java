package com.zhuye.ershoufang.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.WenDaAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.AnswerBean;
import com.zhuye.ershoufang.bean.AnswerBean2;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.WenDadetailBean;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeWenDadetailActivity2 extends BaseActivity {

    private static final int GETDATA = 7894;
    private static final int SHUAXIN = 7847;
    private static final int LODD = 7845;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.xiangqing)
    TextView xiangqing;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.content)
    RecyclerView content;
    @BindView(R.id.huida)
    Button huida;
    @BindView(R.id.refreshlayout)
    SmartRefreshLayout refreshlayout;
    @BindView(R.id.xiangqing2)
    TextView xiangqing2;

    @Override
    protected int getResId() {
        return R.layout.activity_home_wen_dadetail;
    }

    String id;

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "问答详情");

        id = getIntent().getStringExtra("id");

        if (id != null && !TextUtils.isEmpty(id)) {


        }

        refreshlayout.setEnableRefresh(false);

        wenDaAdapter = new WenDaAdapter(R.layout.wenda_item2);
        content.setAdapter(wenDaAdapter);
        content.setLayoutManager(new LinearLayoutManager(this));

    }

    WenDaAdapter wenDaAdapter;


    @Override
    protected void onResume() {
        super.onResume();
        CommonApi.getInstance().questiondetail(Integer.parseInt(id), this, GETDATA);
    }

    CommonObjectBean<WenDadetailBean> bean;

    CommonObjectBean<AnswerBean<AnswerBean2>> data;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case GETDATA:
                bean = (CommonObjectBean<WenDadetailBean>) base;
                xiangqing.setText(bean.getData().getQuestion());
                xiangqing2.setText(bean.getData().getIntro());
                time.setText(bean.getData().getCreate_time());
                wenDaAdapter.replaceData(bean.getData().getAnswer());
                break;

            case SHUAXIN:
                data = (CommonObjectBean<AnswerBean<AnswerBean2>>) base;
                break;

            case LODD:
                data = (CommonObjectBean<AnswerBean<AnswerBean2>>) base;

                break;
        }
    }

    @OnClick({R.id.back, R.id.huida})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.huida:
                Intent in = new Intent(HomeWenDadetailActivity2.this, HuiDaActivity.class);
                in.putExtra("id", bean.getData().getId());
                in.putExtra("in", bean.getData().getIntro());
                startActivity(in);
                break;
        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        refreshlayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                CommonApi.getInstance().answer(Integer.parseInt(id), page, HomeWenDadetailActivity2.this, LODD, true);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                CommonApi.getInstance().answer(Integer.parseInt(id), 1, HomeWenDadetailActivity2.this, SHUAXIN, true);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}