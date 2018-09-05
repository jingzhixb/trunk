package com.zhuye.ershoufang.weidtet;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class RvAdapter2 extends BaseQuickAdapter<MyRecycleBean,BaseViewHolder> {

    public RvAdapter2(int layoutResId) {
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


        MyInputView myInputView = helper.getView(R.id.huxing);
        myInputView.setContent(item.name==null?"":item.getName());

        // 设置图片
        MySelectPhotoView2 xiaoguo = helper.getView(R.id.xiaoguo);
        xiaoguo.setPhoto2(item.getFilepath());
        // 最多选择一张图片
        xiaoguo.imgcount = 1;
        helper.addOnClickListener(R.id.delete);

        helper.setText(R.id.miaoshu,item.getMiaoshua()==null?"":item.getMiaoshua());

        MyInputView mianjinn = helper.getView(R.id.mianjinn);
        mianjinn.setContent(item.mian==null?"":item.getMian());


        MyInputView price = helper.getView(R.id.price);
        price.setContent(item.getPrice()==null?"":item.getPrice());
        if(!da.contains(helper)){
            da.add(helper);
        }
    }
}
