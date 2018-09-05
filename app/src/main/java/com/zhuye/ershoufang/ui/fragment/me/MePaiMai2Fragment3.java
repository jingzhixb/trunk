package com.zhuye.ershoufang.ui.fragment.me;

import com.zhuye.ershoufang.bean.MybidderBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MePaiMai2Fragment3 extends MePaiMai2Fragment<MybidderBean> {

    @Override
    protected String getPaiId(int position) {
        return list.get(position).getId();

}
    @Override
    protected int getType() {
        return 3;
    }
}
