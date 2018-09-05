package com.zhuye.ershoufang.adapter.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.JingJiDetailBean;
import com.zhuye.ershoufang.bean.JingJilBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class JingjiDtailAdapter3 extends BaseQuickAdapter<JingJilBean,BaseViewHolder> {


    public JingjiDtailAdapter3(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper,JingJilBean item) {

       ImageView imageView =  helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);

        helper.setText(R.id.title,item.getTitle())
                .setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name())
                .setText(R.id.mianji,item.getSelect1()+ " "+item.getNum2()+"m²")
                .setText(R.id.price,item.getNum1());
        RecyclerView view = helper.getView(R.id.tese);
        TvAdapter adapter = new TvAdapter(R.layout.tv2);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
    }
}
