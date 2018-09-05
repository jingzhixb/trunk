package com.zhuye.ershoufang.ui.activity.home;

import android.view.View;

import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.SelectBean2;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.MutiCommon2Activity;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonHomeActivity<T> extends MutiCommon2Activity<T> {

    private static final int GETDATA = 1999;
    protected String qu_id;
    @Override
    protected void initData() {
        super.initData();
        qu_id = getQuId();
        CommonApi.getInstance().xiaji(qu_id,CommonHomeActivity.this,GETDATA,false);
    }

    protected CityBean jiadao;
    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case GETDATA:
                jiadao = (CityBean) o;
                break;
        }
    }

    protected List<String> dat = new ArrayList<>();
    public void clickJieDao(View view){
        if(jiadao==null){
            return;
        }
        for (int i =0;i<jiadao.getData().size();i++){
            dat.add(jiadao.getData().get(i).getName());
        }
        alertWindow(view, dat, 9);
    }

   protected   CommonListBean<SelectBean2> selectBean2CommonListBean;

    public void clickLeiXing(View view){
//        dat.add("住宅");
//        dat.add("商铺");
//        dat.add("写字楼");
//        dat.add("工业厂房");
//        alertWindow(view, dat, 11);

        dat.clear();
        if(selectBean2CommonListBean!=null&&selectBean2CommonListBean.getData()!=null){
            for (SelectBean2 selectBean2: selectBean2CommonListBean.getData()){
                dat.add(selectBean2.getAttr_name());
            }
            alertWindow(view, dat, 11);
        }
//        dat.add("住宅");
//        dat.add("商铺");
//        dat.add("写字楼");
//        dat.add("工业厂房");
//        alertWindow(view, dat, 11);
    }

    protected String business_id;



}
