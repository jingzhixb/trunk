package com.zhuye.ershoufang.adapter.home;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.JingMaiBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class JingMaiAdapter2 extends BaseQuickAdapter<JingMaiBean,BaseViewHolder> {


    public JingMaiAdapter2(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, JingMaiBean item) {


        ImageView imm = helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imm);
        helper.setText(R.id.title,item.getAddr())
//                .setText(R.id.price2,item.getMoney()+"万")
                .setText(R.id.num,"出价 "+ item.getChujia()+"人");

        TextView textView = helper.getView(R.id.price2);
        if(item.getMoney()==null){
            textView.setText("暂无出价");
        }else {
            textView.setText(item.getMoney()+"万");
        }
    }
}
