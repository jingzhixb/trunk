package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;

import com.zhuye.ershoufang.ui.activity.me.AddChuZ1Activity;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeChuZuFragment1 extends MeChuZuFragment {

    @Override
    protected int getCate_id() {
        return 4;
    }

    @Override
    protected void clickEdit(int position) {

        Intent intent = new Intent(getActivity(),AddChuZ1Activity.class);
        intent.putExtra("type","2");
        intent.putExtra("id",list.get(position).getLife_id());
        startActivity(intent);
    }
}
