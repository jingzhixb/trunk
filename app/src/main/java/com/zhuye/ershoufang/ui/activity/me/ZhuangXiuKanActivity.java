package com.zhuye.ershoufang.ui.activity.me;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.ZhuangXiuKanAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.AliPayBean;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.KanBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ZhuangXiuKanActivity extends Common2Activity<KanBean> {


    private static final int KAN = 784;
    private static final int SDK_PAY_FLAG = 78412;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.common;
    }


    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case KAN:
                
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "查看记录");
        setText(subtitle, "已查看");


        CommonApi.getInstance().zx_view(getToken(),page,this,LIST,true);
    }

    @Override
    protected void initData() {
        super.initData();
        adapter = new ZhuangXiuKanAdapter(R.layout.kan_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        //// TODO: 2018/6/5 0005 查看记录
    }

    @OnClick({R.id.back, R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                start(MeYiKanActivity.class);
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
        CommonApi.getInstance().zx_view(getToken(),++page,this,LOADMOREBASE,true);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().zx_view(getToken(),page,this,REFRESHBASE,true);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.dian1:
//                        CommonApi.getInstance().alipayview(getToken(),Integer.parseInt(list.get(position).getId()),ZhuangXiuKanActivity.this
//                        ,KAN,true);
//                        CommonApi.getInstance().

                        OkGo.<String>post(NetWorkUrl.BASE+"index.php/app/alipay/zhiding")
                                .params("token",getToken())
                                .params("id",list.get(position).getId())
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
                                                        PayTask alipay1 = new PayTask(ZhuangXiuKanActivity.this);
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
                }
            }
        });
    }
}
