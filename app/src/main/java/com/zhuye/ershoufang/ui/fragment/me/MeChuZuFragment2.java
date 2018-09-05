package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;

import com.zhuye.ershoufang.ui.activity.me.AddChuZu3Activity;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeChuZuFragment2 extends MeChuZuFragment {

    @Override
    protected int getCate_id() {
        return 13;
    }

    @Override
    protected void clickEdit(int position) {
        Intent intent = new Intent(getActivity(),AddChuZu3Activity.class);
        intent.putExtra("type","2");
        intent.putExtra("id",list.get(position).getLife_id());
        startActivity(intent);


    }
}
