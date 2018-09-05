package com.zhuye.ershoufang.ui.activity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.WebActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class FangDaiJiSuanActivity extends WebActivity {
    @Override
    public String getUrlName() {
        return NetWorkUrl.BASE+ "index.php/mobile/index/shuifei.html";
    }

    @Override
    protected Boolean getFromLocal() {
        return false;
    }

    @Override
    protected void javashoucang() {

    }

    @Override
    protected void initData() {
        super.initData();
        root.setVisibility(View.VISIBLE);
        subtitle.setVisibility(View.GONE);
        ttitle.setVisibility(View.VISIBLE);
        ttitle.setText("房贷计算");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //    @BindView(R.id.back)
//    ImageView back;
//    @BindView(R.id.ttitle)
//    TextView ttitle;
//    @BindView(R.id.subtitle)
//    TextView subtitle;
//    @BindView(R.id.shifa1)
//    TextView shifa1;
//    @BindView(R.id.mianji)
//    TextView mianji;
//    @BindView(R.id.mianjia)
//    TextView mianjia;
//    @BindView(R.id.dianshifa)
//    RelativeLayout dianshifa;
//    @BindView(R.id.zongge)
//    TextView zongge;
//    @BindView(R.id.shoufu)
//    TextView shoufu;
//    @BindView(R.id.daikaun)
//    TextView daikaun;
//    @BindView(R.id.daikuana)
//    TextView daikuana;
//    @BindView(R.id.lilv)
//    TextView lilv;
//    @BindView(R.id.yearlimit)
//    TextView yearlimit;
//    @BindView(R.id.jisuan)
//    TextView jisuan;

//    @Override
//    protected int getResId() {
//        return R.layout.activity_fang_dai_ji_suan;
//    }
//
//
//    @Override
//    protected void initView() {
//        super.initView();
//        hide(subtitle);
//        setText(ttitle,"房贷计算");
//    }
//
//    @OnClick({R.id.back, R.id.jisuan})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.back:
//                finish();
//                break;
//            case R.id.jisuan:
//                break;
//        }
//    }
}
