package com.zhuye.ershoufang.ui.activity.common;

import android.widget.TextView;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.SelectBean2;
import com.zhuye.ershoufang.utils.LogUtils;

public abstract class CommonAddActivity extends BaseActivity {

    protected  String type;
    protected String  life_id;
    protected GeoCoder mSearch;
    protected CommonListBean<SelectBean2> fukuanfangs;
    protected  CommonListBean<SelectBean2>   chuzufangshi;
    protected static final int EDIT = 1111;

    public String getIndex(CommonListBean<SelectBean2> listBean,TextView tv){
        String string = getString(tv);
        String id = "0";
        for (SelectBean2 selectBean2: listBean.getData()){
            if(string.equals(selectBean2.getAttr_name())){
                id = selectBean2.getAttr_id();
                break;
            }
        }
        return id;
    }
    @Override
    protected void initData() {
        super.initData();
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(listener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearch.destroy();
    }

    protected String latitude;
    protected String longitude;

    OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {

        public void onGetGeoCodeResult(GeoCodeResult result) {

            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有检索到结果
            }

            //获取地理编码结果
            try {
                LogUtils.i(result.getLocation().latitude+"");
                latitude = String.valueOf(result.getLocation().latitude);
                longitude = String.valueOf(result.getLocation().longitude);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override

        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {

            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有找到检索结果
            }

            //获取反向地理编码结果
        }
    };
}
