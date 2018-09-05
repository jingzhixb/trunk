package com.zhuye.ershoufang.ui.fragment.fabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.bean.SelectBean2;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.SelectCityActivity;
import com.zhuye.ershoufang.ui.activity.me.WeiTuoJingMaiActivity;
import com.zhuye.ershoufang.utils.CheckUtil;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView;
import com.zhuye.ershoufang.weidtet.UpPhotoCallBack;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

import static com.zhuye.ershoufang.data.NetWorkUrl.FANGWULEIXINGCODE;
import static com.zhuye.ershoufang.data.NetWorkUrl.ZHUANGXIUXINGK;

public class MaiFang2Activity extends SelectCityActivity implements UpPhotoCallBack {

    protected static final int FABA = 100;
    private static final int UPIMAG = 46545;
    private static final int UPIMAG2 = 45688;
    private static final int CHANGXINAG = 78454;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.zhongliang1)
    TextView zhongliang1;
    @BindView(R.id.dong)
    EditText dong;
    @BindView(R.id.danyuan)
    EditText danyuan;
    @BindView(R.id.shoujia)
    EditText shoujia;
    @BindView(R.id.zhongliangwu)
    TextView zhongliangwu;
    @BindView(R.id.dianzhongliang)
    RelativeLayout dianzhongliang;
    @BindView(R.id.jiceng)
    EditText jiceng;
    @BindView(R.id.gong)
    EditText gong;
    @BindView(R.id.fangwuleixing)
    TextView fangwuleixing;
    @BindView(R.id.zhuangxiuleixing)
    TextView zhuangxiuleixing;
    @BindView(R.id.cheliang1)
    TextView cheliang1;
    @BindView(R.id.cheliang2)
    EditText cheliang2;
    @BindView(R.id.diancheliang)
    RelativeLayout diancheliang;
    @BindView(R.id.neitu)
    RecyclerView neitu;
    @BindView(R.id.shipin)
    TextView shipin;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.weituo)
    Button weituo;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.dianhua)
    EditText dianhua;
    @BindView(R.id.jiaotong)
    MySelectPhotoView jiaotong;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.chaoxiang1)
    TextView chaoxiang1;
    @BindView(R.id.chaoxiang)
    RelativeLayout chaoxiang;

    @Override
    protected int getResId() {
        return R.layout.activity_mai_fang2;
    }

    String mianji;
    String xiaoqu;
    String shi;
    String ceng;
    String wei;
    String shouji;
    String xiaji;
    String qu;
    String jiedao;
    String xiangxi;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ArrayList<String> photos = new ArrayList<>();
        if (data != null) {
            photos =
                    data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
        }
        switch (requestCode) {
            case 105:
                jiaotong.setPhoto(photos);
                break;
        }
    }


    @Override
    protected void initData() {
        super.initData();

        setText(ttitle, "委托卖房");
        hide(subtitle);
        mianji = getIntent().getStringExtra("mianji");
        xiaoqu = getIntent().getStringExtra("xiaoqu");
        shi = getIntent().getStringExtra("shi");
        ceng = getIntent().getStringExtra("ceng");
        wei = getIntent().getStringExtra("wei");
        shouji = getIntent().getStringExtra("shouji");
        xiaji = getIntent().getStringExtra("xiaji");
        qu = getIntent().getStringExtra("qu");
        jiedao = getIntent().getStringExtra("jiedao");
        xiangxi = getIntent().getStringExtra("xiangxi");

        CommonApi.getInstance().select(3, MaiFang2Activity.this, SELECT, false);

        CommonApi.getInstance().sselect("4", "select2", MaiFang2Activity.this, ZHUANGXIUXINGK, false);
        CommonApi.getInstance().sselect("3", "select1", MaiFang2Activity.this, FANGWULEIXINGCODE, false);
        CommonApi.getInstance().sselect("3", "select2", MaiFang2Activity.this, CHANGXINAG, false);
        jiaotong.REQUESTCODE = 105;
//        intent.putExtra("xiaoqu",getString(xiaoqu));
//        intent.putExtra("shi",getString(shi));
//        intent.putExtra("ceng",getString(ceng));
//        intent.putExtra("wei",getString(wei));
//        intent.putExtra("shouji",getString(shouji));
//        intent.putExtra("xiaji",getIndex(xiaji, dizhi2.getText().toString().trim()));
//        intent.putExtra("qu",dizhi3.getText().toString().trim());
//        intent.putExtra("jiedao",dizhi4.getText().toString().trim());
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case CHANGXINAG:
                changxinag = (CommonListBean<SelectBean2>) base;
                break;
            case FABA:
                toast(base.getMessage());
                Intent intent = new Intent(MaiFang2Activity.this, WeiTuoJingMaiActivity.class);
                intent.putExtra("type", "2");
                intent.putExtra("id", "2");
                startActivity(intent);
                finish();
                break;
            case ZHUANGXIUXINGK:
                //toast(base.getMessage());
                zhuangxiuxingk = (CommonListBean<SelectBean2>) base;

                break;
            case FANGWULEIXINGCODE:
                //toast(base.getMessage());
                fangwuleixingcode = (CommonListBean<SelectBean2>) base;
                break;
        }
    }

    @OnClick({ R.id.chaoxiang1,R.id.back, R.id.fangwuleixing, R.id.zhuangxiuleixing, R.id.cheliang1, R.id.shipin, R.id.fabu, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.chaoxiang1:
                if(changxinag==null||changxinag.getData()==null){
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 24);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.fangwuleixing:
                if (fangwuleixingcode == null || fangwuleixingcode.getData() == null) {
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 21);
                break;
            case R.id.zhuangxiuleixing:
                //editLeiXingin((TextView) view, "请输入楼层单元", 5);
                if (zhuangxiuxingk == null || zhuangxiuxingk.getData() == null) {
                    return;
                }
//                editLeiXingin((TextView) view, "请输入装修状况", 2);
                editLeiXing((TextView) view, "请输入朝向", 20);
                break;
            case R.id.cheliang1:

                break;
            case R.id.shipin:

                break;
            case R.id.fabu:

                if (checkEmpty(dong, "请输入栋") && checkEmpty(danyuan, "请输入单元") &&
                        checkEmpty(shoujia, "请输入室") &&
                        checkEmpty(jiceng, "请输入楼层") &&
                        checkEmpty(gong, "请输入总楼层") &&
                        checkEmpty(lianxiren, "请输入联系人")
                        && CheckUtil.isMobile(MaiFang2Activity.this, getString(dianhua))) {

                    jiaotong.upimg(this, UPIMAG);


                }


                break;
            case R.id.weituo:


                if (checkEmpty(dong, "请输入栋") && checkEmpty(danyuan, "请输入单元") &&
                        checkEmpty(shoujia, "请输入室") &&
                        checkEmpty(jiceng, "请输入楼层") &&
                        checkEmpty(gong, "请输入总楼层") &&
                        checkEmpty(lianxiren, "请输入联系人")
                        && CheckUtil.isMobile(MaiFang2Activity.this, getString(dianhua))) {
                    jiaotong.upimg(this, UPIMAG2);

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

    @Override
    public void success(ImgBean imgBean, int code) {
        switch (code) {
            case UPIMAG:
                CommonApi.getInstance().wsell_fabu(getToken(), xiaoqu, mianji, shouji, shi,
                        ceng, wei, getString(dong) + "栋" + getString(danyuan) + "单元" + getString(shoujia) + "室",
                        getString(jiceng), getString(gong), getString(fangwuleixing), getString(zhuangxiuleixing),
                        getString(chaoxiang1), xiaji, qu, jiedao, getString(lianxiren),
                        getString(dianhua), "1", "2", jiaotong.getPhoto2(),
                        xiangxi, MaiFang2Activity.this
                        , FABA, true);
                break;

            case UPIMAG2:
                CommonApi.getInstance().wsell_fabu(getToken(), xiaoqu, mianji, shouji, shi,
                        ceng, wei, getString(dong) + "栋" + getString(danyuan) + "单元" + getString(shoujia) + "室",
                        getString(jiceng), getString(gong),
                        getString(fangwuleixing),
                        getString(zhuangxiuleixing),
                        getString(chaoxiang1),
                        xiaji, qu, jiedao, getString(lianxiren),
                        getString(dianhua), "0", "2", jiaotong.getPhoto2(),
                        xiangxi, MaiFang2Activity.this
                        , FABA, true);
                break;
        }
    }

    @Override
    public void onError(String msg, int code) {

    }
}
