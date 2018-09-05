package com.zhuye.ershoufang.adapter.home;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.bean.KanFangBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MianKanFangAdapter extends BaseQuickAdapter<KanFangBean,BaseViewHolder> {


    public MianKanFangAdapter(int layoutResId) {
        super(layoutResId);
    }
//    Long  cur;

    @Override
    protected void convert(BaseViewHolder helper, KanFangBean item) {
//        ImageView imageView = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
       // helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²");
               // .setText(R.id.dizhi,item.get)
//        ImageView imageVi = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageVi);
//        helper.setText(R.id.title,item.getTitle()).
//                setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name())
//                .setText(R.id.price,item.getNum1())
//                .setText(R.id.mianji,"总建面 "+item.getNum2()+" m²");
//        RecyclerView tesea = helper.getView(R.id.tese);
//        TvAdapter adapter = new TvAdapter(R.layout.tv2);
//        tesea.setAdapter(adapter);
//        tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
//        adapter.addData(item.getSelect5());



        helper.setText(R.id.title,item.getTitle())
                .setText(R.id.renshu,item.getCount()+"人报名")
                .setText(R.id.price,item.getPrice())
        .setText(R.id.dizhi,item.getAddr())
        .addOnClickListener(R.id.zixun)
        .addOnClickListener(R.id.baoming);
         ImageView imageVi = helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageVi);



        //
        String is_onsale = item.getIs_onsale();
        if(is_onsale!=null){
            if(is_onsale.equals("1")){
                helper.setText(R.id.state,"期房未收");
            }else if(is_onsale.equals("2")){
                helper.setText(R.id.state,"期房在售");
            }else if(is_onsale.equals("3")){
                helper.setText(R.id.state,"期房已售完");
            }
        }


        //
        RecyclerView recyclerView = helper.getView(R.id.recycles);
        TvAdapter adapter = new TvAdapter(R.layout.tv6);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));



        adapter.addData(item.getYoulie());


        // TODO: 2018/6/14 0014  
        TextView tv = helper.getView(R.id.time);
        Long starttime = Long.parseLong(item.getStart_time());

//        Long tempcur = SystemClock.currentThreadTimeMillis();
        Long tempcur = System.currentTimeMillis();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        Date date = new Date(date1.getTime());
//
//        tv.setText(format.format(date));
        Date date1 = new Date();
       Long cur = date1.getTime()/1000;

        if(starttime>cur){
            CountDownTimer timer = new CountDownTimer(starttime-cur,1000) {
                @Override
                public void onTick(long l) {
                    Date date1 = new Date();
                    Long cur = date1.getTime()/1000;
                //    Long cur = SystemClock.currentThreadTimeMillis();
                    long day = 0;
                    long hour = 0;
                    long minute = 0;
                    long second = 0;
                    Long totalSeconds = starttime -cur;
                    if (totalSeconds > 0) {
                        second = totalSeconds;
                        if (second >= 60) {
                            minute = second / 60;
                            second = second % 60;
                            if (minute >= 60) {
                                hour = minute / 60;
                                minute = minute % 60;
                                if (hour > 24) {
                                    day = hour / 24;
                                    hour = hour % 24;
                                }
                            }
                        }
                    }
                    tv.setText(day + "天" + hour + "小时" + minute + "分钟" + second + "秒");
                   // StringBuilder stringBuilder = new StringBuilder();

                   // tv.setText(+"");
                    ++cur;
                }

                @Override
                public void onFinish() {

                }
            }.start();
        }
    }
}
