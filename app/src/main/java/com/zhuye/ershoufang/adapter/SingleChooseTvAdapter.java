package com.zhuye.ershoufang.adapter;

import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.SingleChooseBean;

/**
 * Created by Administrator on 2018/4/23 0023.
 */

public class SingleChooseTvAdapter extends BaseQuickAdapter<SingleChooseBean,BaseViewHolder> {

    public SingleChooseTvAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, SingleChooseBean item) {
        if(!TextUtils.isEmpty(item.getContent())){
//           ImageView imageView =  helper.getView(R.id.iv);
//           imageView.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(mContext,item)));
            try {
                helper.setText(R.id.item,item.getContent());
                TextView textView = helper.getView(R.id.item);
                if(item.getChoose()){
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.shape_lan_10));
                    textView.setTextColor(mContext.getResources().getColor(R.color.qianse));
                }else {
                    textView.setBackground(null);
                    textView.setTextColor(mContext.getResources().getColor(R.color.gray));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
