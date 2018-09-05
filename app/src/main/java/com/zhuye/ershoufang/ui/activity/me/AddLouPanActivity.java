package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.HuXingBean;
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.bean.LouBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.SelectCityActivity;
import com.zhuye.ershoufang.weidtet.DataBean;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyRecycleBean;
import com.zhuye.ershoufang.weidtet.MyRecycleView;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView2;
import com.zhuye.ershoufang.weidtet.MySelectTvView;
import com.zhuye.ershoufang.weidtet.MyTvSelectView;
import com.zhuye.ershoufang.weidtet.UpPhotoCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class AddLouPanActivity extends SelectCityActivity implements UpPhotoCallBack {

    private static final int GETDATA = 888;
    private static final int TIJIAO = 401;
    private static final int XIAOGUO = 402;
    private static final int SHIJING = 403;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.fangyuanleixing)
    MyTvSelectView fangyuanleixing;
    @BindView(R.id.fangyuanzhong)
    MyTvSelectView fangyuanzhong;
    @BindView(R.id.modi1)
    TextView modi1;
    @BindView(R.id.youshi)
    RelativeLayout youshi;
    @BindView(R.id.danjia)
    MyInputView danjia;
    @BindView(R.id.youhui)
    MyInputView youhui;
    @BindView(R.id.youhishijian)
    MyInputView youhishijian;
    @BindView(R.id.kaipanshijian)
    MyInputView kaipanshijian;
    @BindView(R.id.jiaofangshijian)
    MyInputView jiaofangshijian;
    @BindView(R.id.quyu)
    MyInputView quyu;
    @BindView(R.id.xianxidizhi)
    MyInputView xianxidizhi;
    @BindView(R.id.dianhua)
    MyInputView dianhua;
    @BindView(R.id.huxingrv)
    MyRecycleView huxingrv;
    @BindView(R.id.xiaoguo)
    MySelectPhotoView xiaoguo;
    @BindView(R.id.shijing)
    MySelectPhotoView shijing;
    @BindView(R.id.peitao)
    MySelectPhotoView peitao;
    @BindView(R.id.guihuatu)
    MySelectPhotoView guihuatu;
    @BindView(R.id.jiaotong)
    MySelectPhotoView jiaotong;
    @BindView(R.id.weituo)
    Button weituo;
    @BindView(R.id.youhiendtime)
    MyInputView youhiendtime;
    @BindView(R.id.title)
    MyInputView title;
    @BindView(R.id.mianjia)
    MyInputView mianji;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.peizhiba)
    MySelectTvView peizhiba;
    @BindView(R.id.addhuxing)
    Button addhuxing;

    @Override
    protected int getResId() {
        return R.layout.activity_add_lou_pan;
    }


    @Override
    protected void initView() {
        super.initView();
        // 同一个Tv 的不同显示
        //danjia.setText("单价","元/m²");
        xiaoguo.REQUESTCODE = 101;
        shijing.REQUESTCODE = 102;
        peitao.REQUESTCODE = 103;

        guihuatu.REQUESTCODE = 104;
        jiaotong.REQUESTCODE = 105;
        // TODO: 2018/5/14 0014


//        huxingrv.adapter2.bindToRecyclerView(huxingrv);
//
//        huxingrv.adapter2.getViewByPosition()

       // huxingrv.get

        // TODO: 2018/5/14 0014 获取adapter  中view的值
        //huxingrv.adapter2;
//        MySelectPhotoView view  = huxingrv.getChildAt(0).findViewById(R.id.xiaoguo);
//        //huxingrv.adapter2.getViewByPosition()
//       // MySelectPhotoView view = (MySelectPhotoView) huxingrv.adapter2.getViewByPosition(0,R.id.xiaoguo);
//        view.REQUESTCODE = 1000;


       // huxingrv.adapter2.get



        hide(subtitle);

    }




//    @OnClick(R.id.weituo)
//    public void onViewClicked() {
//        if (danjia.getString()) {
//            Toast.makeText(getApplicationContext(), danjia.getContent(), Toast.LENGTH_SHORT).show();
//        }
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("asd", requestCode + "");
        ArrayList<String> photos = new ArrayList<>();
        if (data != null) {
            photos =
                    data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
        }
        switch (requestCode) {
            case 101:
                xiaoguo.setPhoto(photos);
                break;
            case 102:
                shijing.setPhoto(photos);
                break;
            case 103:
                peitao.setPhoto(photos);
                break;
            case 104:
                guihuatu.setPhoto(photos);
                break;
            case 105:
                jiaotong.setPhoto(photos);
                break;
            case 0:
//                huxingrv.datas.get(0).setFilepath(photos);
//                huxingrv.adapter2.replaceData(huxingrv.datas);
//                 huxingrv.datas.get(0).getFilepath().clear();//.addAll(photos);//(photos);
//                 huxingrv.datas.get(0).getFilepath().addAll(photos);
//                  huxingrv.datas.get(0).setFilepath(photos);
//                  huxingrv.adapter2.replaceData(huxingrv.datas);
               // huxingrv.adapter2.notifyItemChanged(0);
                ((MySelectPhotoView2)das.get(0).getView(R.id.xiaoguo)).setPhoto3(photos);
                // ((MySelectPhotoView)das.get(0).getView(R.id.xiaoguo)).setPhoto3(photos);
                 //  通知
               // ((MySelectPhotoView)das.get(0).getView(R.id.xiaoguo)).adapter2.notifyDataSetChanged();
                break;
            case 1:
                ((MySelectPhotoView2)das.get(1).getView(R.id.xiaoguo)).setPhoto3(photos);
//                huxingrv.datas.get(1).setFilepath(photos);
//                huxingrv.adapter2.replaceData(huxingrv.datas);
             //   huxingrv.adapter2.notifyItemChanged(1);
               // ((MySelectPhotoView2)das.get(1).getView(R.id.xiaoguo)).setPhoto3(photos);
                break;
            case 2:
                huxingrv.datas.get(2).setFilepath(photos);
                // huxingrv.adapter2.replaceData(huxingrv.datas);
                huxingrv.adapter2.notifyItemChanged(2);
                //((MySelectPhotoView2)das.get(2).getView(R.id.xiaoguo)).setPhoto3(photos);
                break;
            case 3:
                huxingrv.datas.get(3).setFilepath(photos);
                // huxingrv.adapter2.replaceData(huxingrv.datas);
                huxingrv.adapter2.notifyItemChanged(3);
                //((MySelectPhotoView2)das.get(3).getView(R.id.xiaoguo)).setPhoto3(photos);
                break;
            case 4:
                huxingrv.datas.get(4).setFilepath(photos);
                // huxingrv.adapter2.replaceData(huxingrv.datas);
                huxingrv.adapter2.notifyItemChanged(4);
                //((MySelectPhotoView2)das.get(4).getView(R.id.xiaoguo)).setPhoto3(photos);
                break;

        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        danjia.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), danjia.getContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick({R.id.addhuxing,R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.back, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addhuxing:
                //toast("add");
                List<MyRecycleBean> dd =  huxingrv.datas;
                // 设置数据
                huxingrv.add();
                getViewHolder();
                break;
            case R.id.dizhi4:
                editLeiXing((TextView) view, "请输入朝向", 9);
                break;
            case R.id.dizhi:
                editLeiXing((TextView) view, "请输入朝向", 6);
                break;
            case R.id.dizhi2:
                editLeiXing((TextView) view, "请输入朝向", 7);
                break;
            case R.id.dizhi3:
                editLeiXing((TextView) view, "请输入朝向", 8);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.weituo:
                //toast(peizhiba.getPhoto());
//                List<String>  data = new ArrayList<>();
//                data.add("sss");
//                  data.add("sss");
//                data.add("sss");
//                data.add(1,"as");
//                System.out.print(data.size());
//                toast(data.size()+"");
//                huxingrv.isTian();

//                Log.i("asd", getIndex(xiaji, dizhi2.getText().toString().trim())+"ss"+
//                        getIndex(qu, dizhi3.getText().toString().trim())+"ss"+
//                        getIndex(jiedao, dizhi4.getText().toString().trim()));
//                upload();
          // Log.i("asdf",gethuXing2());// gethuXing2();
//               Log.i("asdf",peizhiba.getPhoto());// gethuXing2();
//
                if (fangyuanleixing.isChange() &&
                        fangyuanzhong.isChange()&&
                        title.getString()&&
                        mianji.getString()
                        && peizhiba.hasPhoto()&&
                        danjia.getString()&&
                        youhui.getString()&&
                        youhishijian.getString()&&
                        youhiendtime.getString()&&
                        kaipanshijian.getString()&&
                        jiaofangshijian.getString()&&
                        xianxidizhi.getString()&&
                        dianhua.getString() &&
                        xiaoguo.hasPhoto()&&
                        shijing.hasPhoto()&&
                        peitao.hasPhoto()&&
                        guihuatu.hasPhoto()&&
                        jiaotong.hasPhoto()&&
                        checkEql(dizhi, "请输入省份", "请输入省份") &&
                        checkEql(dizhi2, "请输入市", "请输入市") &&
                        checkEql(dizhi3, "请输入区", "请输入区") &&
                        checkEql(dizhi4, "请输入街道", "请输入街道")) {

                    mSearch.geocode(new GeoCodeOption()
                            .city(dizhi2.getText().toString())
                            .address(dizhi2.getText().toString()+dizhi3.getText().toString()+dizhi4.getText().toString()));

                    // 户型图片上传
                    upload();
                    for (int i=0;i<das.size();i++){
                        MySelectPhotoView2 mySelectPhotoView =  das.get(i).getView(R.id.xiaoguo);
                        EditText miaoshu =  das.get(i).getView(R.id.miaoshu);
                        MyInputView mianji =  das.get(i).getView(R.id.mianjinn);
                        MyInputView huxing =  das.get(i).getView(R.id.huxing);
                        MyInputView price =  das.get(i).getView(R.id.price);
                        if(huxing.getString()&&price.getString()){
                            if(mySelectPhotoView.hasPhoto()){
                                if( TextUtils.isEmpty(miaoshu.getText().toString().trim())){
                                    toast("请上传户型描述");
                                }else {
                                    if(mianji.getString()){
                                        //上传
                                        // huxingrv.isTian();

                                        }else {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    }

                    // 提交了两次
                xiaoguo.upimg(AddLouPanActivity.this, XIAOGUO);
                break;
        }
    }


    private void upload() {
        for (int i=0;i<das.size();i++){
            MySelectPhotoView2 mySelectPhotoView =  das.get(i).getView(R.id.xiaoguo);
//            EditText miaoshu =  das.get(i).getView(R.id.miaoshu);
//            MyInputView mianji =  das.get(i).getView(R.id.mianji);
//            MyInputView huxing =  das.get(i).getView(R.id.huxing);
            mySelectPhotoView.upimg(AddLouPanActivity.this,i);
        }
    }

    CommonObjectBean<LouBean> bean ;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case TIJIAO:
                toast(base.getMessage());
                finish();
                break;
            case GETDATA:
                bean = (CommonObjectBean<LouBean>) base;
                title.setContent(bean.getData().getTitle());
                mianji.setContent(bean.getData().getMianji());


                // TODO: 2018/6/13 0013
//                if(bean.getData().getHuxing()!=null&&bean.getData().getHuxing().size()>0){
//                    huxingrv.datas.get(0).setName(bean.getData().getHuxing().get(0).getHuxing());
//                }

                String leixing = bean.getData().getIs_onsale();
                if(leixing.equals("1")){
                    fangyuanleixing.setRightContent("期房未收");
                }else if(leixing.equals("2")){
                    fangyuanleixing.setRightContent("期房在售");
                }else if(leixing.equals("3")){
                    fangyuanleixing.setRightContent("期房已售完");
                }

                String zhoglei = bean.getData().getSelect();
                if(zhoglei.equals("1")){
                    fangyuanzhong.setRightContent("住宅");
                }else if(zhoglei.equals("2")){
                    fangyuanzhong.setRightContent("商铺");
                }else if(zhoglei.equals("3")){
                    fangyuanzhong.setRightContent("写字楼");
                }else if(zhoglei.equals("4")){
                    fangyuanzhong.setRightContent("工业厂房");
                    }

                    //配置
               // peizhiba.adapter2.addData(bean.getData().getPeizhi());

                peizhiba.setPhoto(bean.getData().getPeizhi());

                //单价
                danjia.setContent(bean.getData().getPrice());

                youhui.setContent(bean.getData().getYouhui());

//                danjia.setContent(bean.getData().getPrice());
//                youhui.setContent(bean.getData().getYouhui());
                youhishijian.setContent(bean.getData().getYouhui_starttime());
                youhiendtime.setContent(bean.getData().getYouhui_endtime());

                kaipanshijian.setContent(bean.getData().getKdate());
                jiaofangshijian.setContent(bean.getData().getJdate());

                dianhua.setContent(bean.getData().getMobile());
                xianxidizhi.setContent(bean.getData().getAddress());



//                String sheng_id = bean.getData().get

//                那加一个根据下级查父亲的id和nameba


                // TODO: 2018/6/20 0020  先不设置城市
//                   dizhi.setText(bean.getData().getPro_name());
//                //设置城市
//                dizhi2.setText(bean.getData().getCity_name());
//                dizhi3.setText(bean.getData().getArea_name());
//                dizhi4.setText(bean.getData().getBusiness_name());

                //设置户型
                if(bean.getData().getHuxing()!=null){
                    if(bean.getData().getHuxing().size()==1){
                         huxingrv.setData2(bean.getData().getHuxing());
                        }else {
                        int conut = bean.getData().getHuxing().size()-1;
                        for(int  i= 0;i<conut ;i++){
                            huxingrv.add();
                            huxingrv.setData2(bean.getData().getHuxing());
                          getViewHolder();
                        }
                    }
                }


                xiaoguo.setPhoto2(bean.getData().getXiaoguo());
                shijing.setPhoto2(bean.getData().getShijing());
                peitao.setPhoto2(bean.getData().getPeitao());
                guihuatu.setPhoto2(bean.getData().getGuihua());
                jiaotong.setPhoto2(bean.getData().getJiaotong());
                break;
        }
    }

    String id ;

    String type;
    @Override
    protected void initData() {
        super.initData();
        //1期房未收 2期房在售 3期房已售完
        List<DataBean> dataBeans = new ArrayList<>();
        DataBean dataBean = new DataBean(1, "期房未收");
        DataBean dataBean2 = new DataBean(2, "期房在售");
        DataBean dataBean3 = new DataBean(3, "期房已售完");

        type = getIntent().getStringExtra("type");
        setText(ttitle, "发布楼盘");
        if(type.equals("2")){
            id = getIntent().getStringExtra("id");
            setText(ttitle, "编辑楼盘");
            CommonApi.getInstance().newhouse_edit(getToken(), id, this, GETDATA);
        }

        dataBeans.add(dataBean);
        dataBeans.add(dataBean2);
        dataBeans.add(dataBean3);
        fangyuanleixing.setData(dataBeans);


        // 房源种类 1住宅 2商铺 3写字楼 4工业厂房
        List<DataBean> dataBeans1 = new ArrayList<>();
        DataBean dataBean1 = new DataBean(1, "住宅");
        DataBean dataBean22 = new DataBean(2, "商铺");
        DataBean dataBean33 = new DataBean(3, "写字楼");
        DataBean dataBean44 = new DataBean(4, "工业厂房");

        dataBeans1.add(dataBean1);
        dataBeans1.add(dataBean22);
        dataBeans1.add(dataBean33);
        dataBeans1.add(dataBean44);
        fangyuanzhong.setData(dataBeans1);

//        for (int i = 1; i< 4;i++){
//            DataBean dataBean = new DataBean()
//        }
       // int cout = huxingrv.adapter2.da.size();

//        mhan.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },1000);

       getViewHolder();
    }

    private void getViewHolder() {
        huxingrv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int cout = huxingrv.adapter2.da.size();
                huxingrv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
               // huxingrv.adapter2.da;
                das.clear();
                das.addAll( huxingrv.adapter2.da) ;
                //View view =  das.get(0).getView(R.id.xiaoguo);
                for(int i = 0;i<das.size();i++){
                    MySelectPhotoView2 mySelectPhotoView =  das.get(i).getView(R.id.xiaoguo);
                    mySelectPhotoView.REQUESTCODE = i;
                }
            }
        });
    }

    List<BaseViewHolder> das  =new ArrayList<>();
    private Handler mhan = new Handler();

    private List<HuXingBean> huXingBeans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    String ph0;
    String ph1;
    String ph2;
    String ph3;
    String ph4;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    public void success(ImgBean imgBean, int code) {
        switch (code) {
            case XIAOGUO:
                String p =  xiaoguo.getPhoto2();
                shijing.upimg(AddLouPanActivity.this, SHIJING);
                break;
            case SHIJING:
                peitao.upimg(AddLouPanActivity.this, PEITAO);
                break;
            case PEITAO:
                guihuatu.upimg(AddLouPanActivity.this, GUIHUATU);
                break;
            case GUIHUATU:
                jiaotong.upimg(AddLouPanActivity.this, JIAOTONG);
                break;
            case JIAOTONG:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tijiao();
                    }
                },1000);
                break;
            case 0:
                ph0 = ((MySelectPhotoView2) das.get(0).getView(R.id.xiaoguo)).getPhoto2();
                break;
            case 1:
                ph1 = ((MySelectPhotoView2) das.get(1).getView(R.id.xiaoguo)).getPhoto2();
                break;
            case 2:
                ph2 = ((MySelectPhotoView2) das.get(2).getView(R.id.xiaoguo)).getPhoto2();
                break;
            case 3:
                ph3 = ((MySelectPhotoView2) das.get(3).getView(R.id.xiaoguo)).getPhoto2();
                break;
            case 4:
                ph4 = ((MySelectPhotoView2) das.get(4).getView(R.id.xiaoguo)).getPhoto2();
                break;
        }
    }

    private void tijiao() {
        if(type.equals("1")){
            //提交
            CommonApi.getInstance().newhousefabu(getToken(),
                    getIndex(xiaji, dizhi2.getText().toString().trim()),
                    getIndex(qu, dizhi3.getText().toString().trim()),
                    getIndex(jiedao, dizhi4.getText().toString().trim()),
                    fangyuanzhong.getId() + "",
                    danjia.getContent(),
                    fangyuanleixing.getId() + "",
                    youhui.getContent(), youhishijian.getTime(),
                    youhiendtime.getTime(),
                    xianxidizhi.getContent(),
                    jiaofangshijian.getTime(),
                    kaipanshijian.getTime(),
                    peizhiba.getPhoto(),
                    longitude, latitude,// TODO: 2018/5/12 0012
                    gethuXing2(),
                    xiaoguo.getPhoto2(),
                    shijing.getPhoto2()
                    , peitao.getPhoto2(),
                    guihuatu.getPhoto2(),
                    jiaotong.getPhoto2()
                    , mianji.getContent(),
                    title.getContent(),
                    dianhua.getContent(),
                    AddLouPanActivity.this, TIJIAO);
        }else if(type.equals("2")){
            // 编辑
            CommonApi.getInstance().newhouse_sub(getToken(),id,
                    getIndex(xiaji, dizhi2.getText().toString().trim()),
                    getIndex(qu, dizhi3.getText().toString().trim()),
                    getIndex(jiedao, dizhi4.getText().toString().trim()),
                    fangyuanzhong.getId() + "",
                    danjia.getContent(),
                    fangyuanleixing.getId() + "",
                    youhui.getContent(),
                    youhishijian.getTime()==null || TextUtils.isEmpty( youhishijian.getTime())?bean.getData().getYouhui_starttime():youhishijian.getTime(),
                    youhiendtime.getTime()==null || TextUtils.isEmpty( youhiendtime.getTime())?bean.getData().getYouhui_endtime():youhiendtime.getTime(),
                    xianxidizhi.getContent(),
                    jiaofangshijian.getTime()==null || TextUtils.isEmpty( jiaofangshijian.getTime())?bean.getData().getJdate():jiaofangshijian.getTime(),
                    kaipanshijian.getTime()==null || TextUtils.isEmpty( kaipanshijian.getTime())?bean.getData().getKdate():kaipanshijian.getTime(),
                    peizhiba.getPhoto(),
                    longitude,
                    latitude,// TODO: 2018/5/12 0012
                    gethuXing2(),
                    xiaoguo.getPhoto2(),
                    shijing.getPhoto2()
                    , peitao.getPhoto2(),
                    guihuatu.getPhoto2(),
                    jiaotong.getPhoto2()
                    , mianji.getContent(),
                    title.getContent(),
                    dianhua.getContent(),
                    AddLouPanActivity.this, TIJIAO);
        }


    }


    private String gethuXing2() {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<das.size();i++){
            MySelectPhotoView2 mySelectPhotoView =  das.get(i).getView(R.id.xiaoguo);
            EditText miaoshu =  das.get(i).getView(R.id.miaoshu);
            MyInputView mianji =  das.get(i).getView(R.id.mianjinn);
            MyInputView huxing =  das.get(i).getView(R.id.huxing);
            MyInputView price =  das.get(i).getView(R.id.price);
            //mySelectPhotoView.upimg(AddLouPanActivity.this,i);
            if(i==das.size()-1){
                switch (i){
                    case 0:
                        HuXingBean bean = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        huXingBeans.add(bean);
                        builder.append(huxing.getContent()+","+ph0+","+mianji.getContent()+","+miaoshu.getText().toString().trim()
                                + ","+price.getContent());
                        break;
                    case 1:
                        HuXingBean bean1 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        huXingBeans.add(bean1);
                        builder.append(huxing.getContent()+","+ph1+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent());
                        break;
                    case 2:
                        HuXingBean bean2 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append(huxing.getContent()+","+ph2+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent());
                        huXingBeans.add(bean2);
                        break;
                    case 3:
                        HuXingBean bean3 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append(huxing.getContent()+","+ph3+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent());
                        huXingBeans.add(bean3);
                        break;
                    case 4:
                        HuXingBean bean4 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append(huxing.getContent()+","+ph4+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent());
                        huXingBeans.add(bean4);
                        break;
                }
            }else {
                switch (i){
                    case 0:
                        HuXingBean bean = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        huXingBeans.add(bean);
                        builder.append(huxing.getContent()+","+ph0+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent()+"|");
                        break;
                    case 1:
                        HuXingBean bean1 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        huXingBeans.add(bean1);
                        builder.append(huxing.getContent()+","+ph1+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent()+"|");
                        break;
                    case 2:
                        HuXingBean bean2 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append(huxing.getContent()+","+ph2+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent()+"|");
                        huXingBeans.add(bean2);
                        break;
                    case 3:
                        HuXingBean bean3 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append(huxing.getContent()+","+ph3+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent()+"|");
                        huXingBeans.add(bean3);
                        break;
                    case 4:
                        HuXingBean bean4 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append(huxing.getContent()+","+ph4+","+mianji.getContent()+","+miaoshu.getText().toString().trim() + ","+price.getContent()+"|");
                        huXingBeans.add(bean4);
                        break;
                }
            }


        }
        return builder.toString();
    }


    private String gethuXing() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i=0;i<das.size();i++){
            MySelectPhotoView2 mySelectPhotoView =  das.get(i).getView(R.id.xiaoguo);
            EditText miaoshu =  das.get(i).getView(R.id.miaoshu);
            MyInputView mianji =  das.get(i).getView(R.id.mianjinn);
            MyInputView huxing =  das.get(i).getView(R.id.huxing);
            MyInputView price =  das.get(i).getView(R.id.price);
            //mySelectPhotoView.upimg(AddLouPanActivity.this,i);
            if(i==das.size()-1){
                switch (i){
                    case 0:
                        HuXingBean bean = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        huXingBeans.add(bean);
                        builder.append("{"+huxing.getContent()+","+ph0+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"}");
                        break;
                    case 1:
                        HuXingBean bean1 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        huXingBeans.add(bean1);
                        builder.append("{"+huxing.getContent()+","+ph1+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"}");
                        break;
                    case 2:
                        HuXingBean bean2 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append("{"+huxing.getContent()+","+ph2+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"}");
                        huXingBeans.add(bean2);
                        break;
                    case 3:
                        HuXingBean bean3 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append("{"+huxing.getContent()+","+ph3+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"}");
                        huXingBeans.add(bean3);
                        break;
                    case 4:
                        HuXingBean bean4 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append("{"+huxing.getContent()+","+ph4+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"}");
                        huXingBeans.add(bean4);
                        break;
                }
            }else {
                switch (i){
                    case 0:
                        HuXingBean bean = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        huXingBeans.add(bean);
                        builder.append("{"+huxing.getContent()+","+ph0+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"},");
                        break;
                    case 1:
                        HuXingBean bean1 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        huXingBeans.add(bean1);
                        builder.append("{"+huxing.getContent()+","+ph1+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+"},");
                        break;
                    case 2:
                        HuXingBean bean2 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append("{"+huxing.getContent()+","+ph2+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"},");
                        huXingBeans.add(bean2);
                        break;
                    case 3:
                        HuXingBean bean3 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append("{"+huxing.getContent()+","+ph3+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"},");
                        huXingBeans.add(bean3);
                        break;
                    case 4:
                        HuXingBean bean4 = new HuXingBean(huxing.getContent(),ph0,mianji.getContent(),miaoshu.getText().toString().trim());
                        builder.append("{"+huxing.getContent()+","+ph4+","+mianji.getContent()+","+miaoshu.getText().toString().trim()+
                                ","+price.getContent()+"},");
                        huXingBeans.add(bean4);
                        break;
                }
            }


        }
        builder.append("]");
        return builder.toString();
    }

    private static final int PEITAO = 404;
    private static final int GUIHUATU = 405;
    private static final int JIAOTONG = 406;

    @Override
    public void onError(String msg, int code) {

    }
}
