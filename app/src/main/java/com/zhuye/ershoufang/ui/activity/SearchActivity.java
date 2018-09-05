package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.SearchAdapter;
import com.zhuye.ershoufang.adapter.home.xiezilou.XieZiAdapter1;
import com.zhuye.ershoufang.adapter.home.xiezilou.XieZiAdapter2;
import com.zhuye.ershoufang.adapter.home.xiezilou.XieZiAdapter3;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CiYuBean;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.CommonHome2Activity;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangActivity;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangDetailActivity;
import com.zhuye.ershoufang.ui.activity.home.XinFangActivity;
import com.zhuye.ershoufang.ui.activity.home.XinFangDetailActivity;
import com.zhuye.ershoufang.ui.activity.home.ZuFangActivity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import com.zhy.view.flowlayout.FlowLayout;
//import com.zhy.view.flowlayout.TagAdapter;
//import com.zhy.view.flowlayout.TagFlowLayout;

public class SearchActivity extends CommonHome2Activity<Common3Bean> {
    private static final int GETDATA = 777;
    @BindView(R.id.xinfang)
    TextView xinfang;
    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.quxiao)
    TextView quxiao;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;
    @BindView(R.id.recycle1)
    RecyclerView recycle1;
    @BindView(R.id.recycle2)
    RecyclerView recycle2;

//    @BindView(R.id.back)
//    ImageView back;
//    @BindView(R.id.ttitle)
//    TextView ttitle;
//    @BindView(R.id.subtitle)
//    TextView subtitle;
//    @BindView(R.id.recycle)
//    RecyclerView recycle;
//    @BindView(R.id.refresh)
//    SmartRefreshLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.activity_search;
    }


    //
//    @Override
//    protected void initView() {
//        super.initView();
//        hide(subtitle);
//        setText(ttitle,"搜索");
//
//        adapter2 = new SearchAdapter(R.layout.search_item);
//        recycle.setAdapter(adapter2);
//        recycle.setLayoutManager(new LinearLayoutManager(this));
//
//
//    }   // TODO: 2018/6/5 0005 gson   Oberverable  继承
//
//


//    @Override
//    protected void convertdata(Base o) {
//        super.convertdata(o);
////        List<Common3Bean> da1 = new ArrayList<>();
//        try {
//            list = (List<Common3Bean>) o;
//        } catch (ClassCastException e) {
//            List<Common5Bean> da = (List<Common5Bean>) o;
//
//            Observable.fromIterable(da)
//                    .concatMap(new Function<Common5Bean, Observable<Common3Bean>>() {
//                        @Override
//                        public Observable<Common3Bean> apply(Common5Bean common5Bean) throws Exception {
//                            return ;
//                        }
//                    }).subscribe(new Observer<Common3Bean>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//
//                }
//
//                @Override
//                public void onNext(Common3Bean common3Bean) {
//                    list.add(common3Bean);
//                }
//
//                @Override
//                public void onError(Throwable e) {
//
//                }
//
//                @Override
//                public void onComplete() {
//
//                }
//            });
//        }
//
//    }

    private int type = XINFANG;
    private final static int XINFANG = 150;
    private final static int ERSHOUFANG = 151;
    private final static int ZUFANG = 152;


    XieZiAdapter1 adapter1;
    XieZiAdapter2 adapter2;
    XieZiAdapter3 adapter3;


    private  int page  = 1;
    private  int page1 =1;
    private  int page2 =1;

    private final static int LIST= 10258;
    private final static int LIST1= 10259;
    private final static int LIST2= 10260;


    private final static int SHUAXIN= 10261;
    private final static int SHUAXIN1= 10262;
    private final static int SHUAXIN2= 10263;



    private final static int MORE= 10264;
    private final static int MORE1= 10265;
    private final static int MORE2= 10266;


    @Override
    protected void initView() {
        super.initView();
        adapter = new SearchAdapter(R.layout.search_item);

    }

    CommonListBean<CiYuBean> bean;


    List<Common5Bean> totalxin = new ArrayList<>();
    CommonListBean<Common5Bean>  tempxin ;


    List<Common3Bean>   totalershou = new ArrayList<>();
    CommonListBean<Common3Bean>  tempershou;

    List<Common3Bean>   totalzulin = new ArrayList<>();
    CommonListBean<Common3Bean>  tempzulin;

    @Override
    public void success(int requestcode, Base o) {
        //super.success(requestcode, o);
        switch (requestcode) {

            case LIST:
                tempxin = (CommonListBean)o;
                totalxin = tempxin.data;
                if(totalxin!=null && totalxin.size()>0){
                    adapter1.replaceData(totalxin);
                }
                break;
            case SHUAXIN:
                tempxin = (CommonListBean)o;
                // TODO: 2018/5/9 0009 反复试youbug
                if(totalxin!=null && totalxin.size()>0){
                    totalxin.clear();
                    totalxin.addAll(tempxin.data);
                    adapter1.replaceData(totalxin);
                }
                refresh.finishRefresh();
                break;
            case MORE:
                tempxin = (CommonListBean)o;
                if(tempxin.data!=null && tempxin.data.size()>0){
                    totalxin.addAll(tempxin.data);
                    if(totalxin!=null && totalxin.size()>0){
                        adapter1.replaceData(totalxin);
                    }
                }
                refresh.finishLoadmore();
                break;
            case LIST1:
                tempershou = (CommonListBean)o;
                totalershou = tempershou.data;
                if(totalershou!=null && totalershou.size()>0){
                    adapter2.replaceData(totalershou);
                }
                break;
            case SHUAXIN1:
                tempershou = (CommonListBean)o;
                // TODO: 2018/5/9 0009 反复试youbug
                if(totalershou!=null && totalershou.size()>0){
                    totalershou.clear();
                    totalershou.addAll(tempershou.data);
                    adapter2.replaceData(totalershou);
                }
                refresh.finishRefresh();
                break;
            case MORE1:
                tempershou = (CommonListBean)o;
                if(tempershou.data!=null && tempershou.data.size()>0){
                    totalershou.addAll(tempershou.data);
                    if(totalershou!=null && totalershou.size()>0){
                        adapter2.replaceData(totalershou);
                    }
                }
                refresh.finishLoadmore();
                break;
            case LIST2:
                tempzulin = (CommonListBean)o;
                totalzulin = tempzulin.data;
                if(totalzulin!=null && totalzulin.size()>0){
                    adapter3.replaceData(totalzulin);
                }
                break;
            case SHUAXIN2:
                tempzulin = (CommonListBean)o;
                // TODO: 2018/5/9 0009 反复试youbug
                if(totalzulin!=null && totalzulin.size()>0){
                    totalzulin.clear();
                    totalzulin.addAll(tempzulin.data);
                    adapter3.replaceData(totalzulin);
                }
                refresh.finishRefresh();
                break;
            case MORE2:
                tempzulin = (CommonListBean)o;
                if(tempzulin.data!=null && tempzulin.data.size()>0){
                    totalzulin.addAll(tempzulin.data);
                    if(totalzulin!=null && totalzulin.size()>0){
                        adapter3.replaceData(totalzulin);
                    }
                }
                refresh.finishLoadmore();
                break;


            case GETDATA:
//                bean = (CommonListBean<CiYuBean>) o;
//
//                List<String> dd = new ArrayList<>();
//                for (CiYuBean d: bean){
//
//
//                mFlowLayout.setAdapter(new TagAdapter<String>(mVals)
//                {
//                    @Override
//                    public View getView(FlowLayout parent, int position, String s)
//                    {
//                        TextView tv = (TextView) mInflater.inflate(R.layout.tv,
//                                mFlowLayout, false);
//                        tv.setText(s);
//                        return tv;
//                    }
//                });
                bean = (CommonListBean<CiYuBean>) o;
                idFlowlayout.setAdapter(new TagAdapter<CiYuBean>(bean.getData()) {
                    @Override
                    public View getView(FlowLayout parent, int position, CiYuBean ciYuBean) {
                        View tv = getLayoutInflater().inflate(R.layout.tv,
                                idFlowlayout, false);
                        TextView tvvs = tv.findViewById(R.id.tvvs);
                        tvvs.setText(ciYuBean.getMessage());
                        return tv;
                    }

//                    @Override
//                    public View getView(FlowLayout parent, int position, CityBean s)
//                    {
//                        TextView tv = (TextView) getLayoutInflater().inflate(R.layout.tv,
//                                idFlowlayout, false);
//                        tv.setText(s);
//                        return tv;
//                    }
                });

                break;
        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(SearchActivity.this, XinFangDetailActivity.class);
                intent.putExtra("id",totalxin.get(position).getId());
                startActivity(intent);
            }
        });

        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(SearchActivity.this, ErShouFangDetailActivity.class);
                intent.putExtra("id",totalershou.get(position).getLife_id());
                startActivity(intent);
            }
        });
        adapter3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(SearchActivity.this, ErShouFangDetailActivity.class);
                intent.putExtra("id",totalzulin.get(position).getLife_id());
                startActivity(intent);
            }
        });

        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if(TextUtils.isEmpty(sear)){
                    toast("请输入搜索内容");
                    }else {
                    getData(LOADMOREBASE,sear);
                }

            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                if(TextUtils.isEmpty(sear)){
                    toast("请输入搜索内容");
                }else {
                    getData(REFRESHBASE,sear);
                }
            }
        });

        idFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
//                Toast.makeText(SearchActivity.this, bean.getData().get(position).getMessage(), Toast.LENGTH_SHORT).show();

                input.setText(bean.getData().get(position).getMessage());
                serrch(bean.getData().get(position).getMessage());
                getData(LIST,bean.getData().get(position).getMessage());
                return true;
            }
        });
    }

    private void serrch(String message) {

    }

    @Override
    protected void initData() {
        super.initData();
        // CommonApi.getInstance().getSearchData("", PageUtils.FIRSTPAGE, SearchActivity.this, LIST);
        CommonApi.getInstance().ciyu(SearchActivity.this, GETDATA);

//        CommonApi.getInstance().ciyu(SearchActivity.this, GETDATA)
//                .map(new Function() {
//                    @Override
//                    public Object apply(Object o) throws Exception {
//                        return o;
//                    }
//                });


//        CommonApi.getInstance().indexnewhouse2(getQuId(),
//                "", "",
//                "", 1, 1, key, is_recommand
//                , SearchActivity.this, LIST);

        adapter1 = new XieZiAdapter1(R.layout.home_xinfang_item);
        adapter2 = new XieZiAdapter2(R.layout.home_xinfang_item);
        adapter3 = new XieZiAdapter3(R.layout.home_xinfang_item);

        recycle.setAdapter(adapter1);
        recycle1.setAdapter(adapter2);
        recycle2.setAdapter(adapter3);



        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle1.setLayoutManager(new LinearLayoutManager(this));
        recycle2.setLayoutManager(new LinearLayoutManager(this));
        setKeJian(recycle,recycle1,recycle2);


       // getData(LIST, "");
    }

    public void setKeJian(View... args){
        View tv0 = args[0];
        tv0.setVisibility(View.VISIBLE);

        for (int i = 1; i < args.length; i++) {
            args[i].setVisibility(View.GONE);
        }
    }
    String is_recommand;

    private void getData(int code, String key) {
        switch (type) {
            case XINFANG:
                switch (code) {
                    case LIST:
                        CommonApi.getInstance().indexnewhouse2(getQuId(),
                                "", "",
                                "", 1, 1, key, is_recommand
                                , SearchActivity.this, LIST);
                        break;
                    case REFRESHBASE:
                        CommonApi.getInstance().indexnewhouse2(getQuId(),
                                "", "",
                                "", 1, 1, key, is_recommand
                                , SearchActivity.this, SHUAXIN);
                        break;
                    case LOADMOREBASE:
                        CommonApi.getInstance().indexnewhouse2(getQuId(),
                                "", "",
                                "", 1, ++page,
                                key, is_recommand,
                                SearchActivity.this
                                , MORE);
                        break;
                }
                break;
            case ERSHOUFANG:
                switch (code) {
                    case LIST:
                        CommonApi.getInstance().index("3", getQuId(), 1,
                                "", "",
                                "", "",
                                "", key,
                                SearchActivity.this, LIST1);
                        break;
                    case REFRESHBASE:
                        CommonApi.getInstance().index("3", getQuId(), 1
                                , "", "",
                                "", "",
                                "", key,
                                SearchActivity.this, SHUAXIN1);
                        break;
                    case LOADMOREBASE:
                        CommonApi.getInstance().index("3", getQuId(),
                                ++page1, "",
                                "", "", "",
                                "", key,
                                SearchActivity.this, MORE1);
                        break;
                }
                break;

            case ZUFANG:
                switch (code) {
                    case LIST:
                        CommonApi.getInstance().index("4", getQuId(),
                                1, "",
                                "", "", "",
                                "", key,
                                SearchActivity.this, LIST2);
                        break;
                    case REFRESHBASE:
                        CommonApi.getInstance().index("4", getQuId(),
                                1, "",
                                "", "",
                                "",
                                "", key,
                                SearchActivity.this,
                                SHUAXIN2);
                        break;
                    case LOADMOREBASE:
                        CommonApi.getInstance().index("4",
                                getQuId(),
                                ++page2, "",
                                "", "", "",
                                "", key,
                                SearchActivity.this,
                                MORE2);
                        break;
                }
                break;
        }
        //CommonApi.getInstance()
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    String sear;

    @Override
    protected void onLoadmore() {
        getData(LOADMOREBASE, sear);
    }

    @Override
    protected void onRefresh() {
        getData(REFRESHBASE, sear);
    }


    @OnClick({R.id.xinfang, R.id.input, R.id.quxiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xinfang:
                dat.clear();
                dat.add("新房");
                dat.add("二手房");
                dat.add("租房");
                alertWindow(view, dat, 11);
                break;
            case R.id.input:
                break;
            case R.id.quxiao:
                if (checkEmpty(input, "请输入搜索内容")) {
                    sear = getString(input);
                    getData(LIST, sear);
                }
                break;
        }
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        //清空数据
        list.clear();
        switch (rescode) {
            case 11:
                switch (position) {
                    case 0:
                        type = XINFANG;
                        xinfang.setText("新房");
                        setKeJian(recycle,recycle1,recycle2);
                        break;
                    case 1:
                        type = ERSHOUFANG;
                        xinfang.setText("二手房");
                        setKeJian(recycle1,recycle,recycle2);
                        break;
                    case 2:
                        type = ZUFANG;
                        xinfang.setText("租房");
                        setKeJian(recycle2,recycle1,recycle);
                        break;
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    //
//    @Override
//    public void success(int requestcode, Base base) {
//        super.success(requestcode, base);
//        PageUtils.handleData(SearchActivity.this,requestcode,base,adapter2, refresh);
//    }
//
//    @Override
//    protected void initListener() {
//        super.initListener();
//        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
//            @Override
//            public void onLoadmore(RefreshLayout refreshlayout) {
//               // PageUtils.requestBefore();
//                CommonApi.getInstance().getSearchData("",PageUtils.requestPage, SearchActivity.this,LOADMORE);
//            }
//
//            @Override
//            public void onRefresh(RefreshLayout refreshlayout) {
//                //PageUtils.requestBefore();
//                CommonApi.getInstance().getSearchData("",PageUtils.FIRSTPAGE, SearchActivity.this,REFRESH);
//            }
//        });
//    }
//
//    @OnClick(R.id.back)
//    public void onViewClicked() {
//        finish();
//    }
}
