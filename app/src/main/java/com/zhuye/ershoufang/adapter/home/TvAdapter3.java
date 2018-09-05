package com.zhuye.ershoufang.adapter.home;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.CityBean;

/**
 * Created by Administrator on 2018/4/23 0023.
 */

public class TvAdapter3 extends BaseQuickAdapter<CityBean.DataBean,BaseViewHolder> {

    public TvAdapter3(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CityBean.DataBean item) {
//        if(!TextUtils.isEmpty(item)){
////           ImageView imageView =  helper.getView(R.id.iv);
////           imageView.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(mContext,item)));
//            helper.setText(R.id.item,item);
//        }

        helper.setText(R.id.shouru,item.getName())
        .addOnClickListener(R.id.shouru);
    }
}
