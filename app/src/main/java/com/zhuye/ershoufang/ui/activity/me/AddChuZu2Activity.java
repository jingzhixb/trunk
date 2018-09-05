package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.ChuZuBean;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.bean.SelectBean2;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.CommonAddActivity;
import com.zhuye.ershoufang.utils.WindowUtils;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView;
import com.zhuye.ershoufang.weidtet.UpPhotoCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

import static com.zhuye.ershoufang.data.NetWorkUrl.FUKUANCODE;
import static com.zhuye.ershoufang.data.NetWorkUrl.SUOZAICODE;
import static com.zhuye.ershoufang.data.NetWorkUrl.YAFUCODE;
import static com.zhuye.ershoufang.data.NetWorkUrl.ZHUANGTAICODE;

public class AddChuZu2Activity extends CommonAddActivity implements UpPhotoCallBack {

    private static final int XIAJI = 145;
    private static final int QU = 102;
    private static final int JIEDAO = 103;
    private static final int PROVINCE = 101;
    private static final int TIJIAO = 104;
    private static final int SELECT = 108;
    private static final int JIAOTONG = 109;
    private static final int UP = 110;

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.mingcheng1)
    TextView mingcheng1;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.dianhuowu)
    LinearLayout dianhuowu;
    @BindView(R.id.zhongliang1)
    TextView zhongliang1;
    @BindView(R.id.shoujia)
    EditText shoujia;
    @BindView(R.id.zhongliangwu)
    TextView zhongliangwu;
    @BindView(R.id.zhongliang11)
    TextView zhongliang11;
    @BindView(R.id.shoujia1)
    EditText shoujia1;
    @BindView(R.id.dianzhongliang)
    RelativeLayout dianzhongliang;
    @BindView(R.id.shifa1)
    TextView shifa1;
    @BindView(R.id.mianji)
    EditText mianji;
    @BindView(R.id.mianjia)
    TextView mianjia;
    @BindView(R.id.dianshifa)
    RelativeLayout dianshifa;
    @BindView(R.id.xiaoqu)
    EditText xiaoqu;
    @BindView(R.id.louceng)
    MyInputView louceng;
    @BindView(R.id.wuyefei)
    MyInputView wuyefei;
    @BindView(R.id.gongzuowei)
    MyInputView gongzuowei;
    @BindView(R.id.fangwuleixing)
    TextView fangwuleixing;
    @BindView(R.id.fangjia1)
    TextView fangjia1;
    @BindView(R.id.fangjia)
    RelativeLayout fangjia;
    @BindView(R.id.yuegong1)
    TextView yuegong1;
    @BindView(R.id.yuegong)
    RelativeLayout yuegong;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.maidian)
    EditText maidian;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.dianhua)
    EditText dianhua;
    @BindView(R.id.xintai)
    EditText xintai;
    @BindView(R.id.cheliang1)
    TextView cheliang1;
    @BindView(R.id.cheliang2)
    EditText cheliang2;
    @BindView(R.id.diancheliang)
    RelativeLayout diancheliang;
    @BindView(R.id.neitu)
    RecyclerView neitu;
    @BindView(R.id.jiaotong)
    MySelectPhotoView jiaotong;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.weituo)
    Button weituo;
    @BindView(R.id.jiceng)
    EditText jiceng;
    @BindView(R.id.gong)
    EditText gong;
    @BindView(R.id.suozailouceng)
    TextView suozailouceng;
    @BindView(R.id.fukuanfangshi)
    TextView fukuanfangshi;

    @Override
    protected int getResId() {
        return R.layout.activity_add_chu_zu2;
    }

//    写字楼出租  发布成功   列表没数据

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
//            if (data != null) {
//                photos =
//                        data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
//                neituimg.clear();
//                neituimg.addAll(photos);
//                neituimg.add("");
//                adapter.addData(neituimg);
//            }
//        }

        ArrayList<String> photos = new ArrayList<>();
        if (data != null) {
            photos =
                    data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
        }
        switch (requestCode) {
            case JIAOTONG:
                jiaotong.setPhoto(photos);
                break;
        }
    }


    @Override
    public void success(ImgBean imgBean, int code) {
        switch (code) {
            case UP:
                tijiao();
                break;
        }
    }

    private void tijiao() {
        if (type != null && type.equals("2")) {
            CommonApi.getInstance().leaseedit(
                    getToken(), life_id,
                    getString(title), 12,
                    getIndex(xiaji, dizhi2.getText().toString().trim()),
                    getIndex(qu, dizhi3.getText().toString().trim()),
                    getIndex(jiedao, dizhi4.getText().toString().trim()),
                    longitude,//
                    latitude,
                    getString(maidian),
                    "",//
                    getString(lianxiren),
                    getString(dianhua),
                    getString(jiceng),//
                    getString(gong),//

                    getString(xiaoqu),
                    "",

                    getString(shoujia1),
                    wuyefei.getContent(),
                    getString(mianji),
                    "",
                    getIndex(suozai,suozailouceng),
                    "",
                    getIndex(fukuan,fukuanfangshi),//写字楼--付款方式
                    "",
                    "",
                    "",
                    "",
                    "",
                    getString(xintai),
                    "",
                    jiaotong.getPhoto2(),
                    "",
                    AddChuZu2Activity.this, TIJIAO
            );
        } else {
            CommonApi.getInstance().chuzufabu(
                    getToken(), "",
                    getString(title), 12,
                    getIndex(xiaji, dizhi2.getText().toString().trim()),
                    getIndex(qu, dizhi3.getText().toString().trim()),
                    getIndex(jiedao, dizhi4.getText().toString().trim()),
                    longitude,//
                    latitude,
                    getString(maidian),
                    "",//
                    getString(lianxiren),
                    getString(dianhua),
                    "",//
                    "",//
                    getString(xiaoqu),
                    "",
                    getString(shoujia1),
                    wuyefei.getContent(),
                    getString(mianji),
                    "",
                    getIndex(suozai,suozailouceng),
                    "",
                    getIndex(fukuan,fukuanfangshi),//写字楼--付款方式
                    "",
                    "",
                    "",
                    "",
                    "",
                    getString(xintai),
                    "",
                    jiaotong.getPhoto2(),
                    "",
                    AddChuZu2Activity.this, TIJIAO
            );
        }

    }


    @Override
    public void onError(String msg, int code) {

    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "新增写字楼");

    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().province(AddChuZu2Activity.this, PROVINCE, false);

        CommonApi.getInstance().sselect("12","select1",AddChuZu2Activity.this,SUOZAICODE,false);
        CommonApi.getInstance().sselect("12","select3",AddChuZu2Activity.this,FUKUANCODE,false);

        vie = View.inflate(AddChuZu2Activity.this, R.layout.picker, null);
        jiaotong.REQUESTCODE = JIAOTONG;

        type = getIntent().getStringExtra("type");
        life_id = getIntent().getStringExtra("id");
        if (type != null && type.equals("2")) {
            CommonApi.getInstance().leaseview(life_id, this, EDIT, false);
            setText(ttitle, "编辑写字楼");
        }
    }

    CityBean cityBean;
    CityBean xiaji;
    CityBean qu;
    CityBean jiedao;
    private int selectIndex;

    CommonObjectBean<ChuZuBean> zubean;

    CommonListBean<SelectBean2> suozai;
    CommonListBean<SelectBean2> fukuan;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case SUOZAICODE:
                suozai = (CommonListBean<SelectBean2>) base;
                break;
            case FUKUANCODE:
                fukuan = (CommonListBean<SelectBean2>) base;
                break;
                case EDIT:
                // 写字楼
                zubean = (CommonObjectBean<ChuZuBean>) base;

                title.setText(zubean.getData().getTitle());
                shoujia.setText(zubean.getData().getNum1());
                shoujia1.setText(zubean.getData().getNum1());// 月租金
                mianji.setText(zubean.getData().getNum3());
                xiaoqu.setText(zubean.getData().getText3());
                louceng.setContent(zubean.getData().getText1()); // 所在楼层
                wuyefei.setContent(zubean.getData().getNum2());
//                gongzuowei.setContent(zubean.getData().get);  // 工作人数
                // 省市区
                maidian.setText(zubean.getData().getAddr());
                lianxiren.setText(zubean.getData().getContact());
                dianhua.setText(zubean.getData().getMobile());

                xintai.setText(zubean.getData().getDetails());  // 房源描述


                List<ChuZuBean.PhotoBean> de = zubean.getData().getPhoto();
                List<String> tt = new ArrayList<>();
                for (ChuZuBean.PhotoBean d : de) {
                    tt.add(d.getPhoto());
                }
                // jiaotong.setPhoto2(tt);
                jiaotong.setPhoto2(tt);
                break;
            case PROVINCE:
                cityBean = (CityBean) base;
                break;
            case XIAJI:
                xiaji = (CityBean) base;
                break;

            case QU:
                qu = (CityBean) base;
                break;

            case JIEDAO:
                jiedao = (CityBean) base;
                break;
            case TIJIAO:
                toast(base.getMessage());
                Intent intent = new Intent(AddChuZu2Activity.this,ChuZuActivity.class);
                intent.putExtra("type","2");
                intent.putExtra("id","2");
                startActivity(intent);
                finish();
                break;
            case SELECT:
                //faBuSelectBean = (FaBuSelectBean) base;
                break;
        }
    }

    View vie;

    PopupWindow popupWindow;

    private void editLeiXing(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow = new PopupWindow(AddChuZu2Activity.this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        // 背景的处理
        WindowUtils.setBackgroundAlpha(AddChuZu2Activity.this, 0.5f);//设置屏幕透明度
        WheelView wheelView = vie.findViewById(R.id.wheel);
        TextView queding = vie.findViewById(R.id.queding);

        wheelView.setCyclic(false);

        final List<String> mOptionsItems = new ArrayList<>();

        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                if (selectIndex != -1) {
                    target.setText(mOptionsItems.get(selectIndex));
                    // 是省的类型  且选中状态
                    if (type == 6) {
                        CommonApi.getInstance().xiaji(getIndex(cityBean, mOptionsItems.get(selectIndex)), AddChuZu2Activity.this, XIAJI, false);
                    } else if (type == 7) {
                        CommonApi.getInstance().xiaji(getIndex(xiaji, mOptionsItems.get(selectIndex)), AddChuZu2Activity.this, QU, false);
                    } else if (type == 8) {
                        CommonApi.getInstance().xiaji(getIndex(qu, mOptionsItems.get(selectIndex)), AddChuZu2Activity.this, JIEDAO, false);

                    }
                }

            }
        });

        List<String> data = new ArrayList<>();
        switch (type) {
            case 1:
//                for (int i = 0; i < faBuSelectBean.getData().get房屋类型().size(); i++) {
//                    data.add(faBuSelectBean.getData().get房屋类型().get(i).getAttr_name());
//                }
                break;
            case 2:
//                for (int i = 0; i < faBuSelectBean.getData().get装修程度().size(); i++) {
//                    data.add(faBuSelectBean.getData().get装修程度().get(i).getAttr_name());
//                }
                break;
            case 3:
//                for (int i = 0; i < faBuSelectBean.getData().get年代().size(); i++) {
//                    data.add(faBuSelectBean.getData().get年代().get(i).getAttr_name());
//                }
                break;
            case 4:
//                for (int i = 0; i < faBuSelectBean.getData().get朝向().size(); i++) {
//                    data.add(faBuSelectBean.getData().get朝向().get(i).getAttr_name());
//                }
                break;
            case 6:
                if (cityBean == null) {
                    return;
                }

                if (cityBean.getData() == null) {
                    return;
                }

                for (int i = 0; i < cityBean.getData().size(); i++) {
                    data.add(cityBean.getData().get(i).getName());
                }
                break;
            case 7:
                if (xiaji == null) {
                    return;
                }
                if (xiaji.getData() == null) {
                    toast("没有市");
                    return;
                }
                for (int i = 0; i < xiaji.getData().size(); i++) {
                    data.add(xiaji.getData().get(i).getName());
                }
                break;
            case 8:
                if (qu == null) {
                    return;
                }

                if (qu.getData() == null) {
                    toast("没有县");
                    return;
                }
                if (qu == null) {
                    return;
                }
                for (int i = 0; i < qu.getData().size(); i++) {
                    data.add(qu.getData().get(i).getName());
                }
                break;

            case 9:
                if (jiedao == null) {
                    return;
                }

                if (jiedao.getData() == null) {
                    toast("没有街道");
                    return;
                }
                if (jiedao == null) {
                    return;
                }
                for (int i = 0; i < jiedao.getData().size(); i++) {
                    data.add(jiedao.getData().get(i).getName());
                }
                break;


            case 20:
                for (int i = 0; i < suozai.getData().size(); i++) {
                    data.add(suozai.getData().get(i).getAttr_name());
                }
                break;
            case 21:
                for (int i = 0; i < fukuan.getData().size(); i++) {
                    data.add(fukuan.getData().get(i).getAttr_name());
                }
                break;

        }

        mOptionsItems.addAll(data);
        wheelView.setAdapter(new ArrayWheelAdapter(mOptionsItems));
        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                // Toast.makeText(AddErShouActivity.this, "" + mOptionsItems.get(index), Toast.LENGTH_SHORT).show();
                selectIndex = index;
            }
        });
//        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                start(AddGongChangActivity.class);
//            }
//        });
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                WindowUtils.setBackgroundAlpha(AddChuZu2Activity.this, 1.0f);
            }
        });
    }

    @OnClick({R.id.suozailouceng,R.id.fukuanfangshi,R.id.back, R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.fabu, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.suozailouceng:

                if(suozai!=null&&suozai.getData()!=null){
                    editLeiXing((TextView) view, "请输入朝向", 20);
                }
                break;
            case R.id.fukuanfangshi:
                if(fukuan!=null&&fukuan.getData()!=null){
                    editLeiXing((TextView) view, "请输入朝向", 21);
                }
                break;
            case R.id.back:
                finish();
                break;
            case R.id.dizhi:
                if (cityBean == null) {
                    CommonApi.getInstance().province(AddChuZu2Activity.this, PROVINCE, false);
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 6);
                break;
            case R.id.dizhi2:
                if (xiaji == null) {
                    toast("请选择市");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 7);
                break;
            case R.id.dizhi3:
                if (qu == null) {
                    toast("请选择区");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 8);
                break;
            case R.id.dizhi4:
                if (jiedao == null) {
                    toast("请选择街道");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 9);
                break;
            case R.id.fabu:
                if (checkEmpty(title, "请输入标题") &&
                        checkEmpty(shoujia, "请输入日租金") &&
                        checkEmpty(shoujia1, "请输入月租金") &&
                        checkEmpty(mianji, "请输入面积") &&
                        checkEmpty(xiaoqu, "请输入楼盘名称") &&
//                        louceng.getString() &&
                        checkEmpty(jiceng, "请输入几层") &&
                        checkEmpty(gong, "请输入共几层") &&
                        wuyefei.getString() &&
                        gongzuowei.getString() &&
                        checkEql(dizhi, "请输入省份", "请输入省份") &&

                        checkEql(suozailouceng, "楼层", "请输入所在楼层") &&
                        checkEql(fukuanfangshi, "付款方式", "请输入付款方式") &&

                        checkEql(dizhi2, "请输入市", "请输入市") &&
                        checkEql(dizhi3, "请输入区", "请输入区") &&
                        checkEql(dizhi4, "请输入街道", "请输入街道") &&
                        checkEmpty(maidian, "请输入具体地址") &&
                        checkEmpty(lianxiren, "请输入联系人姓名") &&
                        checkEmpty(dianhua, "请输入联系人电话") &&
                        checkEmpty(xintai, "请输入房源描述") &&
                        jiaotong.hasPhoto()
                        ) {
                    jiaotong.upimg(this, UP);
                    mSearch.geocode(new GeoCodeOption()
                            .city(dizhi2.getText().toString())
                            .address(dizhi2.getText().toString() + dizhi3.getText().toString() + dizhi4.getText().toString()));
                }
                break;
            case R.id.weituo:
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
