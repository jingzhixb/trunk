package com.zhuye.ershoufang.adapter.me.qite;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.QiTeBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class QiTe3Adapter extends BaseQuickAdapter<QiTeBean,BaseViewHolder> {


    public QiTe3Adapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, QiTeBean item) {
        helper.setText(R.id.title,item.getXiaoqu())
                .setText(R.id.leixingmianji,item.getSelect1() + " | "+item.getNum1()+"m²")
                .setText(R.id.leixing,(item.getAgent()==null || TextUtils.isEmpty(item.getAgent()))? "":"经纪人:"+item.getAgent())
                .setText(R.id.zhiding,item.getNum2()+"元/月")
                .setText(R.id.delete,item.getAgent_mobile() == null?"" : item.getAgent_mobile());

        helper.setVisible(R.id.jiadan,false);
        helper.addOnClickListener(R.id.jiadan);
    }
}
