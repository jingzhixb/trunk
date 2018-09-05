package com.zhuye.ershoufang.adapter.me.qite;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.QiTeBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class QiTe4Adapter4 extends BaseQuickAdapter<QiTeBean,BaseViewHolder> {


    public QiTe4Adapter4(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, QiTeBean item) {
        helper.setText(R.id.title,item.getTitle());

        helper.setText(R.id.title,item.getArea_name()+item.getBusiness_name()+item.getAddr()+" " +item.getXiaoqu())
                .setText(R.id.leixingmianji,item.getHuxing() + "  |  "+item.getNum1()+"m²")
                .setText(R.id.leixing,item.getAgent()==null? "":"经纪人:"+item.getAgent())
                .setText(R.id.zhiding,item.getNum2()+"元/月")
                .setText(R.id.delete,item.getAgent_mobile() == null?"" : item.getAgent_mobile());

        helper.setVisible(R.id.jiadan,true);
        helper.addOnClickListener(R.id.jiadan);

        helper.setVisible(R.id.jiadan,true);
        helper.addOnClickListener(R.id.jiadan);
    }
}
