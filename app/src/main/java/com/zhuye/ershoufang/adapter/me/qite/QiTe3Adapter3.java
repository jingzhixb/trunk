package com.zhuye.ershoufang.adapter.me.qite;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.QiTeBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class QiTe3Adapter3 extends BaseQuickAdapter<QiTeBean,BaseViewHolder> {


    public QiTe3Adapter3(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, QiTeBean item) {
        ImageView view = helper.getView(R.id.image);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(view);

        helper.setText(R.id.title,item.getArea_name()+item.getBusiness_name()+item.getAddr()+" " +item.getXiaoqu())
                .setText(R.id.leixingmianji,item.getNum1()+"m²")
                 .setText(R.id.leixing,item.getAgent()==null? "":"经纪人:"+item.getAgent())
                .setText(R.id.zhiding,item.getSelect1()+"  "+item.getNum2()+"元/月")
                .setText(R.id.delete,item.getAgent_mobile() == null?"" : item.getAgent_mobile());

        helper.setVisible(R.id.jiadan,true);
        helper.addOnClickListener(R.id.jiadan);
    }
}
