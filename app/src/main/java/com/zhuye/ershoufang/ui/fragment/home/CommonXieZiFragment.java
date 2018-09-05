package com.zhuye.ershoufang.ui.fragment.home;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.SingleChooseTvAdapter;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.adapter.home.TvAdapter3;
import com.zhuye.ershoufang.adapter.home.xiezilou.XieZiAdapter1;
import com.zhuye.ershoufang.adapter.home.xiezilou.XieZiAdapter2;
import com.zhuye.ershoufang.adapter.home.xiezilou.XieZiAdapter3;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.SingleChooseBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.XinFangDetailActivity;
import com.zhuye.ershoufang.ui.activity.home.XinPanDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2018/3/19 0019.
 */

public class CommonXieZiFragment extends BaseFragment {

    private static final int GETDATA = 78977;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.footer)
    ClassicsFooter footer;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;
    @BindView(R.id.xinfang)
    TextView xinfang;
    @BindView(R.id.ershou)
    TextView ershou;
    @BindView(R.id.zulin)
    TextView zulin;
    @BindView(R.id.di1)
    TextView di1;
    @BindView(R.id.di2)
    TextView di2;
    @BindView(R.id.di3)
    TextView di3;
    @BindView(R.id.di4)
    TextView di4;
    @BindView(R.id.di5)
    RelativeLayout di5;
    @BindView(R.id.jia1)
    TextView jia1;
    @BindView(R.id.jia2)
    TextView jia2;
    @BindView(R.id.jia3)
    TextView jia3;
    @BindView(R.id.jia4)
    TextView jia4;
    Unbinder unbinder1;
    @BindView(R.id.recycle2)
    RecyclerView recycle2;
    @BindView(R.id.recycle3)
    RecyclerView recycle3;
    Unbinder unbinder2;
    @BindView(R.id.jiagerv)
    RecyclerView jiagerv;


//    @Override
//    public BaseQuickAdapter getAdapter() {
//        return adapte;
//    }
//
//    @Override
//    public SmartRefreshLayout getSmartRefreshLayout() {
//        return refresh;
//    }
//
//    @Override
//    protected void onLoadmore() {
//        CommonApi.getInstance().index(cate_id, getQuId(), ++page,
//                "", price1, price2, select1, yonghu, key,
//                CommonXieZiFragment.this, LOADMOREBASE);
//    }
//
//    @Override
//    protected void onRefresh() {
//        CommonApi.getInstance().index(cate_id, getQuId(), 1,
//                "", price1, price2, select1, yonghu, key,
//                CommonXieZiFragment.this, REFRESHBASE);
//    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.fragment_xiezi;
    }


    XieZiAdapter1 adapter1;
    XieZiAdapter2 adapter2;
    XieZiAdapter3 adapter3;


    private int page = 1;
    private int page1 = 1;
    private int page2 = 1;

    private final static int LIST = 10258;
    private final static int LIST1 = 10259;
    private final static int LIST2 = 10260;


    private final static int SHUAXIN = 10261;
    private final static int SHUAXIN1 = 10262;
    private final static int SHUAXIN2 = 10263;


    private final static int MORE = 10264;
    private final static int MORE1 = 10265;
    private final static int MORE2 = 10266;


    String business_id;
    String price1;
    String price2;
    String select1;
    String yonghu;
    String key;


    List<Common5Bean> totalxin = new ArrayList<>();
    CommonListBean<Common5Bean> tempxin;


    List<Common3Bean> totalershou = new ArrayList<>();
    CommonListBean<Common3Bean> tempershou;

    List<Common3Bean> totalzulin = new ArrayList<>();
    CommonListBean<Common3Bean> tempzulin;

    protected CityBean jiadao;

    @Override
    public void success(int requestcode, Base o) {
        switch (requestcode) {
            case GETDATA:
                jiadao = (CityBean) o;
                if (jiadao != null && jiadao.getData() != null) {
                    if (jiadao.getData().size() == 1) {
                        di1.setText(jiadao.getData().get(0).getName());
                    } else if (jiadao.getData().size() == 2) {
                        di1.setText(jiadao.getData().get(0).getName());
                        di2.setText(jiadao.getData().get(1).getName());
                    } else if (jiadao.getData().size() == 3) {
                        di1.setText(jiadao.getData().get(0).getName());
                        di2.setText(jiadao.getData().get(1).getName());
                        di3.setText(jiadao.getData().get(2).getName());
                    } else if (jiadao.getData().size() >= 4) {
                        di1.setText(jiadao.getData().get(0).getName());
                        di2.setText(jiadao.getData().get(1).getName());
                        di3.setText(jiadao.getData().get(2).getName());
                        di4.setText(jiadao.getData().get(3).getName());
                    }
                }
                break;
            case LIST:
                tempxin = (CommonListBean) o;
                totalxin = tempxin.data;
                if (totalxin != null && totalxin.size() > 0) {
                    adapter1.replaceData(totalxin);
                }
                break;
            case SHUAXIN:
                tempxin = (CommonListBean) o;
                // TODO: 2018/5/9 0009 反复试youbug
                if (totalxin != null && totalxin.size() >= 0) {
                    totalxin.clear();
                    totalxin.addAll(tempxin.data);
                    adapter1.replaceData(totalxin);
                }
                refresh.finishRefresh();
                break;
            case MORE:
                tempxin = (CommonListBean) o;
                if (tempxin.data != null && tempxin.data.size() > 0) {
                    totalxin.addAll(tempxin.data);
                    if (totalxin != null && totalxin.size() > 0) {
                        adapter1.replaceData(totalxin);
                    }
                }
                refresh.finishLoadmore();
                break;
            case LIST1:
                tempershou = (CommonListBean) o;
                totalershou = tempershou.data;
                if (totalershou != null && totalershou.size() > 0) {
                    adapter2.replaceData(totalershou);
                }
                break;
            case SHUAXIN1:
                tempershou = (CommonListBean) o;
                // TODO: 2018/5/9 0009 反复试youbug
                if (totalershou != null && totalershou.size() >= 0) {
                    totalershou.clear();
                    totalershou.addAll(tempershou.data);
                    adapter2.replaceData(totalershou);
                }
                refresh.finishRefresh();
                break;
            case MORE1:
                tempershou = (CommonListBean) o;
                if (tempershou.data != null && tempershou.data.size() > 0) {
                    totalershou.addAll(tempershou.data);
                    if (totalershou != null && totalershou.size() > 0) {
                        adapter2.replaceData(totalershou);
                    }
                }
                refresh.finishLoadmore();
                break;
            case LIST2:
                tempzulin = (CommonListBean) o;
                totalzulin = tempzulin.data;
                if (totalzulin != null && totalzulin.size() > 0) {
                    adapter3.replaceData(totalzulin);
                }
                break;
            case SHUAXIN2:
                tempzulin = (CommonListBean) o;
                // TODO: 2018/5/9 0009 反复试youbug
                if (totalzulin != null && totalzulin.size() >= 0) {
                    totalzulin.clear();
                    totalzulin.addAll(tempzulin.data);
                    adapter3.replaceData(totalzulin);
                }
                refresh.finishRefresh();
                break;
            case MORE2:
                tempzulin = (CommonListBean) o;
                if (tempzulin.data != null && tempzulin.data.size() > 0) {
                    totalzulin.addAll(tempzulin.data);
                    if (totalzulin != null && totalzulin.size() > 0) {
                        adapter3.replaceData(totalzulin);
                    }
                }
                refresh.finishLoadmore();
                break;
        }
    }

    List<SingleChooseBean>  current = new ArrayList<>();
    List<SingleChooseBean>  jiageyi = new ArrayList<>();
    List<SingleChooseBean>  jiageer = new ArrayList<>();
    List<SingleChooseBean>  jiagesan = new ArrayList<>();
    public   SingleChooseTvAdapter adapter8;
    List<SingleChooseBean>  da;
    @Override
    protected void initData() {
        super.initData();
        adapter8= new SingleChooseTvAdapter(R.layout.tv4);
        jiagerv.setAdapter(adapter8);
        jiagerv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        jiageyi.add(new SingleChooseBean("5000元以下","0","5000",true));
        jiageyi.add(new SingleChooseBean("5000-8000","5000","8000",false));
        jiageyi.add(new SingleChooseBean("8000元-1万","8000","10000",false));
        jiageyi.add(new SingleChooseBean("1万-1.2万","10000","12000",false));
        jiageyi.add(new SingleChooseBean("1.2万-1.5万","12000","15000",false));
        jiageyi.add(new SingleChooseBean("1.5万-2万","15000","20000",false));
        jiageyi.add(new SingleChooseBean("2万以上","20000","200000000",false));

        jiagesan.add(new SingleChooseBean("500元以下","0","500",true));
        jiagesan.add(new SingleChooseBean("500-1000元","500","1000",false));
        jiagesan.add(new SingleChooseBean("1000-1500元","1000","1500",false));
        jiagesan.add(new SingleChooseBean("1500-2000元","1500","2000",false));
        jiagesan.add(new SingleChooseBean("2000-3000元","2000","3000",false));
        jiagesan.add(new SingleChooseBean("3000元以上","3000","2000000",false));


        jiageer.add(new SingleChooseBean("50万以下","0","50",true));
        jiageer.add(new SingleChooseBean("50万-80万","50","80",false));
        jiageer.add(new SingleChooseBean("80万-90万","80","90",false));
        jiageer.add(new SingleChooseBean("90万-100万","90","100",false));
        jiageer.add(new SingleChooseBean("100万-150万","100","150",false));
        jiageer.add(new SingleChooseBean("150万-200万","150","200",false));
        jiageer.add(new SingleChooseBean("200万以上","200","200000000",false));
        //jiageer.add(new SingleChooseBean("2万以上","20000","200000000",false));
        current = jiageyi;
        adapter8.addData(jiageyi);
//        da = new ArrayList<>();
//        for (int i=0;i<15;i++){
//            SingleChooseBean bean = new SingleChooseBean();
//            bean.setContent(i+"");
//            da.add(bean);
//         }



        // adapte = new ShangPuXieAdapter(R.layout.me_paimai_item);
        CommonApi.getInstance().xiaji(getQuId(), CommonXieZiFragment.this, GETDATA, false);

        //  7 出售商铺
//        CommonApi.getInstance().index("7",getQuId(),page,business_id,price1
//                ,price2,null,null,null,
//                CommonXieZiFragment.this,LIST1);
//
//
//        // 13 出租商铺
//        CommonApi.getInstance().index("13",
//                getQuId(),page,business_id,price1
//                ,price2,null,null,null,
//                CommonXieZiFragment.this,LIST2);


        // 商铺新盘列表
        CommonApi.getInstance().indexnewhouse2(getQuId(), business_id, price1, price2, 2, page, null, null
                , CommonXieZiFragment.this, LIST);


//        CommonApi.getInstance().index(cate_id, getQuId(), page,
//                "", price1, price2, select1, yonghu, key,
//                CommonXieZiFragment.this, LIST);


        adapter1 = new XieZiAdapter1(R.layout.home_xinfang_item);
        adapter2 = new XieZiAdapter2(R.layout.home_xinfang_item);
        adapter3 = new XieZiAdapter3(R.layout.home_xinfang_item);


        recycle.setAdapter(adapter1);
        recycle2.setAdapter(adapter2);
        recycle3.setAdapter(adapter3);


        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycle2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycle3.setLayoutManager(new LinearLayoutManager(getActivity()));
        setKeJian(recycle, recycle2, recycle3);


    }

    public void setKeJian(View... args) {
        View tv0 = args[0];
        tv0.setVisibility(View.VISIBLE);

        for (int i = 1; i < args.length; i++) {
            args[i].setVisibility(View.GONE);
        }
    }


    private String cate_id = "13";


    public void choose(TextView... args) {

        Drawable whitebg = getResources().getDrawable(R.drawable.shape_lan_10);
        int pramy = getResources().getColor(R.color.qianse);

        int white = getResources().getColor(R.color.gray);
        // Drawable pramybg = getResources().getDrawable(R.drawable.shape_tuijian2);

        TextView tv0 = args[0];
        tv0.setTextColor(pramy);
        tv0.setBackground(whitebg);

        for (int i = 1; i < args.length; i++) {
            args[i].setTextColor(white);
            args[i].setBackground(null);
        }


        //textView.setTextColor(pramy);
        //textView.setBackground(whitebg);

//        textView1.setTextColor(white);
//        textView1.setBackground(pramybg);
//        textView2.setTextColor(white);
//        textView2.setBackground(pramybg);
    }

//    public void choose(TextView textView, TextView textView1, TextView textView2) {
//        int white = getResources().getColor(R.color.white);
//        Drawable whitebg = getResources().getDrawable(R.drawable.shape_tuijian);
//        int pramy = getResources().getColor(R.color.colorPrimary);
//        Drawable pramybg = getResources().getDrawable(R.drawable.shape_tuijian2);
//        textView.setTextColor(pramy);
//        textView.setBackground(whitebg);
//
//        textView1.setTextColor(white);
//        textView1.setBackground(pramybg);
//        textView2.setTextColor(white);
//        textView2.setBackground(pramybg);
//    }


    private int type = 0;

    private int postv = 0;

    @OnClick({R.id.xinfang, R.id.ershou, R.id.zulin, R.id.di1, R.id.di2, R.id.di3, R.id.di4, R.id.di5, R.id.jia1, R.id.jia2, R.id.jia3, R.id.jia4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xinfang:
                choose(xinfang, ershou, zulin);
                setKeJian(recycle, recycle2, recycle3);
                type = 0;
                shuaxindata();
                changeData();
                break;
            case R.id.ershou:
                choose(ershou, xinfang, zulin);
                setKeJian(recycle2, recycle, recycle3);
                type = 1;
                shuaxindata();
                changeData();
                break;
            case R.id.zulin:
                choose(zulin, xinfang, ershou);
                setKeJian(recycle3, recycle2, recycle);
                type = 2;
                shuaxindata();
                changeData();
                break;
            //  改变区域
            case R.id.di1:
                choose(di1, di2, di3, di4);
                setBusseid(di1);
                shuaxindata();
                postv = 0;
                break;
            case R.id.di2:
                choose(di2, di1, di3, di4);
                setBusseid(di2);
                shuaxindata();
                postv = 1;
                break;
            case R.id.di3:
                choose(di3, di2, di1, di4);
                shuaxindata();
                setBusseid(di3);
                postv = 2;
                break;
            case R.id.di4:
                choose(di4, di2, di3, di1);
                setBusseid(di4);
                postv = 3;
                shuaxindata();
                break;
            case R.id.di5:
                //选择数据
                alertWindow(view);
                shuaxindata();
                break;
            case R.id.jia1:
                choose(jia1, jia2, jia3, jia4);
                price1 = "0";
                price2 = "6000";
                shuaxindata();
                break;
            case R.id.jia2:
                price1 = "6000";
                price2 = "8000";
                choose(jia2, jia1, jia3, jia4);
                shuaxindata();
                break;
            case R.id.jia4:
                price1 = "10000";
                price2 = "1666666000";
                choose(jia4, jia2, jia3, jia1);
                shuaxindata();
                break;
            case R.id.jia3:
                price1 = "8000";
                price2 = "10000";
                choose(jia3, jia2, jia4, jia1);
                shuaxindata();
                break;

        }
    }


    private void changeData() {
        switch (type){
            case 0:
                current = jiageyi;
                break;
            case 1:
                current = jiageer;
                break;
            case 2:
                current = jiagesan;
                break;
                }
        adapter8.replaceData(current);
    }


    PopupWindow popupWindow;

    private void alertWindow(View view) {


        View vie = View.inflate(getActivity(), R.layout.menu_item33, null);
        popupWindow = new PopupWindow(getActivity());
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        // 背景的处理
        // setBackgroundAlpha(0.5f);//设置屏幕透明度


        RecyclerView recyclerView = vie.findViewById(R.id.rv);

        TvAdapter3 adapter = new TvAdapter3(R.layout.menu_item33_item);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (jiadao != null && jiadao.getData() != null) {
            adapter.addData(jiadao.getData());
        }

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.shouru:
                        if (popupWindow.isShowing()) {
                            popupWindow.dismiss();
                        }
//                          设置刷新数据

//                        显示一下数据
                        switch (postv) {
                            case 0:
                                di1.setText(jiadao.getData().get(position).getName());
                                break;
                            case 1:
                                di2.setText(jiadao.getData().get(position).getName());
                                break;
                            case 2:
                                di3.setText(jiadao.getData().get(position).getName());
                                break;
                            case 3:
                                di4.setText(jiadao.getData().get(position).getName());
                                break;
                        }

                        setBusseid((TextView) view);
                        shuaxindata();
                        break;
                }
            }
        });


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
                // setBackgroundAlpha(1.0f);
            }
        });
    }


    private void setBusseid(TextView di1) {
        if (jiadao != null && jiadao.getData() != null) {
            List<CityBean.DataBean> dat = jiadao.getData();
            for (CityBean.DataBean d : dat) {
                if (di1.getText().toString().trim().equals(d.getName())) {
                    business_id = d.getId();
                    break;
                }
            }
        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter8.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
               // switch ()
               SingleChooseBean singleChooseBean = null;
                switch (type){
                    case 0:
                        singleChooseBean =    jiageyi.get(position);
                        for(SingleChooseBean  bean:jiageyi ){
                            bean.setChoose(false);
                        }
                        jiageyi.get(position).setChoose(true);
                        break;
                    case 1:
                        singleChooseBean =  jiageer.get(position);
                        for(SingleChooseBean  bean:jiageer ){
                            bean.setChoose(false);
                        }
                        jiageer.get(position).setChoose(true);
                        break;
                    case 2:
                        singleChooseBean =  jiagesan.get(position);
                        for(SingleChooseBean  bean:jiagesan ){
                            bean.setChoose(false);
                        }
                        jiagesan.get(position).setChoose(true);
                        break;
                }
                adapter8.replaceData(current);
                price1 = singleChooseBean.getPrice1();
                price2 = singleChooseBean.getPrice2();
                shuaxindata();
            }
        });


        adapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), XinFangDetailActivity.class);
                intent.putExtra("id", totalxin.get(position).getId());
                startActivity(intent);
            }
        });


        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                // 商铺出售
                Intent intent = new Intent(getActivity(), XinPanDetailActivity.class);
                intent.putExtra("id", tempershou.data.get(position).getLife_id());
                intent.putExtra("cate_id", "7");
                startActivity(intent);

            }
        });


        adapter3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                // 商铺出租
                Intent intent = new Intent(getActivity(), XinPanDetailActivity.class);
                intent.putExtra("id", totalzulin.get(position).getLife_id());
                intent.putExtra("cate_id", "13");
                startActivity(intent);

            }
        });


        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                switch (type) {
                    case 0:
                        CommonApi.getInstance().indexnewhouse2(getQuId(), business_id, price1, price2, 2, ++page, null, null
                                , CommonXieZiFragment.this, MORE);
                        break;
                    case 1:
                        CommonApi.getInstance().index("7", getQuId(), ++page1, business_id, price1
                                , price2, null, null, null,
                                CommonXieZiFragment.this, MORE1);
                        break;
                    case 2:
                        CommonApi.getInstance().index("13",
                                getQuId(), ++page2, business_id, price1
                                , price2, null, null, null,
                                CommonXieZiFragment.this, MORE2);
                        break;
                }
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                switch (type) {
                    case 0:
                        CommonApi.getInstance().indexnewhouse2(getQuId(), business_id, price1, price2, 2, 1, null, null
                                , CommonXieZiFragment.this, SHUAXIN);
                        break;
                    case 1:
                        CommonApi.getInstance().index("7", getQuId(), 1, business_id, price1
                                , price2, null, null, null,
                                CommonXieZiFragment.this, SHUAXIN1);
                        break;
                    case 2:
                        CommonApi.getInstance().index("13",
                                getQuId(), 1, business_id, price1
                                , price2, null, null, null,
                                CommonXieZiFragment.this, SHUAXIN2);
                        break;
                }
            }
        });
    }


    //  列表数据
    private void shuaxindata() {
        switch (type) {
            case 0:
                CommonApi.getInstance().indexnewhouse2(getQuId(), business_id, price1, price2, 2, 1, null, null
                        , CommonXieZiFragment.this, SHUAXIN);
                break;
            case 1:
                CommonApi.getInstance().index("7", getQuId(), 1, business_id, price1
                        , price2, null, null, null,
                        CommonXieZiFragment.this, SHUAXIN1);
                break;
            case 2:
                CommonApi.getInstance().index("13",
                        getQuId(), 1, business_id, price1
                        , price2, null, null, null,
                        CommonXieZiFragment.this, SHUAXIN2);
                break;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder2 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder2.unbind();
    }
}
