package com.zhuye.ershoufang.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.zhuye.ershoufang.R;

;


/**
 * Created by Administrator on 2018/2/2 0002.
 */

public class DaojinUtils {

    public static void daojiShi(final Context context, final TextView huaquyanzhengma){
        new CountDownTimer(59000, 1000) {

            public void onTick(long millisUntilFinished) {
//                        LogUtil.i(TAG, "seconds remaining: " + millisUntilFinished / 1000);
                huaquyanzhengma.setText("还有"+millisUntilFinished / 1000+"秒");
                huaquyanzhengma.setEnabled(false);
                huaquyanzhengma.setTextColor(context.getResources().getColor(R.color.dindansnor));
                huaquyanzhengma.setBackgroundColor(context.getResources().getColor(R.color.white));
            }
            public void onFinish() {
                huaquyanzhengma.setText("重新发送");
                huaquyanzhengma.setEnabled(true);
                huaquyanzhengma.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                huaquyanzhengma.setBackgroundResource(R.drawable.shape_btn);
                //huaquyanzhengma.setBackground());
                //huaquyanzhengma.setBackgroundResource(R.drawable.btn_bg);
            }


        }.start();
    }
}
