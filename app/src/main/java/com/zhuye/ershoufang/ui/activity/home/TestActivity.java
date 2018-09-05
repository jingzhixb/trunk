package com.zhuye.ershoufang.ui.activity.home;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zhuye.ershoufang.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);


        TextView tv = findViewById(R.id.time);
//        Long starttime = Long.parseLong(item.getStart_time());

//        Long tempcur = SystemClock.currentThreadTimeMillis();
        Long tempcur = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
//        Date date = new Date(date1.getTime());
//
//        tv.setText(format.format(date));
//        cur = date1.getTime()/1000;
//
//        if(starttime>cur){
//            CountDownTimer timer = new CountDownTimer(starttime-cur,1000) {
//                @Override
//                public void onTick(long l) {
//                    //    Long cur = SystemClock.currentThreadTimeMillis();
//                    long day = 0;
//                    long hour = 0;
//                    long minute = 0;
//                    long second = 0;
//                    Long totalSeconds = starttime -cur;
//                    if (totalSeconds > 0) {
//                        second = totalSeconds;
//                        if (second >= 60) {
//                            minute = second / 60;
//                            second = second % 60;
//                            if (minute >= 60) {
//                                hour = minute / 60;
//                                minute = minute % 60;
//                                if (hour > 24) {
//                                    day = hour / 24;
//                                    hour = hour % 24;
//                                }
//                            }
//                        }
//                    }
//                    tv.setText(day + "天" + hour + "小时" + minute + "分钟" + second + "秒");
//                    // StringBuilder stringBuilder = new StringBuilder();
//
//                    // tv.setText(+"");
//                    ++cur;
//                }
//
//                @Override
//                public void onFinish() {
//
//                }
//            }.start();
//        }
    }
}
