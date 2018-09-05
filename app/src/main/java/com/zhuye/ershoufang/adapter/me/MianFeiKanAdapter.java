package com.zhuye.ershoufang.adapter.me;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.MeKanFangBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MianFeiKanAdapter extends BaseQuickAdapter<MeKanFangBean,BaseViewHolder> {


    public MianFeiKanAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MeKanFangBean item) {

        ImageView image = helper.getView(R.id.image);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(image);
        if(item.getPrice()==null){
            helper.getView(R.id.price1).setVisibility(View.GONE);
        }else {
            helper.setText(R.id.price,item.getPrice());
        }

        helper.setText(R.id.dizhi,item.getAddr())
                .setText(R.id.title,item.getTitle());
               // .setText(R.id.price,item.getPrice()==null?helper.getView(R.id.price1).setVisibility(View.GONE):item);
        helper.addOnClickListener(R.id.zhiding).addOnClickListener(R.id.edit);

        RecyclerView recyclerView = helper.getView(R.id.tese);
        TvAdapter adapter = new TvAdapter(R.layout.tv6);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        //// TODO: 2018/6/5 0005 设置特色
        adapter.addData(item.getYoulie());
    }
}
