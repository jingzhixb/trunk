package com.zhuye.ershoufang.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.QiJianAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.QiJianDianBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QiJianDianActivity extends BaseActivity {
    private static final int GETDATA = 943;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tou1)
    ImageView tou1;
    @BindView(R.id.tou)
    RoundedCornerImageView tou;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.footer)
    ClassicsFooter footer;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_qi_jian_dian);
//    }


    @Override
    protected void initListener() {
        super.initListener();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void initView() {
        super.initView();
        //header = View.inflate(QiJianDianActivity.this,R.layout.jiajuheader,null);
        adapter = new QiJianAdapter(R.layout.qijian_item);
        // adapter.addHeaderView(header);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new GridLayoutManager(this, 2));

//        back  = header.findViewById(R.id.back);
//        tou1  = header.findViewById(R.id.tou1);
//        tou  = header.findViewById(R.id.tou);
//        name  = header.findViewById(R.id.name);


    }

    //    ImageView back;
//    ImageView tou1;
//TextView name ;
//    ImageView tou;
    String id;

    @Override
    protected void initData() {
        super.initData();
        // TODO: 2018/6/5 0005
        id = getIntent().getStringExtra("id");
        CommonApi.getInstance().jiaju_shop(Integer.parseInt(id), page, this, GETDATA);
    }

    CommonObjectBean<QiJianDianBean> bean;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case GETDATA:
                //// TODO: 2018/6/5 0005  刷新的使用
                bean = (CommonObjectBean<QiJianDianBean>) base;
                adapter.addData(bean.getData().getProduct());



                Glide.with(QiJianDianActivity.this).load(NetWorkUrl.IMAGEURL + bean.getData().getShop_face()).into(tou);
                Glide.with(QiJianDianActivity.this).load(NetWorkUrl.IMAGEURL + bean.getData().getShop_img()).into(tou1);
                try {
                    name.setText(bean.getData().getShop());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //  Glide.with(QiJianDianActivity.this).load(NetWorkUrl.IMAGEURL+bean.getData().getShop_face()).into(tou);
                break;


        }
    }

    @Override
    protected int getResId() {
        return R.layout.bodyjiaja;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
