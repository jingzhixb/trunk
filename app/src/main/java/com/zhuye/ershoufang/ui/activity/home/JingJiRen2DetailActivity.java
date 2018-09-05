package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.JingJiDetailAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.JingJiDetailBean;
import com.zhuye.ershoufang.bean.ShareBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.LogUtils;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JingJiRen2DetailActivity extends BaseActivity {


    private static final int GETDATA = 78451;
    private static final int SHARE = 15456;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.touxing)
    RoundedCornerImageView touxing;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.share)
    LinearLayout share;
    @BindView(R.id.year)
    TextView year;
    @BindView(R.id.fangyuan)
    TextView fangyuan;
    @BindView(R.id.xuanyan)
    TextView xuanyan;
    @BindView(R.id.jieshao)
    TextView jieshao;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    CommonObjectBean<JingJiDetailBean> bean;
    @BindView(R.id.gongsi)
    TextView gongsi;
    @BindView(R.id.zhuying)
    TextView zhuying;
    @BindView(R.id.zhuyingxiaoqu)
    TextView zhuyingxiaoqu;
    @BindView(R.id.mendian)
    TextView mendian;
    @BindView(R.id.gongzuofanwei)
    TextView gongzuofanwei;
    @BindView(R.id.rb)
    RatingBar rb;
    @BindView(R.id.tablayout)
    SmartTabLayout tablayout;
    @BindView(R.id.ratingbar)
    com.hedgehog.ratingbar.RatingBar ratingbar;
    @BindView(R.id.gofangyuan)
    LinearLayout gofangyuan;

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            LogUtils.i(share_media.toString());
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            LogUtils.i(throwable.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {

        }
    };

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case SHARE:

                CommonObjectBean<ShareBean> beanbb = (CommonObjectBean<ShareBean>) base;
                UMImage image = new UMImage(JingJiRen2DetailActivity.this, NetWorkUrl.IMAGEURL + beanbb.getData().getPhoto());//网络图片
                UMWeb web = new UMWeb(beanbb.getData().getUrl());
                web.setTitle(beanbb.getData().getTitle());//标题
                web.setThumb(image);  //缩略图
                // web.setDescription(bean.getData().get);//描述
                new ShareAction(JingJiRen2DetailActivity.this).withMedia(web)
                        .setDisplayList(SHARE_MEDIA.QZONE, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE)
                        .setCallback(umShareListener).open();


                break;

            case GETDATA:
                bean = (CommonObjectBean<JingJiDetailBean>) base;
                if (bean != null && bean.getData() != null) {
                    Glide.with(JingJiRen2DetailActivity.this).load(NetWorkUrl.IMAGEURL + bean.getData().getFace()).into(touxing);

                    setText(name, bean.getData().getTrue_name());

                    setText(dizhi, bean.getData().getArea_name() + "  " + bean.getData().getCompany());

                    setText(year, bean.getData().getYear() == null ? "2年" : bean.getData().getYear() + "年");

                    bean.getData().getMall();
                    setText(fangyuan, bean.getData().getLife_count());  // 房源数量
                    setText(xuanyan, bean.getData().getDeclaration());

                    setText(jieshao, bean.getData().getIntro());

                    setText(gongsi, bean.getData().getCompany());

                    setText(zhuying, bean.getData().getMain_business().equals("0") ? "住宅" : "商业地产");

                    setText(zhuyingxiaoqu, bean.getData().getXiaoqu());

                    setText(mendian, bean.getData().getShop());

                    setText(gongzuofanwei, bean.getData().getArea_name());

                    // rb.setRating(Float.parseFloat(bean.getData().getScore()));

                    ratingbar.setStar(Float.parseFloat(bean.getData().getScore()));

                }
                break;
        }
    }

    @Override
    protected int getResId() {
        return R.layout.activity_jing_ji_ren2_detail;
    }

    String id;

    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        CommonApi.getInstance().agent_detail(id, JingJiRen2DetailActivity.this, GETDATA, true);
//        JingJiDetailAdapter adapter1 = new JingJiDetailAdapter(getSupportFragmentManager(), this);
//        viewpager.setAdapter(adapter1);
//        tablayout.setViewPager(viewpager);
//        adapter1.setData(id);
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "经纪人主页");
        AlertDialog alertDialog;
    }

    @OnClick({R.id.back, R.id.share,R.id.gofangyuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gofangyuan:
                Intent intent = new Intent(JingJiRen2DetailActivity.this,LookFangYuanActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.share:
                // 经纪人分享
                CommonApi.getInstance().share(id, "3", JingJiRen2DetailActivity.this, SHARE, false);
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
