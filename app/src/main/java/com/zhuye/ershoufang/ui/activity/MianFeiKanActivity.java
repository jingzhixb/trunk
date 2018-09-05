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
import com.zhuye.ershoufang.adapter.me.MianFeiKanAdapter;
import com.zhuye.ershoufang.bean.AliPayBean;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.MeKanFangBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;
import com.zhuye.ershoufang.ui.activity.me.AddMianFeiKanActivity;
import com.zhuye.ershoufang.ui.activity.me.EditMianFeiActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class MianFeiKanActivity extends Common2Activity<MeKanFangBean> {


    private static final int SDK_PAY_FLAG = 9784;
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
        return R.layout.activity_mian_fei_kan;
    }

    @Override
    protected void initView() {
        super.initView();
        // todo
        adapter = new MianFeiKanAdapter(R.layout.me_mianfeikan_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
        setText(ttitle,"免费看房");
        hide(subtitle);
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);

    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().mianview_list(getToken(),page,MianFeiKanActivity.this,LIST);
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

    }

    @OnClick({R.id.back, R.id.xinzeng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.xinzeng:
//                start(AddMianFeiKanActivity.class);
                Intent intent = new Intent(MianFeiKanActivity.this,AddMianFeiKanActivity.class);
                intent.putExtra("type","1");
//                intent.putExtra("id",list.get(position).getId());
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
        CommonApi.getInstance().mianview_list(getToken(),++page,MianFeiKanActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().mianview_list(getToken(),1,MianFeiKanActivity.this,REFRESHBASE);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.zhiding:
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
                                                        PayTask alipay1 = new PayTask(MianFeiKanActivity.this);
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
//                        start(EditMianFeiActivity.class);
//                        Intent intent = new Intent(MianFeiKanActivity.this,EditMianFeiActivity.class);
                        Intent intent = new Intent(MianFeiKanActivity.this,AddMianFeiKanActivity.class);
                        intent.putExtra("type","2");
                        intent.putExtra("id",list.get(position).getId());
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
