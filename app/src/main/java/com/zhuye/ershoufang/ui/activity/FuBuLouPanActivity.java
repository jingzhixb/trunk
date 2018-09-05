package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.FaBuLouPanAdapter;
import com.zhuye.ershoufang.bean.AliPayBean;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.LouPanBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.CommonApiService;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;
import com.zhuye.ershoufang.ui.activity.home.EditLouPanActivity;
import com.zhuye.ershoufang.ui.activity.me.AddLouPanActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class FuBuLouPanActivity extends Common2Activity<LouPanBean> {


    private static final int ZHIDING = 789;
    private static final int SDK_PAY_FLAG = 79845;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.xinzeng)
    Button xinzeng;

    @Override
    protected int getResId() {
        return R.layout.activity_fu_bu_lou_pan;
    }

    @Override
    protected void initView() {
        super.initView();
        subtitle.setVisibility(View.INVISIBLE);
        ttitle.setText("发布楼盘");
        adapter = new FaBuLouPanAdapter(R.layout.me_fabuloupan_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
        CommonApi.getInstance().newhouse_list(getToken(),page,FuBuLouPanActivity.this,LIST);
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case ZHIDING:
                ///toast();
                break;
        }
    }

    @OnClick({R.id.back, R.id.xinzeng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.xinzeng:
//                start(AddLouPanActivity.class);
                Intent intent = new Intent(FuBuLouPanActivity.this, AddLouPanActivity.class);
//                intent.putExtra("id",list.get(position).getId());
                intent.putExtra("type","1");
                startActivity(intent);
                break;
        }
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().newhouse_list(getToken(),++page,FuBuLouPanActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().newhouse_list(getToken(),1,FuBuLouPanActivity.this,REFRESHBASE);
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.zhiding:
                       // CommonApi.getInstance().zhiding(getToken(),Integer.parseInt(list.get(position).getId()),FuBuLouPanActivity.this,ZHIDING,true);
                        OkGo.<String>post(NetWorkUrl.BASE+"index.php/app/alipay/zhiding")
                                .params("token",getToken())
                                .params("life_id",list.get(position).getId())
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        Log.i("as",response.body());


                                        AliPayBean aliPay = null;
                                        try {
                                            aliPay = new Gson().fromJson(response.body(),AliPayBean.class);
                                            if(aliPay.getCode().equals("200")){
                                                AliPayBean finalAliPay = aliPay;
                                                Runnable payRunnable = new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        PayTask alipay1 = new PayTask(FuBuLouPanActivity.this);
                                                        Map<String, String> result = alipay1.payV2
                                                                (finalAliPay.getData(), true);//这里的orderInfo就是上面说的orderInfo
                                                        Message msg = new Message();
                                                        msg.what = SDK_PAY_FLAG;
                                                        msg.obj = result;
                                                        mHandler.sendMessage(msg);
                                                    }
                                                };

                                                Thread payThread = new Thread(payRunnable);
                                                payThread.start();
                                            }else {
                                                toast(aliPay.getMessage());
                                            }
                                        } catch (JsonSyntaxException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onError(Response<String> response) {
                                        super.onError(response);
                                        Log.i("as",response.body());
                                    }
                                });
                        break;
                    case R.id.edit:
//                        Intent intent = new Intent(FuBuLouPanActivity.this, EditLouPanActivity.class);
                        Intent intent = new Intent(FuBuLouPanActivity.this, AddLouPanActivity.class);
                        intent.putExtra("id",list.get(position).getId());
                        intent.putExtra("type","2");
                        startActivity(intent);
                        break;
                }
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }
}
