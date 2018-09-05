package com.zhuye.ershoufang.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by hpc on 2017/4/10.
 */

public class CheckUtil {
    /**
     * 验证手机格式
     */
    public static boolean isMobile(Context context,String number) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][356789]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、7,8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(context.getApplicationContext(),"请输入手机号",Toast.LENGTH_SHORT).show();
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            if(!number.matches(num)){
                Toast.makeText(context.getApplicationContext(),"手机号格式有误",Toast.LENGTH_SHORT).show();
            }
            return number.matches(num);
        }
    }

    public static boolean isMobile(String number) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][356789]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、7,8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return !number.matches(num);
        }
    }

    public static boolean isPassword(String password) {

        String num = "^[0-9a-zA-Z]{6,16}$";
        if (TextUtils.isEmpty(password)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return password.matches(num);
        }
    }
}
