package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;

import com.zhuye.ershoufang.ui.activity.me.AddChuZu2Activity;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeChuZuFragment4  extends MeChuZuFragment {

    @Override
    protected int getCate_id() {
        return 12;

      //  截图是错误  发布的出租删除的时候
    }

    @Override
    protected void clickEdit(int position) {
        Intent intent = new Intent(getActivity(),AddChuZu2Activity.class);
        intent.putExtra("type","2");
        intent.putExtra("id",list.get(position).getLife_id());
        startActivity(intent);
    }
}
