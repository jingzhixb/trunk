package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.LouBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/12 0012.
 */

public class MyRecycleView extends RecyclerView {

    public MyRecycleView(Context context) {
        this(context,null);
    }


    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RvAdapter2 adapter2;

    public MyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        adapter2 = new RvAdapter2(R.layout.myrv_item);
        setAdapter(adapter2);
        CustomLinearLayoutManager layoutManager =  new CustomLinearLayoutManager(context);
        setLayoutManager(layoutManager);

        layoutManager.setScrollEnabled(false);

        MyRecycleBean bean = new MyRecycleBean(null,"","","");
        datas.add(bean);
        adapter2.addData(datas);
        this.context = context;
        initListener();
    }

    private void initListener() {
        adapter2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.delete:
                        datas.remove(position);
                         adapter2.replaceData(datas);
                         break;
                }
            }
        });
    }

    public List<MyRecycleBean> datas = new ArrayList<>();
    public void setData(MyRecycleBean bean,int pos){
        datas.add(pos,bean);

    }

    public void add(){
        MyRecycleBean myRecycleBean = new MyRecycleBean(null,"","","");
        datas.add(myRecycleBean);
        adapter2.addData(datas.size()-1,myRecycleBean);
//        adapter2.setData(datas.size(),myRecycleBean);
       adapter2.notifyItemInserted(datas.size()-1);
//        adapter2.no
       // adapter2.replaceData(datas);
    }
    Context context;

    public Boolean isTian(){
        int count = adapter2.getItemCount();
        Boolean temp = true;
        for (int i = 0;i<count;i++){
            MyRecycleBean bean = adapter2.getItem(i);
            if(bean.filepath==null||bean.filepath.size()==0){
                Toast.makeText(context,"请上传"+(i+1)+"户型图片",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
            if(TextUtils.isEmpty(bean.miaoshua)){
                Toast.makeText(context,"请上传"+(i+1)+"户型描述",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
            if(TextUtils.isEmpty(bean.mian)){
                Toast.makeText(context,"请上传"+(i+1)+"户型面积",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
        }
        //adapter2.
        return temp;
    }
    
    
    public void setData(List<String> list){
        // TODO: 2018/6/5 0005  
//        adapter2.addData(list);

    }

    public void setData2(List<LouBean.HuxingBean> huxing) {
        datas.clear();
        for (LouBean.HuxingBean huxingBean : huxing) {
            MyRecycleBean bean = new MyRecycleBean();
            bean.setPrice(huxingBean.getPrice());
            bean.setName(huxingBean.getHuxing());
            bean.setMian(huxingBean.getHx_area());
            bean.setMiaoshua(huxingBean.getMiaoshu());
            List<String>  dd= new ArrayList<>();
            // 网上的图片加htpp
            dd.add(NetWorkUrl.IMAGEURL+huxingBean.getImg());
            bean.setFilepath(dd);
            datas.add(bean);
        }
        adapter2.replaceData(datas);
    }
}
