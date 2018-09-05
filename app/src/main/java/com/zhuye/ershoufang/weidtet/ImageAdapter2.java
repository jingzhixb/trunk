package com.zhuye.ershoufang.weidtet;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.utils.FilesUtil;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class ImageAdapter2 extends BaseQuickAdapter<String,BaseViewHolder> {

    public ImageAdapter2(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView imageView=  helper.getView(R.id.image);
        if(item.startsWith("http")){
            Glide.with(mContext).load(item).into(imageView);
        }else {
            Glide.with(mContext).load(FilesUtil.getSmallBitmap(mContext,item)).into(imageView);
//            imageView.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(mContext,item)));
        }

        helper.addOnClickListener(R.id.delete);
    }
}
