package com.zhuye.ershoufang.adapter.me.paimai;

import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.PaiMaiBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.me.MePaiMaiFragment;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class MeTiXingFragment extends MePaiMaiFragment{


    private int page = 1;
    @Override
    protected void initData() {
        super.initData();
        getListData(1,this,LIST);
    }

    protected void getListData(int page, BaseFragment f,int requestcoe ) {
        CommonApi.getInstance().bidder_tx(getToken(),page,MeTiXingFragment.this,requestcoe);
    }

    PaiMaiBean paiMaiBean;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
//            case LIST:
//                paiMaiBean = (PaiMaiBean) o;
//                if(paiMaiBean.getData()==null){
//                    toast("数据为空");
//                    return;
//                }
//                adapter.addData(paiMaiBean.getData());
//                break;
//
//            case DELETE:
//                toast(o.getMessage());
//                break;
//            case REFRESH:
//                paiMaiBean = (PaiMaiBean) o;
//                if(paiMaiBean.getData()==null){
//                    toast("数据为空");
//                    refresh.finishRefresh();
//                    return;
//                }
//                data.clear();
//                data.addAll(paiMaiBean.getData());
//                adapter.replaceData(data);
//                break;
//
//            case LOADMORE:
//                paiMaiBean = (PaiMaiBean) o;
//                if(paiMaiBean.getData()==null){
//                    toast("数据为空");
//                    refresh.finishLoadmore();
//                    return;
//                }
//                data.addAll(paiMaiBean.getData());
//                adapter.replaceData(data);
//                break;
        }
    }



    @Override
    protected void refresh() {
        super.refresh();
        getListData(1,this,REFRESH);
    }

    @Override
    protected void loadmore() {
        super.loadmore();
        getListData(++page,this,LOADMORE);
    }
}
