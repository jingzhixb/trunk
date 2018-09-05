package com.zhuye.ershoufang.adapter.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.BidderDetailBean;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class JingMaijiLeAdapter extends BaseQuickAdapter<BidderDetailBean.DataBean.JingbiaoBean,BaseViewHolder> {


    public JingMaijiLeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, BidderDetailBean.DataBean.JingbiaoBean item) {
//        ImageView imageView = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
       // helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²");
               // .setText(R.id.dizhi,item.get)


        TextView tv = helper.getView(R.id.qubie);
        TextView price = helper.getView(R.id.price);

        if(item.getQubie()){
            tv.setText("领先");
            tv.setTextColor(mContext.getResources().getColor(R.color.jusecolor));
            price.setTextColor(mContext.getResources().getColor(R.color.jusecolor));
        }else {
            tv.setText("出局");
            tv.setTextColor(mContext.getResources().getColor(R.color.gray));
            price.setTextColor(mContext.getResources().getColor(R.color.gray));
        }

        helper.setText(R.id.haoma,item.getCode())
                .setText(R.id.price,item.getMoney());
//        ImageView imageVi = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageVi);
//        helper.setText(R.id.title,item.getTitle()).
//                setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name())
//                .setText(R.id.price,item.getNum1())
//                .setText(R.id.mianji,"总建面 "+item.getNum2()+" m²");
//        RecyclerView tesea = helper.getView(R.id.tese);
//        TvAdapter adapter = new TvAdapter(R.layout.tv2);
//        tesea.setAdapter(adapter);
//        tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
//        adapter.addData(item.getSelect5());
    }
}
