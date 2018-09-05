package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;

import com.zhuye.ershoufang.ui.activity.me.AddChuZu4Activity;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeChuZuFragment3  extends MeChuZuFragment {

    @Override
    protected int getCate_id() {
        return 10;
    }

    @Override
    protected void clickEdit(int position) {
        Intent intent = new Intent(getActivity(),AddChuZu4Activity.class);
        intent.putExtra("type","2");
        intent.putExtra("id",list.get(position).getLife_id());
        startActivity(intent);
    }
}
