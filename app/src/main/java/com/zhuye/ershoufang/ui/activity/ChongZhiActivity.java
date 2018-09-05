package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MeChongZhiAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.AliPayBean;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.ZhiDingBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.weidtet.MyGridLayoutManager;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ChongZhiActivity extends BaseActivity {


    private static final int GETDATA = 999;
    private static final int CHONGZHI = 1245;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.alipay)
    ImageView alipay;
    @BindView(R.id.alipay2)
    RelativeLayout alipay2;
    @BindView(R.id.weixin)
    ImageView weixin;
    @BindView(R.id.wexinpay2)
    RelativeLayout wexinpay;
    @BindView(R.id.pay)
    Button pay;
    @BindView(R.id.choose1)
    ImageView choose1;
    @BindView(R.id.choose2)
    ImageView choose2;
    private int SDK_PAY_FLAG = 10;

    @Override
    protected int getResId() {
        return R.layout.activity_chong_zhi;
    }




    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("充值");
        subtitle.setText("充值记录");
        adapter = new MeChongZhiAdapter(R.layout.me_chongzhi_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new MyGridLayoutManager(this,3));
    }

    Boolean isalipay = true;

    @OnClick({R.id.back, R.id.subtitle, R.id.alipay2, R.id.wexinpay2, R.id.pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
             case R.id.subtitle:
                Intent intent = new Intent(ChongZhiActivity.this, ChongZhiJilvActivity.class);
                startActivity(intent);
                break;
            case R.id.alipay2:
                isalipay = true;
                hide(choose2);
                show(choose1);
                break;
            case R.id.wexinpay2:
                show(choose2);
                isalipay = false;
                hide(choose1);
                break;
            case R.id.pay:
                if(isalipay){
//                    CommonApi.getInstance().alipayview(getToken(),Integer.parseInt(bean.getData().get(pos).getId()),ChongZhiActivity.this,CHONGZHI,false);

                    OkGo.<String>post(NetWorkUrl.BASE+"index.php/app/alipay/view")
                            .params("token",getToken())
                            .params("id",bean.getData().get(pos).getId())
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    AliPayBean aliPay = null;
                                    try {
                                        aliPay = new Gson().fromJson(response.body(),AliPayBean.class);
                                        if(aliPay.getCode().equals("200")){
                                            AliPayBean finalAliPay = aliPay;
                                            Runnable payRunnable = new Runnable() {
                                                @Override
                                                public void run() {
                                                    PayTask alipay1 = new PayTask(ChongZhiActivity.this);
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
                                }
                            });
                }else {
                    //微信

                }

                break;
        }
    }

    CommonListBean<ZhiDingBean> bean ;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                bean = (CommonListBean<ZhiDingBean>) base;
                bean.getData().get(0).setChoose(true);
                adapter.addData(bean.getData());
                break;
            case CHONGZHI:
               // toast();
                Base base1 = base;


                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().juan(this,GETDATA);
    }

    private int pos = 0;

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (ZhiDingBean bean1: bean.getData()){
                    bean1.setChoose(false);
                }
                bean.getData().get(position).setChoose(true);
                adapter.replaceData(bean.getData());
                pos=position;
            }
        });
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            Log.i("as",msg.obj.toString());

//            AliPayResult payResult = new AliPayResult((Map<String, String>) msg.obj);
//            switch (payResult.getResultStatus()) {
//                case "9000":
////                    GMToastUtil.showToast("支付成功");
//                    break;
//                case "8000":
////                    GMToastUtil.showToast("正在处理中");
//                    break;
//                case "4000":
////                    GMToastUtil.showToast("订单支付失败");
//                    break;
//                case "5000":
////                    GMToastUtil.showToast("重复请求");
//                    break;
//                case "6001":
////                    GMToastUtil.showToast("已取消支付");
//                    break;
//                case "6002":
////                    GMToastUtil.showToast("网络连接出错");
//                    break;
//                case "6004":
////                    GMToastUtil.showToast("正在处理中");
//                    break;
//                default:
////                    GMToastUtil.showToast("支付失败");
//                    break;
//            }
        }
    };


}
