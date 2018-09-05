package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.qite.QiTe3Adapter;
import com.zhuye.ershoufang.adapter.me.qite.QiTe3Adapter3;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.QiTeBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.LoginActivity;
import com.zhuye.ershoufang.ui.activity.me.ChuZuDetailActivity;

import butterknife.BindView;
import butterknife.Unbinder;

import static com.zhuye.ershoufang.data.NetWorkUrl.JIEDANCODE;

/**
 * Created by Administrator on 2018/3/19 0019.
 */

public class MeQiTe3Fragment2 extends CommonMeQiTeFragment<QiTeBean> {
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode,o);
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapte;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }


    @Override
    protected void initData() {
        super.initData();
        adapte = new QiTe3Adapter3(R.layout.me_qite_item2);
        recycle.setAdapter(adapte);
        // TODO: 2018/3/23 0023       有bug
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
       // CommonApi.getInstance().qtwt(getToken(),page,4,MeQiTe3Fragment2.this,LIST,false);
        CommonApi.getInstance().phouse(page,getQuId(),"3",MeQiTe3Fragment2.this,LIST,false);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //start(JingMaiDetailActivity.class,position+"");
                Intent intent = new Intent(getActivity(),ChuZuDetailActivity.class);
                intent.putExtra("id",((QiTeBean)list.get(position)).getLife_id());
                startActivity(intent);
            }
        });

        adapte.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if(getToken()==null){
                    start(LoginActivity.class);
                }else {
                    CommonApi.getInstance().jiedan(getToken(),list.get(position).getLife_id(),MeQiTe3Fragment2.this,JIEDANCODE,true);
                }
            }
        });
    }

    @Override
    protected void onLoadmore() {
       // CommonApi.getInstance().qtwt(getToken(),++page,4,MeQiTe3Fragment2.this,LOADMOREBASE,true);
        CommonApi.getInstance().phouse(++page,getQuId(),"3",MeQiTe3Fragment2.this,LOADMOREBASE,true);
    }

    @Override
    protected void onRefresh() {
      //  CommonApi.getInstance().qtwt(getToken(),1,4,MeQiTe3Fragment2.this,REFRESHBASE,true);
        CommonApi.getInstance().phouse(1,getQuId(),"3",MeQiTe3Fragment2.this,REFRESHBASE,true);
    }
}
