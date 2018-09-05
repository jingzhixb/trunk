package com.zhuye.ershoufang.ui.fragment.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.BaseView;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuiDaActivity extends BaseActivity {


    private static final int TIJIAO = 5456;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.xiangqing)
    TextView xiangqing;
    @BindView(R.id.tijiao)
    Button tijiao;
    @BindView(R.id.huida)
    EditText huida;

    @Override
    protected int getResId() {
        return R.layout.activity_hui_da;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "问题详情");

    }


    String id;
    String in;

    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        in = getIntent().getStringExtra("in");
        xiangqing.setText(in);
    }

    @OnClick({R.id.back, R.id.tijiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tijiao:
                if (checkEmpty(huida,"请输入回答信息")){
                    CommonApi.getInstance().sub_answer(Integer.parseInt(id),getString(huida)
                    ,getToken(),HuiDaActivity.this,TIJIAO);
                }
                    break;
        }
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case TIJIAO:
                toast(base.getMessage());
                finish();
                break;
        }
    }
}
