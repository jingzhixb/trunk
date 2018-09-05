package com.zhuye.ershoufang.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class TuiJianViewAdapter extends BaseQuickAdapter<Common5Bean,BaseViewHolder> {


    public TuiJianViewAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Common5Bean item) {
        ImageView imageView = helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto().get(0)).into(imageView);
        try {
            helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²")
                    .setText(R.id.dizhi,item.getArea()==null?"":item.getArea()+"-"
                            +item.getBusiness()==null?"":item.getBusiness())
            .setText(R.id.price,item.getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
