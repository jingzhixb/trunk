package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.ChuZuAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.utils.DensityUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class ChuZuActivity extends BaseActivity {


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
        return R.layout.activity_chu_zu;
    }
    ChuZuAdapter adapter;
    @Override
    protected void initView() {
        super.initView();
        adapter = new ChuZuAdapter(getSupportFragmentManager(),this);
        messageViewpager.setAdapter(adapter);
        viewpagertab.setViewPager(messageViewpager);
        setText(ttitle,"出租");
        setText(subtitle,"新增房源");
        //adapter.getCurrentItem(0).setData(0);
    }

    @OnClick({R.id.back,R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                //start(AddChuZuActivity.class);
                alertWindow(view);
                break;
        }
    }

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
            }else if(id.equals("4")){
                messageViewpager.setCurrentItem(2,false);
            }else if(id.equals("3")){
                messageViewpager.setCurrentItem(1,false);
            }else if(id.equals("2")){
                messageViewpager.setCurrentItem(3,false);
            }else if(id.equals("1")){
                messageViewpager.setCurrentItem(0,false);
            }
        }
    }

    PopupWindow popupWindow;
    private void alertWindow(View view) {
        View vie = View.inflate(ChuZuActivity.this, R.layout.menu_item, null);
        popupWindow = new PopupWindow(ChuZuActivity.this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(DensityUtil.dip2px(ChuZuActivity.this,260));
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        TextView tv = vie.findViewById(R.id.shouru);
        tv.setText("住宅");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                //title.setText("收入记录");

                Intent intent = new Intent(ChuZuActivity.this,AddChuZ1Activity.class);
                intent.putExtra("type","1");
                startActivity(intent);
//                start();
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
                //start(AddChuZu2Activity.class);
                type = 0;
                Intent intent = new Intent(ChuZuActivity.this,AddChuZu2Activity.class);
                intent.putExtra("type","1");
                startActivity(intent);
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
//                start(AddChuZu3Activity.class);
                Intent intent = new Intent(ChuZuActivity.this,AddChuZu3Activity.class);
                intent.putExtra("type","1");
                startActivity(intent);
            }
        });

        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
               // start(AddChuZu4Activity.class);
                Intent intent = new Intent(ChuZuActivity.this,AddChuZu4Activity.class);
                intent.putExtra("type","1");
                startActivity(intent);
            }
        });
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        popupWindow.showAtLocation(vie, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
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
                //adapter.getCurrentItem(position).setData(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
