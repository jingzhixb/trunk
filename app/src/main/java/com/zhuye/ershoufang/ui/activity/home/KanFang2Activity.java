package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.MianKanFangAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.KanFangBean;
import com.zhuye.ershoufang.data.BaseView;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.ui.activity.LoginActivity;
import com.zhuye.ershoufang.utils.CheckUtil;
import com.zhuye.ershoufang.utils.DaojinUtils;
import com.zhuye.ershoufang.utils.DensityUtil;
import com.zhuye.ershoufang.utils.WindowUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KanFang2Activity extends CommonHome2Activity<KanFangBean> {


    private static final int SUBMIT = 37894;
    private static final int GETCODE = 14545;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.common;
    }


    @Override
    protected void initData() {
        super.initData();


        CommonApi.getInstance().view_list(getToken(), page, KanFang2Activity.this, LIST);

    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "免费看房");
        adapter = new MianKanFangAdapter(R.layout.kanfang_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));


        input = View.inflate(KanFang2Activity.this, R.layout.input_text2, null);
        inputtitle = input.findViewById(R.id.title);
        inputcontent = input.findViewById(R.id.input);
        inputquxiao = input.findViewById(R.id.quxiao);
        inputqueding = input.findViewById(R.id.queding);
        inputqueding = input.findViewById(R.id.queding);
        inputqueding = input.findViewById(R.id.queding);
        code = input.findViewById(R.id.code);
        getcode = input.findViewById(R.id.getcode);

        getcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CheckUtil.isMobile(KanFang2Activity.this,getString(inputcontent))){
//                    CommonApi.getInstance().getCode(getString(inputcontent))
                    DaojinUtils.daojiShi(KanFang2Activity.this,getcode);
                    GetData.getCode3(getString(inputcontent),KanFang2Activity.this,GETCODE);
                }
            }
        });

    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case GETCODE:
                toast(o.getMessage());
                break;
        }
    }

    EditText code;

    TextView getcode;
    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent(KanFang2Activity.this, MianFeiKanDetailActivity.class);
//                intent.putExtra("id",list.get(position).getId());
//                startActivity(intent);
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.zixun:

                        String mobile = list.get(position).getMobile();
                        if (mobile == null) {
                            return;
                        }
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mobile));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                    case R.id.baoming:
                        //editLeiXingin(view,null,"请输入手机号",position);
                        Intent intent1 = new Intent(KanFang2Activity.this, MianFeiKanDetailActivity.class);
                        intent1.putExtra("id",list.get(position).getId());
                        startActivity(intent1);
                        break;
                }
            }
        });
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
    protected void onLoadmore() {
        CommonApi.getInstance().view_list(getToken(), ++page, KanFang2Activity.this, LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().view_list(getToken(), 1, KanFang2Activity.this, REFRESHBASE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    PopupWindow popupWindow2;
    View input;
    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;
    private int selectIndex;
    private void editLeiXingin(View view, TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow2 = new PopupWindow(KanFang2Activity.this);
        popupWindow2.setContentView(input);
        popupWindow2.setWidth(DensityUtil.dip2px(KanFang2Activity.this,300));
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);

        // 背景的处理
        WindowUtils.setBackgroundAlpha(KanFang2Activity.this, 0.5f);//设置屏幕透明度
        inputtitle.setText(title);

        inputquxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow2.isShowing()) {
                    popupWindow2.dismiss();
                }
            }
        });

        inputqueding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (checkEmpty(inputcontent, "请输入内容")) {
//
//                }



                if(CheckUtil.isMobile(KanFang2Activity.this,getString(inputcontent))){

                    if(getString(code)==null|| TextUtils.isEmpty(getString(code))){
                        toast("请输入验证码");
                        return;
                    }
                    if (popupWindow2.isShowing()) {
                        popupWindow2.dismiss();
                        // target.setText(getString(inputcontent));
//                        CommonApi.getInstance().discount(getToken(),list.get(type).getLife_id(),getString(inputcontent),YouHuiActivity.this
//                                ,SUBMIT);

                        if(getToken()==null){
                            start(LoginActivity.class);
                        }else {

                            CommonApi.getInstance().view_bm(getToken(),Integer.parseInt(list.get(type).getId()),getString(inputcontent),
                                    Integer.parseInt(getString(code)),KanFang2Activity.this,SUBMIT);
                        }

                    }
                }
            }
        });

        popupWindow2.showAtLocation(view, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                WindowUtils.setBackgroundAlpha(KanFang2Activity.this, 1.0f);
            }
        });
    }
}
