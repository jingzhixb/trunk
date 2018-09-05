package com.zhuye.ershoufang.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
    public static String getTimrString(String time){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(Long.parseLong(time));
         return simpleDateFormat.format(date);
//        simpleDateFormat.p
//        var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
//        Y = date.getFullYear() + '-';
//        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
//        D = date.getDate() + ' ';
//        h = date.getHours() + ':';
//        m = date.getMinutes() + ':';
//        s = date.getSeconds();
//        return Y+M+D+h+m+s;
    }
}
