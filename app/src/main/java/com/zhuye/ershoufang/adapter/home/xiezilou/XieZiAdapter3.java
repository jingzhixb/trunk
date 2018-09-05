package com.zhuye.ershoufang.adapter.home.xiezilou;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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

public class XieZiAdapter3 extends BaseQuickAdapter<Common3Bean,BaseViewHolder> {


    public XieZiAdapter3(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Common3Bean item) {
//        ImageView imageView = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
       // helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²");
               // .setText(R.id.dizhi,item.get)
//        ImageView imageVi = helper.getView(R.id.pics);
//        if(item.getPhoto()!=null && !TextUtils.isEmpty(item.getPhoto())){
//            try {
//                Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageVi);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        helper.setText(R.id.title,item.getTitle()).
//                setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name())
//                .setText(R.id.price,item.getNum1()==null?"0":item.getNum1());
//        RecyclerView tesea = helper.getView(R.id.tese);
//        TvAdapter adapter = new TvAdapter(R.layout.tv2);
//        tesea.setAdapter(adapter);
//        tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
//        adapter.addData(item.getSelect5());
        try {
            ImageView imageVi = helper.getView(R.id.pics);
            Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageVi);
            helper.setText(R.id.title,item.getTitle()).
                    setText(R.id.dizhi,item.getArea_id()+"-"+item.getBusiness_id())
                    .setText(R.id.price,item.getNum1())
                    .setText(R.id.danwei,"元/月")
                    .setText(R.id.mianji,"总建面 "+item.getNum2()+" m²");
            RecyclerView tesea = helper.getView(R.id.tese);
            TvAdapter adapter = new TvAdapter(R.layout.tv2);
            tesea.setAdapter(adapter);
            tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
