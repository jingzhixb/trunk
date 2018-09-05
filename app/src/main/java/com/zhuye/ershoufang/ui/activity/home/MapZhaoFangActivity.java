package com.zhuye.ershoufang.ui.activity.home;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.AlertAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.BeanBean;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.JingWeiBean;
import com.zhuye.ershoufang.bean.SelectBean2;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.zhuye.ershoufang.data.NetWorkUrl.SELECECODE;

public class MapZhaoFangActivity extends BaseActivity {


//    GestureDetector detector;

    private static final int ERSHOUFANGI = 912;
    private static final int XINFANGI = 913;
    private static final int ZUFANGI = 914;
    private static final int NEWHOUSE_COUNT = 978;
    private static final int ERSHOU_COUNT = 9781;
    private static final int ZUFANG_COUNT = 9783;
    private static final int GETDATA = 7851;
    private static final int ERFANGERJICODE = 78455;
    private static final int ZUFANGWEJICODE = 78888;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.xinfang)
    TextView xinfang;
    @BindView(R.id.ershoufang)
    TextView ershoufang;
    @BindView(R.id.zufang)
    TextView zufang;
    @BindView(R.id.quyu)
    TextView quyu;
    @BindView(R.id.jiage)
    TextView jiage;
    @BindView(R.id.huxing)
    TextView huxing;
    @BindView(R.id.bmapView)
    MapView bmapView;

    @Override
    protected int getResId() {
        return R.layout.activity_map_zhao_fang;
    }

    public void choose(TextView textView, TextView textView1, TextView textView2) {
        int white = getResources().getColor(R.color.white);
        Drawable whitebg = getResources().getDrawable(R.drawable.shape_tuijian);
        int pramy = getResources().getColor(R.color.colorPrimary);
        Drawable pramybg = getResources().getDrawable(R.drawable.shape_tuijian2);
        textView.setTextColor(pramy);
        textView.setBackground(whitebg);

        textView1.setTextColor(white);
        textView1.setBackground(pramybg);
        textView2.setTextColor(white);
        textView2.setBackground(pramybg);
    }


    String cate_id;
    String area_id;
    String business_id;
    String price1;
    String price2;
    String select1;

    CommonListBean<JingWeiBean> xinbena;
//    CommonListBean<JingWeiBean> erbean;
//    CommonListBean<JingWeiBean> zubean;

    //   大   10.8833

    //   小    18.356401



    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
           Log.i("sssssss", mBaiduMap.getMapStatus().zoom+"");
        return super.requestDragAndDropPermissions(event);
         }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//         Log.i("sssss", mBaiduMap.getMapStatus().zoom+"");
//         return detector.onTouchEvent(event);
//        }


        private Float zoom ;

        private Float largezoom = 10.8833f;
        private Float changcenterzoom = 13.0833f;
        private Float currentzoom = 10.8833f;
        private Float changezoom = 12.641902f;
        private Float changezoom1 = 12.241902f;
        private Float changezoom2 = 12.841902f;
        private Float minzoom =18.356401f;

    @Override
    protected void initListener() {
        super.initListener();
//mBaiduMap.setBaiduHeatMapEnabled();
//        bmapView
//        mBaiduMap.getMapStatus().zoom;


        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                LatLng latLng =  marker.getPosition();
                changeCenter(latLng);
//                marker.getPosition().
                return true;
            }
        });


        mBaiduMap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus) {
                Log.i("onMapStatusChangeStart",mapStatus.zoom+"") ;
            }

            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
                Log.i("onMapStatusChangeStart",mapStatus.zoom+"") ;
            }

            @Override
            public void onMapStatusChange(MapStatus mapStatus) {
                 Log.i("onMapStatusChange",mapStatus.zoom+"") ;
                currentzoom = mapStatus.zoom;
                 if(mapStatus.zoom>changezoom2){
                     // 放大清楚  一级maket   添加二级
//                     addMarket2();
                     addErjiMarket();
                 }else if(mapStatus.zoom< changezoom1) {
                     //缩小  添加一级maket  删除二级
                     addMarket();
                 }else{
                     mBaiduMap.clear();
                 }
            }

            @Override
            public void onMapStatusChangeFinish(MapStatus mapStatus) {
                Log.i("onMapStatusChangeFinish",mapStatus.zoom+"") ;
            }
        });


//        mBaiduMap.set
    }

    private void changeCenter(LatLng latLng) {
//        LatLng cenpt = new LatLng(lat,lon);
        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(latLng)
                .zoom(changcenterzoom)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
//        mBaiduMap.
//        mBaiduMap.ce
        mBaiduMap.setMapStatus(mMapStatusUpdate);
    }

    private void addMarket2() {
        if(currentzoom>changezoom2){
            addErjiMarket();
        }else{
            addMarket();
        }

//        if(currentzoom<changezoom1){
//            }
    }


    protected   CommonListBean<SelectBean2> selectBean2CommonListBean;
    CommonListBean<BeanBean>  beanBeanCommonListBean ;
    CommonListBean<BeanBean>  ershouListBean ;
    CommonListBean<BeanBean>  zufangListBean ;
    protected CityBean jiadao;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case SELECECODE:
                selectBean2CommonListBean = (CommonListBean<SelectBean2>) base;
                break;

            case GETDATA:
                jiadao = (CityBean) base;
                break;
            case ERSHOU_COUNT:
                ershouListBean = (CommonListBean<BeanBean>) base;
                if(ershouListBean!=null&&ershouListBean.getData()!=null){
//                    for (BeanBean beanBean : ershouListBean.getData()){
//                        mSearch.geocode(new GeoCodeOption()
//                                .city(beanBean.getName())
//                                .address(beanBean.getName()));
//                    }

                }
                break;
            case ZUFANG_COUNT:
                zufangListBean = (CommonListBean<BeanBean>) base;
                if(zufangListBean!=null&&zufangListBean.getData()!=null){
//                    for (BeanBean beanBean : zufangListBean.getData()){
//                        mSearch.geocode(new GeoCodeOption()
//                                .city(beanBean.getName())
//                                .address(beanBean.getName()));
//                    }
                }
                break;
             case NEWHOUSE_COUNT:
                beanBeanCommonListBean = (CommonListBean<BeanBean>) base;
                if(beanBeanCommonListBean!=null&&beanBeanCommonListBean.getData()!=null){
                    for (BeanBean beanBean : beanBeanCommonListBean.getData()){
                        mSearch.geocode(new GeoCodeOption()
                                .city(beanBean.getName())
                                .address(beanBean.getName()));
                         }
                    }
                break;

            case XINFANGI:
                xinbena = (CommonListBean<JingWeiBean>) base;
                addMarket2();
                break;
                case ERFANGERJICODE:
                ershoujiweib = (CommonListBean<JingWeiBean>) base;
                addMarket2();
                break;
            case ZUFANGWEJICODE:
                zufangjinweib = (CommonListBean<JingWeiBean>) base;
                addMarket2();
                break;
//            case ERSHOUFANGI:
//                erbean = (CommonListBean<JingWeiBean>) base;
//                if(erbean .getData() ==null || erbean.getData().size()==0){
//                    return;
//                }
//
//                break;
//            case ZUFANGI:
//                zubean  = (CommonListBean<JingWeiBean>) base;
//                if(xinbena .getData() ==null || xinbena.getData().size()==0){
//                    return;
//                }
//                break;

        }
    }

    CommonListBean<JingWeiBean> ershoujiweib;
    CommonListBean<JingWeiBean> zufangjinweib;
    private String select1huixing;

    private void requestData() {
        switch (cur){
            case NEWHOUSE_COUNT:
                CommonApi.getInstance().map_newhouse(getQuId(),business_id,price1,price2,select1,MapZhaoFangActivity.this,XINFANGI,true);
                break;
            case ERSHOU_COUNT:
                CommonApi.getInstance().house_map("3",getQuId(),business_id,price1,price2,select1huixing
                        ,MapZhaoFangActivity.this,ERFANGERJICODE,true );
                break;
            case ZUFANG_COUNT:
                CommonApi.getInstance().house_map("4",getQuId(),business_id,price1,price2,select1huixing
                        ,MapZhaoFangActivity.this,ZUFANGWEJICODE,true );
                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
//        CommonApi.getInstance().house_map("3",getQuId(),business_id,price1,price2,select1,MapZhaoFangActivity.this
//        ,ERSHOUFANGI,false);
        CommonApi.getInstance().map_newhouse(getQuId(),business_id,price1,price2,select1,MapZhaoFangActivity.this,XINFANGI,true);

        CommonApi.getInstance().house_map("3",getQuId(),business_id,price1,price2,select1huixing
                ,MapZhaoFangActivity.this,ERFANGERJICODE,true );

        CommonApi.getInstance().house_map("4",getQuId(),business_id,price1,price2,select1huixing
                ,MapZhaoFangActivity.this,ZUFANGWEJICODE,true );

        CommonApi.getInstance().sselect("3", "select1", MapZhaoFangActivity.this, SELECECODE, false);
        CommonApi.getInstance().xiaji(getQuId(), MapZhaoFangActivity.this, GETDATA, false);


        CommonApi.getInstance().mapnewhouse_count(getQuId(),MapZhaoFangActivity.this,NEWHOUSE_COUNT,false);
        CommonApi.getInstance().maplife_count(getQuId(),"3",MapZhaoFangActivity.this,ERSHOU_COUNT,false);
        CommonApi.getInstance().maplife_count(getQuId(),"4",MapZhaoFangActivity.this,ZUFANG_COUNT,false);

//        CommonApi.getInstance().house_map("4",getQuId(),business_id,price1,price2,select1,MapZhaoFangActivity.this
//                ,ZUFANGI,false);
    }

    private int type = XINFANG;
    private final static int XINFANG = 150;
    private final static int ERSHOUFANG = 151;
    private final static int ZUFANG = 152;



    @OnClick({R.id.back, R.id.xinfang, R.id.ershoufang, R.id.zufang, R.id.quyu, R.id.jiage, R.id.huxing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.xinfang:
                //addMarket();
                type  = XINFANG;
                choose(xinfang, ershoufang, zufang);
                huxing.setText("房型");
                cur =NEWHOUSE_COUNT ;

                addMarket2();
                break;
            case R.id.ershoufang:
                type= ERSHOUFANG;
                choose(ershoufang, xinfang, zufang);
                huxing.setText("户型");
                cur = ERSHOU_COUNT;
                mBaiduMap.clear();
                addMarket2();
                break;
            case R.id.zufang:
                type= ZUFANG;
                choose(zufang, ershoufang, xinfang);
                huxing.setText("户型");
                cur = ZUFANG_COUNT;

                mBaiduMap.clear();
                addMarket2();
                break;
            case R.id.quyu:
                clickJieDao(view);
//                mBaiduMap.clear();
//                addMarket2();
                break;
            case R.id.jiage:
                alertjiageWindow(view, 100);
//                mBaiduMap.clear();
//                addMarket2();
                break;
            case R.id.huxing:
                if(type==XINFANG){
                    clickLeiXing2(view);
                }else {
                    clickLeiXing(view);
                }
//                mBaiduMap.clear();
//                addMarket2();
                break;
        }
    }

    private void clickLeiXing2(View view) {
        dat.clear();
        dat.add("住宅");
        dat.add("商铺");
        dat.add("写字楼");
        dat.add("工业厂房");
        alertWindow(view, dat, 11);
    }

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
            alertWindow(view, dat, 15);
        }
//        dat.add("住宅");
//        dat.add("商铺");
//        dat.add("写字楼");
//        dat.add("工业厂房");
//        alertWindow(view, dat, 11);
    }

    protected PopupWindow popupWindow2;


    protected String prce1;
    protected String prce2;
    protected String yonghu;
    protected void alertjiageWindow(View view, int rescode) {
        View vie = View.inflate(MapZhaoFangActivity.this, R.layout.jiage, null);
        popupWindow2 = new PopupWindow(MapZhaoFangActivity.this);
        popupWindow2.setContentView(vie);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);
        TextView tv1 = vie.findViewById(R.id.queding);
        TextView tv2 = vie.findViewById(R.id.quxiao);
        EditText et1 = vie.findViewById(R.id.dijia);
        EditText et2 = vie.findViewById(R.id.gaojia);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(getString(et1)) && TextUtils.isEmpty(getString(et2))) {
                    toast("请输入低价");
                } else {
                    if (popupWindow2 != null && popupWindow2.isShowing()) {
                        popupWindow2.dismiss();
                    }
                    prce1 = getString(et1);
                    prce2 = getString(et2);

                    price1 = getString(et1);
                    price2 = getString(et2);
                    getClickPrice(getString(et1), getString(et2));
                }
            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow2 != null && popupWindow2.isShowing()) {
                    popupWindow2.dismiss();
                }
            }
        });
        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        popupWindow2.showAsDropDown(view, 0, 15);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    protected  void getClickPrice(String prce1, String prce2){
        //
        requestData();
    };

    protected List<String> dat = new ArrayList<>();
    private void clickJieDao(View view) {
        if (jiadao == null) {
            return;
        }
        dat.clear();
        for (int i = 0; i < jiadao.getData().size(); i++) {
            dat.add(jiadao.getData().get(i).getName());
        }
        alertWindow(view, dat, 9);
    }
    protected PopupWindow popupWindow;
    AlertAdapter alertAdapter;
    protected RecyclerView recyclerView;
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    protected void alertWindow(View view, List<String> da, int rescode) {
        View vie = View.inflate(MapZhaoFangActivity.this, R.layout.rv, null);
        popupWindow = new PopupWindow(MapZhaoFangActivity.this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        alertAdapter = new AlertAdapter(R.layout.alert_item);
        recyclerView = vie.findViewById(R.id.rv);
        recyclerView.setAdapter(alertAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MapZhaoFangActivity.this));
        alertAdapter.addData(da);
        alertAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View vie, int position) {
                if (popupWindow != null & popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                switch (rescode) {
                    case 9:
                        business_id = jiadao.getData().get(position).getId();
                        ((TextView)view).setText(jiadao.getData().get(position).getName());
                        requestData();
                        //toast(jiadao.getData().get(position).getName());
                        // shuaxin(position);
                        //onRefresh();
                        break;
                    case 11:
                        // 新房数据
                        select1 = position+1 +"";
                        requestData();

//                        select1 = position+1+"";
                        //  select1 = selectBean2CommonListBean.getData().get(position).getAttr_id();
                      //  shuaxin(position);
                        break;

                    case 14:

                        break;

                    case 15:
                        // 户型
                        select1huixing =selectBean2CommonListBean.getData().get(position).getAttr_id();
                        requestData();
                        break;
                }

                // TuiJianViewFragment.this.onItemClick(view,position,rescode);
            }
        });
        // 背景的处理
       // setBackgroundAlpha(0.5f);//设置屏幕透明度
//        vie.findViewById(R.id.shouru).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                start(AddErShouActivity.class);
//                type = 0;
//
//            }
//        });
//        vie.findViewById(R.id.tixian).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                start(AddXieZiActivity.class);
//                type = 0;
//
//            }
//        });
//
//        vie.findViewById(R.id.shangpu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                type = 0;
//                start(AddShangPuActivity.class);
//            }
//        });
//
//        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                start(AddGongChangActivity.class);
//            }
//        });

        popupWindow.showAsDropDown(view, 0, 15);
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        //popupWindow.showAtLocation(vie, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                //setBackgroundAlpha(1.0f);
            }
        });
    }



    @Override
    protected void requestBefore() {
        super.requestBefore();
        //
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        bmapView.onDestroy();
        mSearch.destroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        bmapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        bmapView.onPause();
    }

    private BaiduMap mBaiduMap;
    @Override
    protected void initView() {
        super.initView();
        mBaiduMap = bmapView.getMap();
        setUserMapCenter();

        getCenter();
//        detector = new GestureDetector(this,this);
//        detector.setIsLongpressEnabled(true);
    }
    GeoCoder mSearch;
    private void getCenter() {
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(listener);
//        mSearch.geocode(new GeoCodeOption()
//                .city(SharedPreferencesUtil.getInstance().getString("city"))
//                .address(SharedPreferencesUtil.getInstance().getString("addr")));
//
//  建德市人大常委会

        String city = getSpData("city");
        firstcity = city;
                mSearch.geocode(new GeoCodeOption()
                .city(city)
                .address(city));
//                .address("建德市人大常委会"));
    }

    private String firstcity;

    Map<Double,Double> map = new HashMap<>();

    Map<String,Map<Double,Double>>  maps = new HashMap<>();
    Map<String,Map<Double,Double>>  ershoumaps = new HashMap<>();
    Map<String,Map<Double,Double>>  zufangmaps = new HashMap<>();


    OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {
        public void onGetGeoCodeResult(GeoCodeResult result) {
            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有检索到结果
                mSearch.geocode(new GeoCodeOption()
                        .city(SharedPreferencesUtil.getInstance().getString("city"))
                        .address(SharedPreferencesUtil.getInstance().getString("addr")));
                return;
            }
            //Log.d("sssssssssss",result.getAddress());
            if(!result.getAddress().equals(firstcity)){
                Map<Double,Double> ma = new HashMap<>();
                ma.put(result.getLocation().latitude,result.getLocation().longitude);
                maps.put(result.getAddress(),ma);
                //城市编码完成去绘制  market
                if(beanBeanCommonListBean.getData().size()==maps.size()){
                    // 编码完成  批量添加  market
                    addMarket();
                    addErShouMap();
                    addZuFangMap();
                }
            }

            lat =result.getLocation().latitude;
            lon =result.getLocation().longitude;
            setUserMapCenter();
            //获取地理编码结果
           // Log.i("asdf",result.getLocation().longitude+"");



//            MapEventListener listener = new MapEventListener();
//            mBaiduMap.setOnMapStatusChangeListener(listener);
//            mBaiduMap.setOnMarkerClickListener(listener);
        }

        @Override

        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {

            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有找到检索结果
            }
            //获取反向地理编码结果
        }
    };



    private void addZuFangMap() {
        if(zufangListBean!=null&&zufangListBean.getData()!=null){
            for(Map.Entry<String, Map<Double,Double>> entry: maps.entrySet()) {
                for(BeanBean beanBean: zufangListBean.getData()){
                    if(beanBean.getName().equals(entry.getKey())){
                        zufangmaps.put(entry.getKey() +beanBean.getCount()+"套出租房",entry.getValue());
                        break;
                    }
                }
            }
        }
    }

    private void addErShouMap() {
//        ershouListBean
        if(ershouListBean!=null&&ershouListBean.getData()!=null){
            for(Map.Entry<String, Map<Double,Double>> entry: maps.entrySet()) {
                for(BeanBean beanBean: ershouListBean.getData()){
                    if(beanBean.getName().equals(entry.getKey())){
                        ershoumaps.put(entry.getKey() +beanBean.getCount()+"套二手房",entry.getValue());
                        break;
                    }
                }
            }
        }
    }

    public void addErjiMarket(){
        switch (cur){
            case ZUFANG_COUNT:
                List<OverlayOptions> options = new ArrayList<OverlayOptions>();
                if(zufangjinweib .getData() ==null || zufangjinweib.getData().size()==0){
                    return;
                }
                for(JingWeiBean bean :zufangjinweib.getData()){
                    if(bean.getLat().equals("")||bean.getLng().equals("")){
                        break;
                    }
                    LatLng point1 = new LatLng(Double.parseDouble(bean.getLat()),
                            Double.parseDouble(bean.getLng()));

                    OverlayOptions option1 =  new MarkerOptions()
                            .position(point1)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.tuoyuan));
                    options.add(option1);
                }
                mBaiduMap.addOverlays(options);
                break;

                case NEWHOUSE_COUNT:
                List<OverlayOptions> options1 = new ArrayList<OverlayOptions>();
                if(xinbena .getData() ==null || xinbena.getData().size()==0){
                    return;
                }
                for(JingWeiBean bean :xinbena.getData()){
                    if(bean.getLat().equals("")||bean.getLng().equals("")){
                        break;
                    }
                    LatLng point1 = new LatLng(Double.parseDouble(bean.getLat()),
                            Double.parseDouble(bean.getLng()));

                    OverlayOptions textOption = new TextOptions()
                            .bgColor(0xAAFFFF00)
                            .fontSize(60)
                            .fontColor(0xFFFF00FF)
                            .text("子")
                            .rotate(0)
                            .position(point1);

//                    OverlayOptions option1 =  new MarkerOptions()
//                            .position(point1)
//                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.tuoyuan));
                    options1.add(textOption);
                }
                mBaiduMap.addOverlays(options1);
                break;

            case ERSHOU_COUNT:
                List<OverlayOptions> options2 = new ArrayList<OverlayOptions>();
                if(ershoujiweib .getData() ==null || ershoujiweib.getData().size()==0){
                    return;
                }
                for(JingWeiBean bean :ershoujiweib.getData()){
                    if(bean.getLat().equals("")||bean.getLng().equals("")){
                        break;
                    }
                    LatLng point1 = new LatLng(Double.parseDouble(bean.getLat()),
                            Double.parseDouble(bean.getLng()));

                    OverlayOptions option1 =  new MarkerOptions()
                            .position(point1)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.tuoyuan));
                    options2.add(option1);
                }
                mBaiduMap.addOverlays(options2);
                break;
        }

    }

    private int cur =NEWHOUSE_COUNT;
    private void addMarket() {
        switch (cur){
            case NEWHOUSE_COUNT:
                List<OverlayOptions> options = new ArrayList<OverlayOptions>();
//        for(int i=0;i<map.size();i++){
//            LatLng point1 = new LatLng(map.get(i)., 116.380338);
//        }
                BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.dengguang);
                for(Map.Entry<String, Map<Double,Double>> entry: maps.entrySet()) {
                    // System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
                    for(Map.Entry<Double,Double> mm :entry.getValue().entrySet()){
                        LatLng point1 = new LatLng(mm.getKey(), mm.getValue());
//                OverlayOptions option1 =  new MarkerOptions()
//                        .position(point1)
//                    .icon(bitmap)
//                    .title(entry.getKey());

                        String count = getNumber(entry.getKey());

                        OverlayOptions textOption = new TextOptions()
                                .bgColor(0xAAFFFF00)
                                .fontSize(60)
                                .fontColor(0xFFFF00FF)
                                .text(entry.getKey()+count+"套新房子")
                                .rotate(0)
                                .position(point1);

//                LatLng llCircle = new LatLng(39.90923, 116.447428);
//                OverlayOptions ooCircle = new CircleOptions().fillColor(0x000000FF)
//                        .center(llCircle).stroke(new Stroke(5, 0xAA000000))
//                        .radius(1400);
                        //.;

                        options.add(textOption);
                    }

//            LatLng point1 = new LatLng(entry.getValue()., entry.getValue());
//            OverlayOptions option1 =  new MarkerOptions().position(point1)
//                    .icon(bitmap);
//                   //.title();
//            options.add(option1);
                }
                mBaiduMap.addOverlays(options);
                break;
            case ERSHOU_COUNT:
                List<OverlayOptions> options1 = new ArrayList<OverlayOptions>();
//        for(int i=0;i<map.size();i++){
//            LatLng point1 = new LatLng(map.get(i)., 116.380338);
//        }
                BitmapDescriptor bitmap1 = BitmapDescriptorFactory.fromResource(R.mipmap.dengguang);
                for(Map.Entry<String, Map<Double,Double>> entry: ershoumaps.entrySet()) {
                    // System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
                    for(Map.Entry<Double,Double> mm :entry.getValue().entrySet()){
                        LatLng point1 = new LatLng(mm.getKey(), mm.getValue());
//                OverlayOptions option1 =  new MarkerOptions()
//                        .position(point1)
//                    .icon(bitmap)
//                    .title(entry.getKey());

                        String count = getNumber(entry.getKey());

                        OverlayOptions textOption = new TextOptions()
                                .bgColor(0xAAFFFF00)
                                .fontSize(60)
                                .fontColor(0xFFFF00FF)
                                .text(entry.getKey())
                                .rotate(0)
                                .position(point1);

//                LatLng llCircle = new LatLng(39.90923, 116.447428);
//                OverlayOptions ooCircle = new CircleOptions().fillColor(0x000000FF)
//                        .center(llCircle).stroke(new Stroke(5, 0xAA000000))
//                        .radius(1400);
                        //.;

                        options1.add(textOption);
                    }

//            LatLng point1 = new LatLng(entry.getValue()., entry.getValue());
//            OverlayOptions option1 =  new MarkerOptions().position(point1)
//                    .icon(bitmap);
//                   //.title();
//            options.add(option1);
                }
                mBaiduMap.addOverlays(options1);
                break;
            case ZUFANG_COUNT:
                List<OverlayOptions> options2 = new ArrayList<OverlayOptions>();
//        for(int i=0;i<map.size();i++){
//            LatLng point1 = new LatLng(map.get(i)., 116.380338);
//        }
                BitmapDescriptor bitmap2 = BitmapDescriptorFactory.fromResource(R.mipmap.dengguang);
                for(Map.Entry<String, Map<Double,Double>> entry: zufangmaps.entrySet()) {
                    // System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
                    for(Map.Entry<Double,Double> mm :entry.getValue().entrySet()){
                        LatLng point1 = new LatLng(mm.getKey(), mm.getValue());
//                OverlayOptions option1 =  new MarkerOptions()
//                        .position(point1)
//                    .icon(bitmap)
//                    .title(entry.getKey());

                        String count = getNumber(entry.getKey());

                        OverlayOptions textOption = new TextOptions()
                                .bgColor(0xAAFFFF00)
                                .fontSize(60)
                                .fontColor(0xFFFF00FF)
                                .text(entry.getKey())
                                .rotate(0)
                                .position(point1);

//                LatLng llCircle = new LatLng(39.90923, 116.447428);
//                OverlayOptions ooCircle = new CircleOptions().fillColor(0x000000FF)
//                        .center(llCircle).stroke(new Stroke(5, 0xAA000000))
//                        .radius(1400);
                        //.;

                        options2.add(textOption);
                    }

//            LatLng point1 = new LatLng(entry.getValue()., entry.getValue());
//            OverlayOptions option1 =  new MarkerOptions().position(point1)
//                    .icon(bitmap);
//                   //.title();
//            options.add(option1);
                }
                mBaiduMap.addOverlays(options2);
                break;
        }


    }

    private String getNumber(String key) {
        String conunt = "";
        for(BeanBean beanBean:beanBeanCommonListBean.getData()){
            if(beanBean.getName().equals(key)){
                conunt = beanBean.getCount();
                break;
            }
        }
        return conunt;
    }


    double lat;
    double lon;
    private void setUserMapCenter() {
      //  Log.v("pcw","setUserMapCenter : lat : "+ lat+" lon : " + lon);
//        double lat =Double.parseDouble(SharedPreferencesUtil.getInstance().getString("latitude"));
//        double lon =Double.parseDouble(SharedPreferencesUtil.getInstance().getString("longitude"));
        LatLng cenpt = new LatLng(lat,lon);
        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt)
                .zoom(largezoom)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
//        mBaiduMap.
//        mBaiduMap.ce
        mBaiduMap.setMapStatus(mMapStatusUpdate);
    }


    /**
     * 添加marker
     */
    private void setMarker() {
       // Log.v("pcw","setMarker : lat : "+ lat+" lon : " + lon);
        //定义Maker坐标点
//        LatLng point = new LatLng(lat, lon);
//        //构建Marker图标
//        BitmapDescriptor bitmap = BitmapDescriptorFactory
//                .fromResource(R.drawable.location_marker);
//        //构建MarkerOption，用于在地图上添加Marker
//        OverlayOptions option = new MarkerOptions()
//                .position(point)
//                .icon(bitmap);
//        //在地图上添加Marker，并显示
//        mBaiduMap.addOverlay(option);
    }

}

