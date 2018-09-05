package com.zhuye.ershoufang.adapter.me;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.CommonBean;
import com.zhuye.ershoufang.bean.KanBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class ZhuangXiuKanAdapter extends BaseQuickAdapter<KanBean,BaseViewHolder> {


    public ZhuangXiuKanAdapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, KanBean item) {
        ImageView  iv = helper.getView(R.id.tuxiang);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getFace()).into(iv);

//        helper.setText(R.id.name,item.get)

        TextView  tv = helper.getView(R.id.name);
        TextView  dian1 = helper.getView(R.id.dian1);
        TextView  dian2 = helper.getView(R.id.dian2);
        tv.setText(item.getMianji());

        helper.addOnClickListener(R.id.dian1);
        String type = item.getView();
        if(type.equals("0")){
            dian1.setVisibility(View.VISIBLE);
            dian2.setVisibility(View.GONE);
        }else if(type.equals("1")){
            dian2.setVisibility(View.VISIBLE);
            dian1.setVisibility(View.GONE);
            helper.setText(R.id.dian2,item.getMobile());
        }
    }
}
