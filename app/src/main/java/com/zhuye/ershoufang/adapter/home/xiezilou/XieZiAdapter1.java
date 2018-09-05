package com.zhuye.ershoufang.adapter.home.xiezilou;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class XieZiAdapter1 extends BaseQuickAdapter<Common5Bean,BaseViewHolder> {


    public XieZiAdapter1(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Common5Bean item) {
//        ImageView imageView = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
       // helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²");
               // .setText(R.id.dizhi,item.get)
//        ImageView imageVi = helper.getView(R.id.pics);
//        if(item.getPhoto()!=null &&item.getPhoto().size()>0){
//            try {
//                Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageVi);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        helper.setText(R.id.title,item.getTitle()).
//                setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name())
//                .setText(R.id.price,item.getPrice()==null?"0":item.getPrice())
//                .setText(R.id.mianji,"总建面 "+item.getMianji()+" m²");
//        RecyclerView tesea = helper.getView(R.id.tese);
//        TvAdapter adapter = new TvAdapter(R.layout.tv2);
//        tesea.setAdapter(adapter);
//        tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
//        adapter.addData(item.get());
        try {
            ImageView imageVi = helper.getView(R.id.pics);
//                if(item.getData().getPhoto()==null&&item.getData().getPhoto().size()>1) {
//                    Glide.with(mContext).load(NetWorkUrl.IMAGEURL + item.getData().getPhoto().get(0)).into(imageVi);
//                }
            Glide.with(mContext).load(NetWorkUrl.IMAGEURL + item.getPhoto().get(0)).into(imageVi);
            helper.setText(R.id.title,item.getTitle()).
                    setText(R.id.dizhi,item.getArea()+"-"+item.getBusiness())
                    .setText(R.id.price,item.getPrice())
                    .setText(R.id.mianji,"总建面 "+item.getMianji()+" m²");
            RecyclerView tesea = helper.getView(R.id.tese);
            TvAdapter adapter = new TvAdapter(R.layout.tv2);
            tesea.setAdapter(adapter);
            tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
