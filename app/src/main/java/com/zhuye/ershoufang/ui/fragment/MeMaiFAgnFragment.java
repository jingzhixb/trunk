package com.zhuye.ershoufang.ui.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
import com.zhuye.ershoufang.adapter.me.MaiFangItemAdapter;
import com.zhuye.ershoufang.bean.AliPayBean;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.FaBuListBean;
import com.zhuye.ershoufang.bean.FaBuListBean2;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.AddErShouActivity;
import com.zhuye.ershoufang.ui.activity.AddGongChangActivity;
import com.zhuye.ershoufang.ui.activity.AddShangPuActivity;
import com.zhuye.ershoufang.ui.activity.AddXieZiActivity;
import com.zhuye.ershoufang.ui.activity.me.EditErShouActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeMaiFAgnFragment extends Common2Fragment<FaBuListBean2> {
    private static final int DELETE = 201;
    private static final int LOADMORE = 202;
    private static final int SDK_PAY_FLAG = 4874;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;


    MaiFangItemAdapter adapter;
    @BindView(R.id.tvv)
    TextView tvv;
    Unbinder unbinder1;

    @Override
    protected void initView() {
        adapter = new MaiFangItemAdapter(R.layout.me_maifang_item5);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_maifang;
    }


    private int cate_id = 3;

    public void setId(int cate_id) {
        this.cate_id = cate_id;
    }

    public void setData(int position) {
        if(adapter!=null){
            list.clear();
            adapter.replaceData(list);
        }
        CommonApi.getInstance().sellhouselists2(getToken(), 1, cate_id, MeMaiFAgnFragment.this, LIST,false);
      //  tvv.setText(position+"");


//        OkGo.<String>post(NetWorkUrl.BASE+NetWorkUrl.SELLHOUSELISTS)
//                .params("token",getToken())
//                .params("cate_id",3)
//                .params("page",1).execute(new StringCallback() {
//            @Override
//            public void onSuccess(Response<String> response) {
//                Log.i("as",response.body());
//            }
//
//            @Override
//            public void onError(Response<String> response) {
//                super.onError(response);
//                Log.i("as",response.body());
//            }
//        });
    }

    @Override
    protected void initData() {
        super.initData();
    }

    FaBuListBean bean;

    List<FaBuListBean.DataBean>  dataBeans = new ArrayList<>();
    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
//            case LIST:
//                bean = (FaBuListBean) o;
//
//                dataBeans.addAll(bean.getData());
//                adapter.addData(bean.getData());
//                break;
//
            case DELETE:
                toast(o.getMessage());
                onRefresh();
                break;
//            case REFRESH:
//                FaBuListBean faBuListBean = (FaBuListBean) o;
//                dataBeans.clear();
//                dataBeans.addAll(faBuListBean.getData());
//                adapter.replaceData(dataBeans);
//                refresh.finishRefresh();
//                break;
//            case LOADMORE:
//                FaBuListBean faBuListB = (FaBuListBean) o;
//                dataBeans.addAll(faBuListB.getData());
//                adapter.replaceData(dataBeans);
//                refresh.finishLoadmore();
//                break;
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
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.delete:
                        CommonApi.getInstance().del_house(getToken(),Integer.parseInt(list.get(position).getLife_id()),MeMaiFAgnFragment.this,DELETE);
                        break;
                    case R.id.edit:
//                        start(EditErShouActivity.class);
                        if(list==null||list.size()==0){
                            return;
                        }
                        if(list.get(position).getAudit()==1){
                            toast("已审核,无法编辑");
                            return;
                        }

                        switch (cate_id){
                            case 3:
                                //二手房
                                Intent intent = new Intent(getActivity(), AddErShouActivity.class);
                                intent.putExtra("type","2");
                                intent.putExtra("id",list.get(position).getLife_id());
                                startActivity(intent);
                                break;
                            case 6:
                                // 写字楼
                                Intent intent1 = new Intent(getActivity(), AddXieZiActivity.class);
                                intent1.putExtra("type","2");
                                intent1.putExtra("id",list.get(position).getLife_id());
                                startActivity(intent1);
                                break;
                            case 7:
                                //商铺
                                Intent intent2 = new Intent(getActivity(), AddShangPuActivity.class);
                                intent2.putExtra("type","2");
                                intent2.putExtra("id",list.get(position).getLife_id());
                                startActivity(intent2);
                                break;
                            case 8:
                                //工业厂房
                                Intent intent3 = new Intent(getActivity(), AddGongChangActivity.class);
                                intent3.putExtra("type","2");
                                intent3.putExtra("id",list.get(position).getLife_id());
                                startActivity(intent3);
                                break;

                        }

//                        Intent intent = new Intent(getActivity(), EditErShouActivity.class);
//                        intent.putExtra("life_id",list.get(position).getLife_id());
//                        startActivity(intent);
                        break;

                    case R.id.zhiding:
                        OkGo.<String>post(NetWorkUrl.BASE+"index.php/app/alipay/zhiding")
                                .params("token",getToken())
                                .params("life_id",list.get(position).getLife_id())
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
                                                        PayTask alipay1 = new PayTask(getActivity());
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


//        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
//            @Override
//            public void onLoadmore(RefreshLayout refreshlayout) {
//                CommonApi.getInstance().sellhouselists(getToken(),++page , cate_id, MeMaiFAgnFragment.this, LOADMORE);
//            }
//
//            @Override
//            public void onRefresh(RefreshLayout refreshlayout) {
//                CommonApi.getInstance().sellhouselists(getToken(), 1, cate_id, MeMaiFAgnFragment.this, REFRESH);
//            }
//        });
    }

    public static Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().sellhouselists2(getToken(),++page , cate_id, MeMaiFAgnFragment.this, LOADMOREBASE,true);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().sellhouselists2(getToken(), 1, cate_id, MeMaiFAgnFragment.this, REFRESHBASE,true);
    }
}
