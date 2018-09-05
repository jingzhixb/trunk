package com.zhuye.ershoufang.ui.activity;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MaiFAngAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.ui.activity.me.ChuZuActivity;
import com.zhuye.ershoufang.utils.DensityUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class WeiTuoActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.viewpagertab)
    SmartTabLayout viewpagertab;
    @BindView(R.id.message_viewpager)
    ViewPager messageViewpager;

    @Override
    protected int getResId() {
        return R.layout.activity_wei_tuo;
    }


    @Override
    protected void initListener() {
        super.initListener();
        viewpagertab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                angAdapter.getCurrentItem(position).setData(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    MaiFAngAdapter angAdapter;

    String types;
    String id;
    @Override
    protected void initData() {
        super.initData();
        types = getIntent().getStringExtra("type");
        id = getIntent().getStringExtra("id");
        if(types!=null && types.equals("2")){
            if(id.equals("5")){
                // 贷款发布成功
                messageViewpager.setCurrentItem(5,false);
            }else if(id.equals("0")){
                messageViewpager.setCurrentItem(0,false);
                //  bug
//                angAdapter.getCurrentItem(0).setData(0);
            }else if(id.equals("3")){
                messageViewpager.setCurrentItem(3,false);
                angAdapter.getCurrentItem(3).setData(3);
            }else if(id.equals("2")){
                messageViewpager.setCurrentItem(2,false);
                angAdapter.getCurrentItem(2).setData(2);
            }else if(id.equals("1")){
                messageViewpager.setCurrentItem(1,false);
                angAdapter.getCurrentItem(1).setData(1);
            }
        }
    }

    @Override
    protected void initView() {
        angAdapter = new MaiFAngAdapter(getSupportFragmentManager(),this);
        messageViewpager.setAdapter(angAdapter);
        viewpagertab.setViewPager(messageViewpager);
        setText(ttitle,"卖房");
        setText(subtitle,"新增房源");

        angAdapter.getCurrentItem(0).setData(0);
    }

    @OnClick({R.id.back, R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:

                alertWindow(view);
                break;
        }
    }
    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     *            屏幕透明度0.0-1.0 1表示完全不透明
     */
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
      getWindow().setAttributes(lp);
    }
    PopupWindow popupWindow;
    private void alertWindow(View view) {

        View vie = View.inflate(WeiTuoActivity.this, R.layout.menu_item3, null);
        popupWindow = new PopupWindow(WeiTuoActivity.this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(DensityUtil.dip2px(WeiTuoActivity.this,260));
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        // 背景的处理
       // setBackgroundAlpha(0.5f);//设置屏幕透明度
        vie.findViewById(R.id.shouru).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                //title.setText("收入记录");
                start(AddErShouActivity.class);
                type = 0;

            }
        });
        vie.findViewById(R.id.tixian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                //title.setText("收入记录");
                start(AddXieZiActivity.class);
                type = 0;

            }
        });

        vie.findViewById(R.id.shangpu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                //title.setText("收入记录");
                type = 0;
                start(AddShangPuActivity.class);
            }
        });

        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                start(AddGongChangActivity.class);
            }
        });

        popupWindow.showAtLocation(vie, Gravity.CENTER, 0, 0);
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        //popupWindow.showAtLocation(vie, Gravity.CENTER, 0, 0);
       // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
               // setBackgroundAlpha(1.0f);
            }
        });
    }

}
