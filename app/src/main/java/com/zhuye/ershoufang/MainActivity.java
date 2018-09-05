package com.zhuye.ershoufang;


import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.QuBean;
import com.zhuye.ershoufang.bean.UBean;
import com.zhuye.ershoufang.chat.GlobalListener;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.LoginActivity;
import com.zhuye.ershoufang.ui.fragment.ChatFragment3;
import com.zhuye.ershoufang.ui.fragment.FabuFragment;
import com.zhuye.ershoufang.ui.fragment.HomeFragment;
import com.zhuye.ershoufang.ui.fragment.MeFragment;
import com.zhuye.ershoufang.ui.fragment.TuiJianFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.ChuZuFragment;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;
import com.zhuye.ershoufang.weidtet.MyFragmentTabHost;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;
import me.iwf.photopicker.PhotoPicker;

public class MainActivity extends BaseActivity {

    private static final int DINGWEI = 600;
    private static final int GETINFO = 84541;
    @BindView(R.id.home_framelayout)
    FrameLayout homeFramelayout;
    @BindView(android.R.id.content)
    FrameLayout content;
    @BindView(R.id.home_fragmenttabhost)
    MyFragmentTabHost homeFragmenttabhost;
    @BindView(R.id.threeimg)
    ImageView threeimg;

    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    public ArrayList<String> photos;

    @Override
    protected int getResId() {
        return R.layout.activity_main;
    }

    String[] tabnames;


    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case DINGWEI:
                CommonObjectBean<QuBean> qu = (CommonObjectBean<QuBean>) base;
                if(qu.getData()==null||qu.getData().getCity_id()==null){
                    return;
                }
//                SharedPreferencesUtil.getInstance().putString("qu_id",qu.getData().getCity_id());
                SharedPreferencesUtil.getInstance().putString("qu_id","12743");
                break;

            case GETINFO:
                CommonObjectBean<UBean> beanCommonObjectBean = (CommonObjectBean<UBean>) base;
                RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
                    @Override
                    public UserInfo getUserInfo(String s) {
                        String face = beanCommonObjectBean.getData().getFace();
                        if(!face.contains("http")){
                            face = NetWorkUrl.IMAGEURL+face;
                        }
                        return new UserInfo(beanCommonObjectBean.getData().getUser_id()
                                ,beanCommonObjectBean.getData().getNickname(), Uri.parse(face));
                    }
                },true);
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        tabnames = this.getResources().getStringArray(R.array.bottom_title);

        tabfragment.add(HomeFragment.class);
     // tabfragment.add(initConversationList().getClass());
       tabfragment.add(ChatFragment3.class);
        tabfragment.add(FabuFragment.class);
        tabfragment.add(TuiJianFragment.class);
        tabfragment.add(MeFragment.class);

        tabimage.add(R.drawable.home_sel);
        tabimage.add(R.drawable.chat_sel);
        tabimage.add(R.drawable.fabu);
        tabimage.add(R.drawable.tuijian_sel);
        tabimage.add(R.drawable.me_sel);


        initTab();
        initLocation();


//        OkGo.<String>post("http://api.htp.hubcloud.com.cn:45600/json/v1/sdk0")
//                .params("version","1.8.7")
//                .params("srcType","1")
//                .params("reqType","1")
//                .params("timeStamp", SystemClock.currentThreadTimeMillis())
//                .params("appid","216")
//                .params("appVersion","1.0")
//                .params("devInfo","1.8.7")
//                .params("envInfo","1.8.7")
//                .params("adReqInfo","1.8.7")
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        Log.i("as",response.body());
//                    }
//
//                    @Override
//                    public void onError(Response<String> response) {
//                        super.onError(response);
//                        Log.i("as",response.body());
//                    }
//                });

//        int a = 10/0;
//        int c = 0;
//        int b = a/c;
        //Log.i("asd",a+"");

        Boolean b =  getIntent().getBooleanExtra("one",false);
        if(b){
            homeFragmenttabhost.setCurrentTab(0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initLocation() {
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数


        LocationClientOption option = new LocationClientOption();

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//可选，设置定位模式，默认高精度
//LocationMode.Hight_Accuracy：高精度；
//LocationMode. Battery_Saving：低功耗；
//LocationMode. Device_Sensors：仅使用设备；

        option.setCoorType("bd09ll");
//可选，设置返回经纬度坐标类型，默认gcj02
//gcj02：国测局坐标；
//bd09ll：百度经纬度坐标；
//bd09：百度墨卡托坐标；
//海外地区定位，无需设置坐标类型，统一返回wgs84类型坐标

        option.setScanSpan(1000);
//可选，设置发起定位请求的间隔，int类型，单位ms
//如果设置为0，则代表单次定位，即仅定位一次，默认为0
//如果设置非0，需设置1000ms以上才有效

        option.setOpenGps(true);
//可选，设置是否使用gps，默认false
//使用高精度和仅用设备两种定位模式的，参数必须设置为true

        option.setLocationNotify(true);
//可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false

        option.setIgnoreKillProcess(false);
//可选，定位SDK内部是一个service，并放到了独立进程。
//设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)

        option.SetIgnoreCacheException(false);
//可选，设置是否收集Crash信息，默认收集，即参数为false

        option.setWifiCacheTimeOut(5*60*1000);
//可选，7.2版本新增能力
//如果设置了该接口，首次启动定位时，会先判断当前WiFi是否超出有效期，若超出有效期，会先重新扫描WiFi，然后定位

        option.setEnableSimulateGps(false);
//可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false


        option.setIsNeedAddress(true);

        mLocationClient.setLocOption(option);
//mLocationClient为第二步初始化过的LocationClient对象
//需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
//更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明

        mLocationClient.start();
    }


    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location){
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
            double latitude = location.getLatitude();    //获取纬度信息

            double longitude = location.getLongitude();    //获取经度信息
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f
            String coorType = location.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
            int errorCode = location.getLocType();
            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
            String addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息

            // // TODO: 2018/6/21 0021  定位失败


          //  toast(latitude+city==null?"定位失败":city);
            String citycode =   location.getCityCode();

            CommonApi.getInstance().dingwei(city,district,MainActivity.this,DINGWEI);

//            OkGo.<String>post("http://192.168.1.13/jdhouse/index.php/app/index/dingwei").params("city",city).params("area",district)
//                    .execute(new StringCallback() {
//                        @Override
//                        public void onSuccess(Response<String> response) {
//                            Log.i("asd",response.body());
//                        }
//
//                        @Override
//                        public void onError(Response<String> response) {
//                            super.onError(response);
//                            Log.i("asd",response.body());
//                        }
//                    });



            SharedPreferencesUtil.getInstance().putString("latitude",latitude+"");
            SharedPreferencesUtil.getInstance().putString("longitude",longitude+"");
            SharedPreferencesUtil.getInstance().putString("addr",addr+"");
            SharedPreferencesUtil.getInstance().putString("province",province+"");


            SharedPreferencesUtil.getInstance().putString("city",city+"");
            SharedPreferencesUtil.getInstance().putString("city","建德市");
            SharedPreferencesUtil.getInstance().putString("district",district+"");


            SharedPreferencesUtil.getInstance().putString("street",street+"");

            mLocationClient.unRegisterLocationListener(myListener);

            changCity();
        }
    }

    private void changCity() {
        List<Fragment>  fragmen =  getSupportFragmentManager().getFragments();
        //Fragment hm= fragmen.get(0);

        // toast(fragmen.size()+"");

         // // TODO: 2018/6/13 0013 通信问题
        try {
            for (Fragment fragment: fragmen){
                if (fragment instanceof HomeFragment){
                    ((HomeFragment) fragment).setCity(getSpData("city"));
                   // ((HomeFragment) fragment).getData(citycode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private List<Class> tabfragment = new ArrayList<>();
    private List<Integer> tabimage = new ArrayList<>();

    private void initTab() {
        homeFragmenttabhost.setup(this, getSupportFragmentManager(), R.id.home_framelayout);
        for (int i = 0; i < 5; i++) {
            View v = View.inflate(this, R.layout.tabview, null);
            ImageView tabiv = v.findViewById(R.id.tab_view);
            TextView tv = v.findViewById(R.id.tab_tv);
            // ImageView iv = v.findViewById(R.id.tab_view);
            tabiv.setImageResource(tabimage.get(i));

            ViewGroup.LayoutParams params = tabiv.getLayoutParams();

//            if(i==2){
//                params.height= DensityUtil.dip2px(MainActivity.this,45f);
//                params.width=  DensityUtil.dip2px(MainActivity.this,45f);
//                tabiv.setBottom(DensityUtil.dip2px(MainActivity.this,35f));
//                tabiv.setLayoutParams(params);
//            }else {
//                params.height= DensityUtil.dip2px(MainActivity.this,21f);
//                params.width=  DensityUtil.dip2px(MainActivity.this,21f);
//                tabiv.setLayoutParams(params);
//            }

            if (i == 2) {
                tabiv.setVisibility(View.INVISIBLE);
            } else {
                tabiv.setVisibility(View.VISIBLE);
            }
            tv.setText(tabnames[i]);
            TabHost.TabSpec view = homeFragmenttabhost.newTabSpec(tabnames[i]).setIndicator(v);
            homeFragmenttabhost.addTab(view, tabfragment.get(i), null);
        }
    }



    // 是否需要变（是否点击了第三个）
    protected Boolean  isneed = false;
    @Override
    protected void initListener() {
        super.initListener();


        // 非普通用户不能发布
        if(isNeedLogin()){
            homeFragmenttabhost.getTabWidget().getChildTabViewAt(2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    start(LoginActivity.class);
                }
            });
        }else{
            if(getSpData("type")!=null){
                if(getSpData("type").equals("0")){

                }else {
                    homeFragmenttabhost.getTabWidget().getChildTabViewAt(2).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toast("只有普通用户可以发布");
                        }
                    });
                }
            }
        }




        if(getToken()==null|| TextUtils.isEmpty(getToken())){
            homeFragmenttabhost.getTabWidget().getChildTabViewAt(4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    start(LoginActivity.class);
                }
            });
        }



        homeFragmenttabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s.equals(tabnames[2])) {
                        // 加一个属性动画   rotation 围绕z轴逆时针转动 45度
                        ObjectAnimator animator = ObjectAnimator.ofFloat(threeimg,"rotation",0,45);
                        animator.setDuration(200);
                        animator.start();
                    isneed =true;
                }else {
                    if(isneed){
                        ObjectAnimator animator = ObjectAnimator.ofFloat(threeimg,"rotation",45,0);
                        animator.setDuration(200);
                        animator.start();
                    }
                    isneed = false;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
//            if (data != null) {
//                photos   = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
////                neituimg.clear();
////                neituimg.addAll(photos);
////                neituimg.add("");
////                adapter.addData(neituimg);
//            }
//        }

        ArrayList<String> photos = new ArrayList<>();
        if (data != null) {
            photos =
                    data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
        }
        switch (requestCode) {
            case 1000:
                //shineitut.setPhoto(photos);
               // FabuFragment fabuFragment =  tabfragment.get(2);
                List<Fragment>  fragments =  getSupportFragmentManager().getFragments();
               // toast(fragments.size()+"");

                try {
                    for (Fragment fragment: fragments){
                        if(fragment instanceof FabuFragment){
                            FabuFragment ff = (FabuFragment) fragment;
                          ChuZuFragment fragment1 =  ff.getChuZuFragment();
                          MySelectPhotoView  mySelectPhotoView = fragment1.getMySelectPhotoView();
                          mySelectPhotoView.setPhoto(photos);
//                            ((FabuFragment) fragment).getChuZuFragment().getMySelectPhotoView().setPhoto(photos);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                FabuFragment fabuFragment = (FabuFragment) fragments.get(0);
//                fabuFragment.getChuZuFragment().getMySelectPhotoView().setPhoto(photos);
                break;


        }

        switch (resultCode){
            case 100:
                // TODO: 2018/6/6 0006    home 设置数据
                String city =  data.getStringExtra("city");
                city = "建德市"; //12743
                String citycode =  data.getStringExtra("qu_id");
                List<Fragment>  fragmen =  getSupportFragmentManager().getFragments();
                //Fragment hm= fragmen.get(0);

               // toast(fragmen.size()+"");
                try {
                    for (Fragment fragment: fragmen){
                        if (fragment instanceof HomeFragment){
                            ((HomeFragment) fragment).setCity(city);
                            ((HomeFragment) fragment).getData(citycode);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                if(hm instanceof HomeFragment){
//                    ((HomeFragment)hm).setCity(city);
//                    ((HomeFragment)hm).getData(citycode);
//                }
                //hm.getChuZuFragment().getMySelectPhotoView().setPhoto(photos);

                break;
        }
    }




    public void setPhotos(){

    }


    @Override
    protected void initData() {
        super.initData();

        addActivity(this);

        connectRongYun();


        String user_id = getSpData("user_id");
        if(user_id!=null){
            CommonApi.getInstance().msg(user_id,this,GETINFO,false);
        }


        GlobalListener.init(MainActivity.this);
    }

    protected  void isObey(Activity activity,Class clas){
        if(getToken()==null){
            start(LoginActivity.class);
        }else{
           start(clas);
        }
    }

    private void connectRongYun() {
        String token = getrongyun();
        if (getApplicationInfo().packageName.equals(Applaion.getCurProcessName(getApplicationContext()))) {
            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                @Override
                public void onTokenIncorrect() {
                  ///  toast("onTokenIncorrect");
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                @Override
                public void onSuccess(String userid) {
                   // Log.d("LoginActivity", "--onSuccess" + userid);
                    //startActivity(new Intent(LoginActivity.this, MainActivity.class));
                  //  finish();
                    //toast("onSuccess");

                    //GlobalListener.init(MainActivity.this);



                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
//                    Log.d("LoginActivity", "--onError" + errorCode);
//                    toast("onError");
                }
            });
        }
    }


    private ConversationListFragment mConversationListFragment = null;
    private boolean isDebug;
    private Context mContext;
    private Conversation.ConversationType[] mConversationsTypes = null;
    private Fragment initConversationList() {
        if (mConversationListFragment == null) {
            ConversationListFragment listFragment = new ConversationListFragment();
            //listFragment.setAdapter(new ConversationListAdapterEx(RongContext.getInstance()));
            Uri uri;
            if (isDebug) {
                uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                        .appendPath("conversationlist")
                        .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "true") //设置私聊会话是否聚合显示
                        .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")//群组
                        .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")//公共服务号
                        .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")//订阅号
                        .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")//系统
                        .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "true")
                        .build();
                mConversationsTypes = new Conversation.ConversationType[]{Conversation.ConversationType.PRIVATE,
                        Conversation.ConversationType.GROUP,
                        Conversation.ConversationType.PUBLIC_SERVICE,
                        Conversation.ConversationType.APP_PUBLIC_SERVICE,
                        Conversation.ConversationType.SYSTEM,
                        Conversation.ConversationType.DISCUSSION
                };

            } else {
                uri = Uri.parse("rong://" +  getApplicationInfo().packageName).buildUpon()
                        .appendPath("conversationlist")
                        .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示
                        .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//群组
                        .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")//公共服务号
                        .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")//订阅号
                        .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")//系统
                        .build();
                mConversationsTypes = new Conversation.ConversationType[]{Conversation.ConversationType.PRIVATE,
                        Conversation.ConversationType.GROUP,
                        Conversation.ConversationType.PUBLIC_SERVICE,
                        Conversation.ConversationType.APP_PUBLIC_SERVICE,
                        Conversation.ConversationType.SYSTEM
                };
            }
            listFragment.setUri(uri);
            mConversationListFragment = listFragment;
            return listFragment;
        } else {
            return mConversationListFragment;
        }
    }
    protected Long exitTime = 0l;
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }

    }



}
