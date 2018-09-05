package com.zhuye.ershoufang.weidtet;

import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class RvAdapter3 extends BaseQuickAdapter<MyRecycleBean,BaseViewHolder> {

    public RvAdapter3(int layoutResId) {
        super(layoutResId);
    }

    public List<BaseViewHolder> da = new ArrayList<>();
    @Override
    protected void convert(BaseViewHolder helper, MyRecycleBean item) {
//        ImageView imageView=  helper.getView(R.id.image);
//        imageView.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(mContext,item)));
       // helper.setText(R.id.item,item);
       // helper.setAdapter(R.id.xiaoguo,RvAdapter2.this);
       // helper.setAdapter(R.id.xiaoguo,helper.get)

        //helper.itemView = helper.getConvertView();
       // helper

//        helper.setVisible(R.id.jingli,item.getIsfirst());



//        TextView time1 = helper.getView(R.id.time);
//        if(item.getEndtime()==null|| TextUtils.isEmpty(item.getEndtime())){
////            helper.setText(R.id.time1,item.getStarttime());
//        }else {
//            helper.setText(R.id.time,item.getStarttime()+" - "+item.getEndtime());
//        }

        helper.addOnClickListener(R.id.delete).addOnClickListener(R.id.jinglia).addOnClickListener(R.id.time);
//        helper.setText(R.id.time,item.getStarttime()+" - "+item.getEndtime())
        helper.setText(R.id.jinglia,item.getJingli());

        TextView textView = helper.getView(R.id.time);
        if(item.getStarttime()!=null&&item.getEndtime()!=null&&!item.getEndtime().equals("")){
            textView.setText(item.getStarttime()+" - "+item.getEndtime());
        }else if(item.getStarttime()!=null){
            textView.setText(item.getStarttime());
        }else if(item.getEndtime()!=null){
            textView.setText(item.getEndtime());
        }else {
            textView.setText("");
        }

        if(!da.contains(helper)){
            da.add(helper);
        }
    }
}
