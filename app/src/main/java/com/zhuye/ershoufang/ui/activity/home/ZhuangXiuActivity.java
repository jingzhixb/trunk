package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ZhuangXiuAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.PhotoBean2;
import com.zhuye.ershoufang.bean.ZhuangxiuJiaJuBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;
import com.zhuye.ershoufang.ui.activity.me.ZhuangXiuKanActivity;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

public class ZhuangXiuActivity extends Common2Activity<ZhuangxiuJiaJuBean> {

    private static final int GETPHOTO = 1456;
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
        return R.layout.activity_zhuang_xiu;
    }

    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("装修");
        subtitle.setText("估价");

    }


    View header ;
    @Override
    protected void initData() {
        super.initData();
        adapter = new ZhuangXiuAdapter(R.layout.zhuangxiu_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
        CommonApi.getInstance().zhuangxiu(page,ZhuangXiuActivity.this,LIST);

        CommonApi.getInstance().adv(this,GETPHOTO,false);

        header = LayoutInflater.from(this).inflate(R.layout.zhuangxiuheder,null);
        bgaBanner = header.findViewById(R.id.banner);

        adapter.addHeaderView(header);
        bgaBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(ZhuangXiuActivity.this)
                        .load(model)
                        .into(itemView);
            }
        });
    }
    BGABanner bgaBanner;
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
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //start(ZhuangXiuDetailActivity.class);
                Intent intent = new Intent(ZhuangXiuActivity.this,ZhuangXiuDetailActivity.class);
                intent.putExtra("id",list.get(position).getUser_id());
                intent.putExtra("type","2");
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().zhuangxiu(++page,ZhuangXiuActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().zhuangxiu(1,ZhuangXiuActivity.this,REFRESHBASE);
    }

    @OnClick({R.id.back, R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                start(BaoJiaActivity.class);
                break;
        }
    }

    CommonListBean<PhotoBean2> dat ;
     @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case GETPHOTO:
                dat = (CommonListBean<PhotoBean2>) o;
                if(dat.getData().size()==1){
                    bgaBanner.setData(Arrays.asList(NetWorkUrl.IMAGEURL + dat.getData().get(0)),
                            Arrays.asList(""));
                }else if(dat.getData().size()==2){
                    bgaBanner.setData(Arrays.asList(NetWorkUrl.IMAGEURL + dat.getData().get(0).getPhoto(),
                            NetWorkUrl.IMAGEURL + dat.getData().get(1).getPhoto()),
                            Arrays.asList("", ""));
                }else if(dat.getData().size()==3){
                    bgaBanner.setData(Arrays.asList(NetWorkUrl.IMAGEURL + dat.getData().get(0),
                            NetWorkUrl.IMAGEURL + dat.getData().get(1), NetWorkUrl.IMAGEURL + dat.getData().get(1)),
                            Arrays.asList("", "",""));
                }

                break;
        }
    }
}
