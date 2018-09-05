package com.zhuye.ershoufang.adapter.me;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.PaiMaiBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MyPaiMaiItemAdapter2 extends BaseQuickAdapter<PaiMaiBean,BaseViewHolder> {


    public MyPaiMaiItemAdapter2(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PaiMaiBean item) {

        ImageView imageView = helper.getView(R.id.image);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);

        helper.setText(R.id.title,item.getAddr())
//                .setText(R.id.state,"审核中")
                .setText(R.id.jiage,item.getQp_money())
                .setText(R.id.cjjiage,item.getMoney())
                .setText(R.id.leixingmianji1,"中标价格")
                .setText(R.id.edit,item.getStart_time());


//        helper.setText(R.id.title,item.getAddr())
//                .setText(R.id.state,"审核中")
//                .setText(R.id.jiage,item.getMoney())
//                .setText(R.id.edit,item.getStart_time());


        helper.setVisible(R.id.state,false);
        helper.setVisible(R.id.leixingmianji,false);
        helper.setVisible(R.id.jiage,false);

//        helper.setText(R.id.title,item.getAddr())
//                .setText(R.id.price,item.getNum1())
//                .setText(R.id.leixingmianji,item.getSelect1_name()==null ? "": item.getSelect1_name()+item.getNum1())
//                .setText(R.id.leixing,"二手房")
//        .addOnClickListener(R.id.edit).addOnClickListener(R.id.delete)
//        .addOnClickListener(R.id.zhiding);


    }
}
