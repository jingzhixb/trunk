package com.zhuye.ershoufang.adapter.home;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.BanZhengFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.ChuZuFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.DaiKuanFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.Mai2FangFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.MaiFangFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.QiuZuFragment;
import com.zhuye.ershoufang.ui.fragment.home.JingJiDetailFragment;
import com.zhuye.ershoufang.ui.fragment.home.JingJiDetailFragment1;
import com.zhuye.ershoufang.ui.fragment.home.JingJiDetailFragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class JingJiDetailAdapter extends FragmentPagerAdapter {


    Context mContext;
    String[] titles;
    List<JingJiDetailFragment> fragments = new ArrayList<>();

    public JingJiDetailAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        titles = context.getResources().getStringArray(R.array.home_jinjidetail);
//        for(int i=0;i<titles.length;i++){
//            MeMaiFAgnFragment fragment = new MeMaiFAgnFragment();
//            fragments.add(fragment);
//        }
        fragments.add(new JingJiDetailFragment1());
        fragments.add(new JingJiDetailFragment2());
//        fragments.add(new ChuZuFragment());
//        fragments.add(new QiuZuFragment());
//        fragments.add(new BanZhengFragment());
//        fragments.add(new DaiKuanFragment());
    }

    public void setData(String id){
        for(JingJiDetailFragment fragment: fragments){
            fragment.setData2(id);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
