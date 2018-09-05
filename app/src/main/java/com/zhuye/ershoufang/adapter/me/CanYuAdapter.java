package com.zhuye.ershoufang.adapter.me;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.CanYnBean;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class CanYuAdapter extends BaseQuickAdapter<CanYnBean,BaseViewHolder> {


    public CanYuAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CanYnBean item) {

        ImageView  iv = helper.getView(R.id.tuxiang);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getFace()).into(iv);

//        helper.setText(R.id.name,item.get)

        TextView tv = helper.getView(R.id.name);
        TextView  dian1 = helper.getView(R.id.dian1);
        dian1.setVisibility(View.GONE);
        TextView  dian2 = helper.getView(R.id.dian2);
        dian2.setText(item.getMobile());
        tv.setText(item.getNickname());
//
//        String type = item.getView();
//        if(type.equals("0")){
//            dian1.setVisibility(View.VISIBLE);
//            dian2.setVisibility(View.GONE);
//        }else if(type.equals("1")){
//            dian2.setVisibility(View.VISIBLE);
//            dian1.setVisibility(View.GONE);
//            helper.setText(R.id.dian2,item.getMobile());
//        }
////        ImageView imageView = helper.getView(R.id.pics);
////        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
////        helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²")
////        .setText(R.id.price,item.getPrice());
////               // .setText(R.id.dizhi,item.get)
//        ImageView imageVi = helper.getView(R.id.pics);
////                if(item.getData().getPhoto()==null&&item.getData().getPhoto().size()>1) {
////                    Glide.with(mContext).load(NetWorkUrl.IMAGEURL + item.getData().getPhoto().get(0)).into(imageVi);
////                }
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL + item.getPhoto()).into(imageVi);
//        helper.setText(R.id.title,item.getTitle()).
//                setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name())
//                .setText(R.id.price,item.getNum1())
//                .setText(R.id.mianji,"总建面 "+item.getNum2()+" m²");
//        RecyclerView tesea = helper.getView(R.id.tese);
//        TvAdapter adapter = new TvAdapter(R.layout.tv2);
//        tesea.setAdapter(adapter);
//        tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
    }
}
