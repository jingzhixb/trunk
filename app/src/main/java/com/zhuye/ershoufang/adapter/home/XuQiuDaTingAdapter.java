package com.zhuye.ershoufang.adapter.home;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.zhuye.ershoufang.adapter.CommonFragmentPagerAdapter;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe1Fragment;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe1Fragment1;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe2Fragment;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe2Fragment2;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe3Fragment;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe3Fragment2;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe4Fragment;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe4Fragment4;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe5Fragment;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe5Fragment5;
import com.zhuye.ershoufang.ui.fragment.me.MeQiTe6Fragment6;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class XuQiuDaTingAdapter  extends CommonFragmentPagerAdapter{

    public XuQiuDaTingAdapter(FragmentManager fm, Context context, Integer resId) {
        super(fm, context, resId);
    }

    @Override
    protected void initFragments() {
        for (int i =0; i<titles.length;i++){
//            fragments.add(new XuQiu1Fragment());
//            fragments.add(new XuQiu2Fragment());
//            fragments.add(new XuQiu3Fragment());
//            fragments.add(new XuQiu4Fragment());
//            fragments.add(new XuQiu5Fragment());
            fragments.add(new MeQiTe1Fragment1());
            fragments.add(new MeQiTe2Fragment2());
            fragments.add(new MeQiTe3Fragment2());
            fragments.add(new MeQiTe4Fragment4());
            fragments.add(new MeQiTe5Fragment5());
            fragments.add(new MeQiTe6Fragment6());
        }
    }
}