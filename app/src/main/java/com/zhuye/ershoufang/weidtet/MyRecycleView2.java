package com.zhuye.ershoufang.weidtet;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.JingJiRenBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cn.qqtheme.framework.picker.DateTimePicker;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2018/5/12 0012.
 */

public class MyRecycleView2 extends RecyclerView  implements ActionSheet.ActionSheetListener {

    public MyRecycleView2(Context context) {
        this(context,null);
    }


    public MyRecycleView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RvAdapter3 adapter2;

    private TextView name1;
    private TextView name2;
    private TextView name3;
    public MyRecycleView2(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        adapter2 = new RvAdapter3(R.layout.myrv2_item);
        View footer = LayoutInflater.from(context).inflate(R.layout.add,null);
        name1 = footer.findViewById(R.id.name1);
        name2 = footer.findViewById(R.id.name2);
        name3 = footer.findViewById(R.id.name3);
        setAdapter(adapter2);
        CustomLinearLayoutManager layoutManager =  new CustomLinearLayoutManager(context);
        setLayoutManager(layoutManager);
//        adapter2.addF
        RelativeLayout.LayoutParams p = new  RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        p.leftMargin = 15;
//        p.rightMargin = 15;
        footer.setLayoutParams(p);

        adapter2.addFooterView(footer);

        layoutManager.setScrollEnabled(false);

        MyRecycleBean bean = new MyRecycleBean(null,"","","");
        datas.add(bean);
        adapter2.addData(datas);
        this.context = (AppCompatActivity) context;
        input = View.inflate(context, R.layout.input_text, null);
        inputtitle = input.findViewById(R.id.title);
        inputcontent = input.findViewById(R.id.input);
        inputquxiao = input.findViewById(R.id.quxiao);
        inputqueding = input.findViewById(R.id.queding);
        initListener();
    }




    private void selectTime(int typy) {
        DateTimePicker picker = new DateTimePicker((Activity) context, DateTimePicker.HOUR_24);
//        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        picker.setDateRangeEnd(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
        picker.setDateRangeStart(1980, 11, 11);
        picker.setTimeRangeStart(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        //picker.setLabelTextColor(0xFFFF0000);
        picker.setDividerColor(0xFFFF0000);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                MyRecycleBean myRecycleBean = datas.get(datas.size()-1);
                switch (typy){
                    case 1:
                        myRecycleBean.setStarttime(year + "-" + month + "-" + day);
                        break;
                        case 2:
                        myRecycleBean.setEndtime(year + "-" + month + "-" + day);
                        break;
                }
                adapter2.replaceData(datas);
                //showToast(year + "-" + month + "-" + day + " " + hour + ":" + minute);
//                editText.setVisibility(VISIBLE);
//                editText.setClickable(false);
//                editText.setFocusable(false);
//                editText.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
//                time = year + "-" + month + "-" + day + " " + hour + ":" + minute;

            }
        });
        picker.show();

    }


    private int edittimepsd;

    private void initListener() {

        adapter2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.delete:
                        datas.remove(position);
                        adapter2.replaceData(datas);
                        break;

                    case R.id.jinglia:
                        editLeiXingin2(view,"请输入",position);
                        break;

                    case R.id.time:
                        edittimepsd= position;
                        ActionSheet.createBuilder(context, context.getSupportFragmentManager())
                                .setCancelButtonTitle("取消")
                                .setOtherButtonTitles("编辑开始时间", "编辑结束时间")
                                .setCancelableOnTouchOutside(true)
                                .setListener(MyRecycleView2.this).show();
                        break;
                }
            }
        });

        name1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTime(1);
            }
        });

        name2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editLeiXingin(view,"请输入");
            }
        });

        name3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTime(2);
            }
        });
    }
    PopupWindow popupWindow2;
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity)context).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((Activity)context).getWindow().setAttributes(lp);
    }
    View input;
    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;
    private int selectIndex = -1;

    private void editLeiXingin2(View view, String title, int position) {
        inputcontent.setText("");
        selectIndex = -1;
        popupWindow2 = new PopupWindow(context);
        popupWindow2.setContentView(input);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);

        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度

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
                if(TextUtils.isEmpty(inputcontent.getText().toString().trim())){
                    Toast.makeText(context,"请输入内容",Toast.LENGTH_SHORT).show();
                }else {
                    if (popupWindow2.isShowing()) {
                        popupWindow2.dismiss();
                        //target.setText(inputcontent.getText().toString().trim());
                        String con = inputcontent.getText().toString().trim();
                        ((TextView)view).setText(con);
                        datas.get(position).setJingli(con);
//                        List<String> data = new ArrayList<>();
//                        data.add(inputcontent.getText().toString().trim());
//                        datas.get(datas.size()-1).setJingli(inputcontent.getText().toString().trim());
                    }
                }
                adapter2.replaceData(datas);
            }
        });

        popupWindow2.showAtLocation(view, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    private void editLeiXingin(View view, String title) {
        inputcontent.setText("");
        selectIndex = -1;
        popupWindow2 = new PopupWindow(context);
        popupWindow2.setContentView(input);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);

        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度

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
                if(TextUtils.isEmpty(inputcontent.getText().toString().trim())){
                    Toast.makeText(context,"请输入内容",Toast.LENGTH_SHORT).show();
                }else {
                    if (popupWindow2.isShowing()) {
                        popupWindow2.dismiss();
                        //target.setText(inputcontent.getText().toString().trim());
                        List<String> data = new ArrayList<>();
                        data.add(inputcontent.getText().toString().trim());
                        datas.get(datas.size()-1).setJingli(inputcontent.getText().toString().trim());
                    }
                }
                adapter2.replaceData(datas);
            }
        });

        popupWindow2.showAtLocation(view, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    public List<MyRecycleBean> datas = new ArrayList<>();
    public void setData(MyRecycleBean bean,int pos){
        datas.add(pos,bean);
    }

    public MyRecycleBean getLast(){
        return datas.get(datas.size()-1);
    }

    public String getContent(){
        StringBuilder  sb = new StringBuilder();
        for(int i = 0;i<datas.size();i++){
            if(i==datas.size()-1){
                // 编辑的时候做的处理
                if(datas.get(i).getEndtime()!=null && datas.get(i).getEndtime().equals("")){
                    sb.append(datas.get(i).getStarttime());
                    sb.append(",");
                    sb.append(datas.get(i).getJingli());
                }else {
                    sb.append(datas.get(i).getStarttime()+"-"+datas.get(i).getEndtime());
                    sb.append(",");
                    sb.append(datas.get(i).getJingli());
                }
//                sb.append(datas.get(i).getStarttime()+"-"+datas.get(i).getEndtime());
//                sb.append(",");
//                sb.append(datas.get(i).getJingli());
            }else {
                if(datas.get(i).getEndtime()!=null && datas.get(i).getEndtime().equals("")){
                    sb.append(datas.get(i).getStarttime());
                    sb.append(",");
                    sb.append(datas.get(i).getJingli());
                    sb.append("|");
                }else {
                    sb.append(datas.get(i).getStarttime()+"-"+datas.get(i).getEndtime());
                    sb.append(",");
                    sb.append(datas.get(i).getJingli());
                    sb.append("|");
                }

            }
        }
//        for(MyRecycleBean myRecycleBean: datas){
//
//        }
        return sb.toString();
    }

    public void setContent(String contetn){

    }

    public void setData(List<JingJiRenBean.JingliBean> data){
//        Observable.fromIterable(data).map(new Function<JingJiRenBean.JingliBean, Object>() {
//        })
        datas.clear();
        for (JingJiRenBean.JingliBean bean : data) {
            MyRecycleBean bean1 = new MyRecycleBean();
            bean1.setJingli(bean.getZhiwei());
            bean1.setStarttime(bean.getJingli());
            bean1.setEndtime("");
            datas.add(bean1);
        }
        adapter2.replaceData(datas);
    }

    public void add(){
        MyRecycleBean bean = getLast();
        if(TextUtils.isEmpty(bean.getStarttime())){
            Toast.makeText(context,"请输入开始时间",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(bean.getEndtime())){
            Toast.makeText(context,"请输入结束时间",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(bean.getJingli())){
            Toast.makeText(context,"请输入从业经历",Toast.LENGTH_SHORT).show();
        }else {
            datas.add(new MyRecycleBean(null,"","",""));
            adapter2.replaceData(datas);
        }

    }
    AppCompatActivity context;

    public Boolean isTian(){
        int count = adapter2.getItemCount();
        Boolean temp = true;
        for (int i = 0;i<count;i++){
            MyRecycleBean bean = adapter2.getItem(i);
            if(bean.filepath==null||bean.filepath.size()==0){
                Toast.makeText(context,"请上传"+(i+1)+"户型图片",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
            if(TextUtils.isEmpty(bean.miaoshua)){
                Toast.makeText(context,"请上传"+(i+1)+"户型描述",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
            if(TextUtils.isEmpty(bean.mian)){
                Toast.makeText(context,"请上传"+(i+1)+"户型面积",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
        }
        //adapter2.
        return temp;
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

    }

    private void selectTime2(int typy) {
        DateTimePicker picker = new DateTimePicker((Activity) context, DateTimePicker.HOUR_24);
//        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        picker.setDateRangeEnd(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
        picker.setDateRangeStart(1980, 11, 11);
        picker.setTimeRangeStart(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        //picker.setLabelTextColor(0xFFFF0000);
        picker.setDividerColor(0xFFFF0000);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                MyRecycleBean myRecycleBean =datas.get(edittimepsd);
                switch (typy){
                    case 1:
                        myRecycleBean.setStarttime(year + "-" + month + "-" + day);
                        break;
                    case 2:
                        myRecycleBean.setEndtime(year + "-" + month + "-" + day);
                        break;
                }
                adapter2.replaceData(datas);
                //showToast(year + "-" + month + "-" + day + " " + hour + ":" + minute);
//                editText.setVisibility(VISIBLE);
//                editText.setClickable(false);
//                editText.setFocusable(false);
//                editText.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
//                time = year + "-" + month + "-" + day + " " + hour + ":" + minute;

            }
        });
        picker.show();

    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
        Log.i("ad",index+"");
        switch (index){
            case 0:
                selectTime2(++index);
                break;
            case 1:
                selectTime2(++index);
                break;
        }

    }
}
