package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ImageAdapter;
import com.zhuye.ershoufang.adapter.home.JingMaijiLeAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.AliPayBean;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.BidderDetailBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.pay.PayResult;
import com.zhuye.ershoufang.ui.activity.LoginActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

public class PaiMaiDetailActivity extends BaseActivity {

    private static final int GETDATA = 15487;
    private static final int TIXINGBA = 78454;
    private static final int BAOMINGBA = 7879844;
    private static final int JIAOQIAN = 878945;
    private static final int SDK_PAY_FLAG = 784444;

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.qipaiprice)
    TextView qipaiprice;
    @BindView(R.id.tv12)
    TextView tv12;
    @BindView(R.id.kaipaishijian)
    TextView kaipaishijian;
    @BindView(R.id.baoming)
    TextView baoming;
    @BindView(R.id.tixing)
    TextView tixing;
    @BindView(R.id.weiguan)
    TextView weiguan;
    @BindView(R.id.gongsi)
    TextView gongsi;
    @BindView(R.id.zhuying)
    TextView zhuying;
    @BindView(R.id.mendian)
    TextView mendian;
    @BindView(R.id.go)
    ImageView go;
    @BindView(R.id.qipaijia)
    TextView qipaijia;
    @BindView(R.id.yanshizhouqi)
    TextView yanshizhouqi;
    @BindView(R.id.jingjiaguize)
    TextView jingjiaguize;
    @BindView(R.id.jingpaizhouqi)
    TextView jingpaizhouqi;
    @BindView(R.id.fangwumianji)
    TextView fangwumianji;
    @BindView(R.id.xuzhigo)
    ImageView xuzhigo;
    @BindView(R.id.biaodiwu)
    RecyclerView biaodiwu;
    @BindView(R.id.zuozaidi)
    TextView zuozaidi;
    @BindView(R.id.jinamaijilu)
    RecyclerView jinamaijilu;
    @BindView(R.id.jiaobaozhengjin)
    Button jiaobaozhengjin;
    @BindView(R.id.tixingjiao)
    ImageView tixingjiao;
    @BindView(R.id.banner)
    BGABanner banner;
    @BindView(R.id.textt)
    TextView textt;
    @BindView(R.id.mapview)
    MapView mapview;

    @Override
    protected int getResId() {
        return R.layout.activity_pai_mai_detail;
    }


    String id;
    BidderDetailBean bean;

    @Override
    public void success(int requestcode, Base base) {

        super.success(requestcode, base);
        switch (requestcode) {

            case JIAOQIAN:
                Base base1 = base;
                break;
            case BAOMINGBA:
                toast(base.getMessage());
                bean.getData().setBond("1");
                jiaobaozhengjin.setText("已报名加价");
                break;
            case TIXINGBA:
                toast(base.getMessage());
                bean.getData().setTixing("1");
                textt.setText("已设置");
                break;
            case GETDATA:
                bean = (BidderDetailBean) base;
                dizhi.setText(bean.getData().getAddr());

                qipaiprice.setText("￥ " + bean.getData().getDq_money()+"万");
                kaipaishijian.setText(bean.getData().getStart_time());

                baoming.setText(bean.getData().getBm()==null?  "0人报名":bean.getData().getBm()+"人报名");
                tixing.setText(bean.getData().getTx_count()==null?  "0人提醒":bean.getData().getTx_count()+"人提醒");
//                tixing.setText("5人提醒");//  没字段
                weiguan.setText(bean.getData().getWg_count()==null? "0人围观":bean.getData().getWg_count()+"人围观");

                gongsi.setText("￥ " + bean.getData().getBz_money()+"元");
                zhuying.setText("￥ " + bean.getData().getPg_money()+"万元");
                mendian.setText("￥ " + bean.getData().getJia_money()+"元");

                // 竞卖记录

                try {
                    if(bean.getData().getJingbiao()!=null&&bean.getData().getJingbiao().size()>0){
                        bean.getData().getJingbiao().get(0).setQubie(true);
                    }


                    if(bean.getData().getBond().equals("0")){
                          jiaobaozhengjin.setText("未报名缴纳保证金");
                    }  else if(bean.getData().getBond().equals("1")) {
                         jiaobaozhengjin.setText("报名加价");
                    }


                    jingMaijiLeAdapter.addData(bean.getData().getJingbiao());


                    qipaijia.setText("￥ " + bean.getData().getQp_money()+"万元");
                    jingpaizhouqi.setText(bean.getData().getJp_time() + "天");
                    yanshizhouqi.setText(bean.getData().getYs_time() + "分钟");
                    imageAdapter.addData(bean.getData().getPhoto());
                    fangwumianji.setText(bean.getData().getNum1()+"m²");
//                if(bean.getData())
                    LatLng cenpt = new LatLng(Double.parseDouble(bean.getData().getLat()),
                            Double.parseDouble(bean.getData().getLng()));
                    //定义地图状态
                    MapStatus mMapStatus = new MapStatus.Builder()
                            .target(cenpt)
                            .zoom(14)
                            .build();
                    //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
                    MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
                    //改变地图状态
//        mBaiduMap.
//        mBaiduMap.ce
                    mBaiduMap.setMapStatus(mMapStatusUpdate);



                    //  todo
                    banner.setData(Arrays.asList(NetWorkUrl.IMAGEURL + bean.getData().getPhoto().get(0)),
                            Arrays.asList(""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                fangwumianji.setText(bean.getData().get);   房屋面积

//                jingjiaguize.setText(bean.getData().get);  // 竞买规则

                // 标的物



//                for (String photo:bean.getData().getPhoto()){
//
//                }



                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = simpleDateFormat.parse(bean.getData().getStart_time());

//                    SystemClock.

                    if (date.getTime() < new Date().getTime()) {
                        tixingjiao.setVisibility(View.GONE);
                        jiaobaozhengjin.setVisibility(View.GONE);
                    } else {
                        if (bean.getData().getTixing().equals("1")) {
                            textt.setText("已设置");

                        } else {
                            textt.setText("未设置");
                        }
                    }
                    ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //
                // date.getSeconds();
                break;
        }
    }

    JingMaijiLeAdapter jingMaijiLeAdapter;

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "竞卖详情");
        mBaiduMap = mapview.getMap();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapview.onDestroy();
       // mSearch.destroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapview.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapview.onPause();
    }

    private BaiduMap mBaiduMap;

    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        CommonApi.getInstance().bidder_detail(id, getToken(), PaiMaiDetailActivity.this, GETDATA);
        jingMaijiLeAdapter = new JingMaijiLeAdapter(R.layout.jingmaijilv);
        jinamaijilu.setAdapter(jingMaijiLeAdapter);
        jinamaijilu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        imageAdapter = new ImageAdapter(R.layout.images);
        biaodiwu.setAdapter(imageAdapter);
        biaodiwu.setLayoutManager(new GridLayoutManager(this, 2));


        banner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(PaiMaiDetailActivity.this)
                        .load(model)
                        .into(itemView);
            }
        });



    }

    ImageAdapter imageAdapter;

    protected Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SDK_PAY_FLAG:
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    //同步获取结果
                    String resultInfo = payResult.getResult();
                    Log.i("Pay", "Pay:" + resultInfo);
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(PaiMaiDetailActivity.this, "支付成功", Toast.LENGTH_SHORT).show();

                        bean.getData().setBond("1");
                        jiaobaozhengjin.setText("已缴纳保证金参与报名");

//                        if(bean.getData().getBond().equals("0")){
//                            jiaobaozhengjin.setText("未报名缴纳保证金");
//                        }  else if(bean.getData().getBond().equals("1")) {
//                            jiaobaozhengjin.setText("已报名加价");
//                        }

                    } else {
                        Toast.makeText(PaiMaiDetailActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    @OnClick({R.id.back, R.id.go, R.id.xuzhigo, R.id.jiaobaozhengjin, R.id.tixingjiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.go:
                Intent in = new Intent(PaiMaiDetailActivity.this, JingMaiJilvActivity.class);
                in.putExtra("id",id);
                startActivity(in);
                break;
            case R.id.xuzhigo:

//                Intent inn = new Intent(PaiMaiDetailActivity.this, JingMaiXuZhiActivity.class);
////                in.putExtra("")
//                startActivity(inn);
                break;
            case R.id.jiaobaozhengjin:

                if(isNeedLogin()){
                    start(LoginActivity.class);
                    return;
                }

                if (bean.getData().getBond().equals("1")) {
                    //移交  报名加价
                    CommonApi.getInstance().cj_bidder(bean.getData().getId(), getToken(), 1, PaiMaiDetailActivity.this,
                            BAOMINGBA);
                } else {
                    // 未交
//                    CommonApi.getInstance().alipaybond(getToken(),Integer.parseInt(bean.getData().getId()),
//                            PaiMaiDetailActivity.this,JIAOQIAN,true);
                    OkGo.<String>post(NetWorkUrl.BASE + "index.php/app/alipay/bond")
                            .params("token", getToken())
                            .params("bidder_id", Integer.parseInt(bean.getData().getId()))
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    AliPayBean aliPay = null;
                                    try {
                                        aliPay = new Gson().fromJson(response.body(), AliPayBean.class);
                                        if (aliPay.getCode().equals("200")) {
                                            AliPayBean finalAliPay = aliPay;
                                            Runnable payRunnable = new Runnable() {
                                                @Override
                                                public void run() {
                                                    PayTask alipay1 = new PayTask(PaiMaiDetailActivity.this);
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
                                        } else {
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
                }
                break;
            case R.id.tixingjiao:
                if(isNeedLogin()){
                    start(LoginActivity.class);
                    return;
                }

                if (bean.getData().getTixing().equals("0")) {
                    CommonApi.getInstance().remind(bean.getData().getId(), getToken(), PaiMaiDetailActivity.this, TIXINGBA);
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
