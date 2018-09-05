package com.zhuye.ershoufang.adapter.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class ChangFangAdapter3 extends BaseQuickAdapter<Common3Bean,BaseViewHolder> {


    public ChangFangAdapter3(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Common3Bean item) {
        ImageView imageVi = helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageVi);
        helper.setText(R.id.title,item.getTitle()).
                setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name())
                .setText(R.id.price,item.getNum1())
                .setText(R.id.mianji,"总建面 "+item.getNum2()+" m²");
        // .setText(R.id.danwei,"元");

        if(item.getIschuzu()){
            helper.setText(R.id.danwei,"元/月");
        }else {
            helper.setText(R.id.danwei,"万元");
        }
        helper.setText(R.id.danwei,"元/月");
        RecyclerView tesea = helper.getView(R.id.tese);
        TvAdapter adapter = new TvAdapter(R.layout.tv2);
        tesea.setAdapter(adapter);
        tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
    }
}
