package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.ZhuangxiuJiaJuBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.LoginActivity;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

public class ZhuangXiuDetailActivity extends BaseActivity {

    private static final int GETDATA = 888;
    private static final int SHOUCANG = 958;
    private static final int QUXIAO = 784564;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.shoucang)
    TextView shoucang;
    @BindView(R.id.goutomg)
    TextView goutomg;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.qijian)
    RelativeLayout qijian;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.jiatou)
    ImageView jiatou;
    @BindView(R.id.shoua)
    ImageView shoua;
    @BindView(R.id.ttttt)
    RoundedCornerImageView ttttt;

    @Override
    protected int getResId() {
        return R.layout.activity_zhuang_xiu_detail;
    }

    String id;
    String type;//1 家居  2 装修

    @Override
    protected void initView() {
        super.initView();
        id = getIntent().getStringExtra("id");
        type = getIntent().getStringExtra("type");
        if (type.equals("2")) {
            jiatou.setVisibility(View.INVISIBLE);
        } else {
            jiatou.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().detail(Integer.parseInt(id), getToken(), this, GETDATA);

        // TODO: 2018/6/5 0005 判断是否已经收藏
    }

    CommonObjectBean<ZhuangxiuJiaJuBean> bean;


    int cang = 0;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case QUXIAO:
                toast(base.getMessage());
                shoucang.setText("收藏");
                shoua.setImageResource(R.mipmap.shou99);
                cang = 0;
                break;
            case SHOUCANG:
                toast(base.getMessage());
                shoucang.setText("已收藏");
                shoua.setImageResource(R.drawable.shou1);
                cang = 1;
                break;
            case GETDATA:
                bean = (CommonObjectBean<ZhuangxiuJiaJuBean>) base;
                name.setText(bean.getData().getShop());

                // 收藏处理

                cang = bean.getData().getCang();
                if (bean.getData().getCang() == 1) {
                    shoucang.setText("已收藏");
                    shoua.setImageResource(R.drawable.shou1);
                } else {
                    shoucang.setText("收藏");
                    shoua.setImageResource(R.mipmap.shou99);
                }

                //ImageView imageView = helper.getView(R.id.image);
                Glide.with(ZhuangXiuDetailActivity.this).load(NetWorkUrl.IMAGEURL + bean.getData().getShop_img()).into(image);
                Glide.with(ZhuangXiuDetailActivity.this).load(NetWorkUrl.IMAGEURL + bean.getData().getShop_face()).into(ttttt);
                // helper.setText(R.id.title,item.getShop_detail()).setText(R.id.name,item.getShop());
                break;
        }
    }

    @OnClick({R.id.shoucang, R.id.goutomg, R.id.qijian, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.back:
                finish();
                break;

            case R.id.qijian:
                if (type.equals("1")) {
                    Intent intent = new Intent(ZhuangXiuDetailActivity.this, QiJianDianActivity.class);
                    intent.putExtra("id", bean.getData().getUser_id());
                    startActivity(intent);
                } else if (type.equals("2")) {
                    // TODO: 2018/6/5 0005
                }

                break;

            case R.id.shoucang:
                if (isNeedLogin()) {
                    start(LoginActivity.class);
                    return;
                }
                if (type.equals("1")) {
                    if (cang == 1) {
                        CommonApi.getInstance().del_collect(getToken(), 2, Integer.parseInt(bean.getData().getUser_id()), ZhuangXiuDetailActivity.this, QUXIAO);
                    } else {
                        CommonApi.getInstance().collect(getToken(), "2", bean.getData().getUser_id(), ZhuangXiuDetailActivity.this, SHOUCANG);
                    }

                } else if (type.equals("2")) {
                    if (cang == 1) {
                        CommonApi.getInstance().del_collect(getToken(), 3, Integer.parseInt(bean.getData().getUser_id()), ZhuangXiuDetailActivity.this, QUXIAO);
                    } else {
                        CommonApi.getInstance().collect(getToken(), "3", bean.getData().getUser_id(), ZhuangXiuDetailActivity.this, SHOUCANG);
                    }


                }
                break;
            case R.id.goutomg:
                if (isNeedLogin()) {
                    start(LoginActivity.class);
                    return;
                }
                RongIM.getInstance().startConversation(ZhuangXiuDetailActivity.this
                        , Conversation.ConversationType.PRIVATE, bean.getData().getUser_id(), bean.getData().getShop());
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
