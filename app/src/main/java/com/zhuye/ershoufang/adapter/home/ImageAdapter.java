package com.zhuye.ershoufang.adapter.home;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.BidderDetailBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class ImageAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    public ImageAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        ImageView imageView = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
       // helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²");
               // .setText(R.id.dizhi,item.get)
        ImageView imageView = helper.getView(R.id.pics);
        String path = item;
        if(!item.startsWith("http")){
           path =  NetWorkUrl.IMAGEURL+path;
        }
        Glide.with(mContext).load(path).into(imageView);
//        helper.setText(R.id.haoma,item.getCode())
//                .setText(R.id.price,item.getMoney());
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
