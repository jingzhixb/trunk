package com.zhuye.ershoufang.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.ChuZuListBean;
import com.zhuye.ershoufang.bean.FaBuListBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MaiFangItemAdapter2 extends BaseQuickAdapter<ChuZuListBean,BaseViewHolder> {


    public MaiFangItemAdapter2(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChuZuListBean item) {

        ImageView imageView = helper.getView(R.id.image);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);

        helper.setText(R.id.title,item.getTitle())
                .setText(R.id.price,item.getNum1())
                .setText(R.id.leixingmianji,item.getArea_name()==null ? "": item.getArea_name()+" " +item.getNum2()+"m²")
//                .setText(R.id.leixing,"二手房")
        .addOnClickListener(R.id.edit).
                addOnClickListener(R.id.delete)
        .addOnClickListener(R.id.zhiding);




        String a = item.getAudit();
        if(a.equals("0")){
            helper.setText(R.id.state,"审核中");
        }else {
            helper.setVisible(R.id.state,false);
        }
    }
}
