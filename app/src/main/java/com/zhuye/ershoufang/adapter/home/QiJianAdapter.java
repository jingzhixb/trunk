package com.zhuye.ershoufang.adapter.home;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.CommonBaseQuickAdapter;
import com.zhuye.ershoufang.bean.CommonFangBean;
import com.zhuye.ershoufang.bean.QiJianDianBean;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.home.QiJianDianActivity;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class QiJianAdapter extends CommonBaseQuickAdapter<QiJianDianBean.ProductBean,BaseViewHolder> {
    public QiJianAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, QiJianDianBean.ProductBean item) {

        ImageView tou = helper.getView(R.id.iv);

        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(tou);
        helper.setText(R.id.name,item.getTitle());
        //ImageView imageVi = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getData().getPhoto().get(0)).into(imageVi);
//        helper.setText(R.id.title,item.getData().getTitle()).
//                setText(R.id.dizhi,item.getData().getArea_name()+"-"+item.getData().getBusiness_name())
//                .setText(R.id.price,item.getData().getPrice())
//                .setText(R.id.mianji,"总建面 "+item.getData().getMianji()+" m²");
//        RecyclerView tesea = helper.getView(R.id.tese);
//        TvAdapter adapter = new TvAdapter(R.layout.tv2);
//        tesea.setAdapter(adapter);
//        tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
    }
}
