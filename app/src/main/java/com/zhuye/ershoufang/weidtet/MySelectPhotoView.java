package com.zhuye.ershoufang.weidtet;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.DensityUtil;
import com.zhuye.ershoufang.utils.FilesUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.PhotoPicker;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class MySelectPhotoView extends LinearLayout {
    public int REQUESTCODE = 100 ;

    public MySelectPhotoView(Context context) {
        this(context,null);
    }

    public MySelectPhotoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    private Context context;
    TextView title;
    RecyclerView recyclerView;
    ImageView add;
    ImageView add2;
    TextView addname;
   public   ImageAdapter2 adapter2;
    LinearLayout containers;
    String addna;
    private int linecount = 4;
    public MySelectPhotoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MySelectPhotoView);

        this.context = context;
        int resid =  typedArray.getResourceId(R.styleable.MySelectPhotoView_resids,0);
        String titl = typedArray.getString(R.styleable.MySelectPhotoView_title);
        addna  = typedArray.getString(R.styleable.MySelectPhotoView_addname);
        typedArray.recycle();

        resid = resid==0?R.layout.selectphoto:resid;
        View view = LayoutInflater.from(context).inflate(resid,null);
        title = view.findViewById(R.id.title);
        recyclerView = view.findViewById(R.id.photocontainer);
        add = view.findViewById(R.id.add);
        add2 = view.findViewById(R.id.add2);
        addname = view.findViewById(R.id.addname);
        containers = view.findViewById(R.id.containers);

        title.setText(titl);
        addname.setText(addna);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        addView(view,params);
        adapter2 = new ImageAdapter2(R.layout.image2);

        recyclerView.setAdapter(adapter2);

        // TODO: 2018/5/11 0011 无法控制recycleview 的高度
        MyGridLayoutManager myGridLayoutManager = new MyGridLayoutManager(context,linecount);
        recyclerView.setLayoutManager(myGridLayoutManager);
        myGridLayoutManager.setScrollEnabled(false);

        initListener();


    }

    private void initListener() {
        adapter2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if(onImageCliek!=null)
                onImageCliek.onItemChildClick(view,position);
                switch (view.getId()){
                    case R.id.delete:
                        delete(position);
                        break;
                }
            }
        });

        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(onImageCliek!=null)
                onImageCliek.onItemClick(view,position);


            }
        });


        // TODO: 2018/5/11 0011
       // ((Activity) context).onActivityReenter();

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //onImageCliek.onAddClick(view);
                // 判断是否有数量约束
//                if(photos.size()>=imgcount){
//                    Toast.makeText(context,"最多选择"+imgcount+"张图片",Toast.LENGTH_SHORT).show();
//                    return;
//                }
              selectPhoto();
            }
        });

        containers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               // onImageCliek.onAddClick(view);
//                if(photos.size()>=imgcount){
//                    Toast.makeText(context,"最多选择"+imgcount+"张图片",Toast.LENGTH_SHORT).show();
//                    return;
//                }
                selectPhoto();
            }
        });
    }

    private void delete(int position) {

        if(photos.size()>0){
            photos.remove(position);
            adapter2.replaceData(photos);
            Log.i("ssss", adapter2.getItemCount()+"ss"+photos.size());

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) containers.getLayoutParams();

            int lines = photos.size() / linecount;
            int line = photos.size() % linecount;

            if(photos.size()==0){
                add.setVisibility(VISIBLE);
                recyclerView.setVisibility(INVISIBLE);
                lines = 0;
                line = 1;
                params.topMargin = DensityUtil.dip2px(context,5+lines*70);
                params.leftMargin = DensityUtil.dip2px(context,10+line*80);
            }else {
                add.setVisibility(INVISIBLE);
                recyclerView.setVisibility(VISIBLE);
                params.topMargin = DensityUtil.dip2px(context,5+lines*70);
                params.leftMargin = DensityUtil.dip2px(context,10+line*80);
            }
//        params.leftMargin = 10+line*70;
//        params.topMargin = 30+lines*70;

            containers.setLayoutParams(params);

        }
    }

    public int imgcount = 6;

    private void selectPhoto() {
        if(photos!=null&&photos.size()>=6){
            Toast.makeText(context,"最多选择六张图片",Toast.LENGTH_SHORT).show();
            return;
        }
        PhotoPicker.builder()
                .setPhotoCount(imgcount)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(false)
                .start((Activity) context, REQUESTCODE);
    }

    private List<String>  photos = new ArrayList<>();


    public void setPhoto2(List<String> photo){


        List<String> tempphoto = new ArrayList<>();

        //  添加图片  // TODO: 2018/6/10 0010 xianbutianjia
       // totalimg.addAll(photo);
        if(photo==null||photo.size()==0){
            return;
        }
        for(String item: photo){
            tempphoto.add(NetWorkUrl.IMAGEURL+item);
        }
        adapter2.addData(tempphoto);
        photos.addAll(tempphoto);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) containers.getLayoutParams();

        int lines = photos.size() / linecount;
        int line = photos.size() % linecount;

        if(photos.size()==0){
            add.setVisibility(VISIBLE);
            recyclerView.setVisibility(INVISIBLE);
            lines = 0;
            line = 1;
            params.topMargin = DensityUtil.dip2px(context,5+lines*70);
            params.leftMargin = DensityUtil.dip2px(context,10+line*80);
        }else {
            add.setVisibility(INVISIBLE);
            recyclerView.setVisibility(VISIBLE);
            params.topMargin = DensityUtil.dip2px(context,5+lines*70);
            params.leftMargin = DensityUtil.dip2px(context,10+line*80);
        }
//        params.leftMargin = 10+line*70;
//        params.topMargin = 30+lines*70;

        containers.setLayoutParams(params);
    }

    public void setPhoto3(List<String> photo){
        int count = adapter2.getItemCount();
        List<String> temp = new ArrayList<>();
        if(photo.size()>(6-count)){
            for(int i=0;i<6-count;i++){
                temp.add(photo.get(i));
            }
            adapter2.addData(temp);
            photos.addAll(temp);
        }else {
            photos.addAll(photo);
            adapter2.replaceData(photos);

        }

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) containers.getLayoutParams();

        int lines = photos.size() / linecount;
        int line = photos.size() % linecount;

        if(photos.size()==0){
            add.setVisibility(VISIBLE);
            recyclerView.setVisibility(INVISIBLE);
            lines = 0;
            line = 1;
            params.topMargin = DensityUtil.dip2px(context,5+lines*70);
            params.leftMargin = DensityUtil.dip2px(context,10+line*80);
        }else {
            add.setVisibility(INVISIBLE);
            recyclerView.setVisibility(VISIBLE);
            params.topMargin = DensityUtil.dip2px(context,5+lines*70);
            params.leftMargin = DensityUtil.dip2px(context,10+line*80);
        }
//        params.leftMargin = 10+line*70;
//        params.topMargin = 30+lines*70;

        containers.setLayoutParams(params);
        adapter2.notifyDataSetChanged();
    }

    public void setPhoto(List<String> photo){
        int count = adapter2.getItemCount();
        List<String> temp = new ArrayList<>();
        if(photo.size()>(6-count)){
            for(int i=0;i<6-count;i++){
                temp.add(photo.get(i));
            }
            adapter2.addData(temp);
            photos.addAll(temp);
        }else {
            adapter2.addData(photo);
            photos.addAll(photo);
        }

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) containers.getLayoutParams();

        int lines = photos.size() / linecount;
        int line = photos.size() % linecount;

        if(photos.size()==0){
            add.setVisibility(VISIBLE);
            recyclerView.setVisibility(INVISIBLE);
            lines = 0;
            line = 1;
            params.topMargin = DensityUtil.dip2px(context,5+lines*70);
            params.leftMargin = DensityUtil.dip2px(context,10+line*80);
        }else {
            add.setVisibility(INVISIBLE);
            recyclerView.setVisibility(VISIBLE);
            params.topMargin = DensityUtil.dip2px(context,5+lines*70);
            params.leftMargin = DensityUtil.dip2px(context,10+line*80);
        }
//        params.leftMargin = 10+line*70;
//        params.topMargin = 30+lines*70;

        containers.setLayoutParams(params);
    }

    private  OnImageCliek onImageCliek;
    public void setOnImageCliek(OnImageCliek onImageCliek){
        this.onImageCliek = onImageCliek;
    }



    public interface OnImageCliek{
         void onItemClick( View view, int position);
         void onItemChildClick(View view, int position);
         //void onAddClick(View view);
    }

    public Boolean hasPhoto(){
        if(photos.size()==0){
            Toast.makeText(context,"请"+addna,Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
       //return photos.size()!=0;
    }


    ImgBean imgBeanhuanjing;

    List<String>  totalimg = new ArrayList<>();

    /**
     *  重写判断是都需要上传  不同源数据的处理
     * @param upPhotoCallBack
     * @param code
     */
    public void upimg(UpPhotoCallBack upPhotoCallBack,int code) {
        List<File> data = new ArrayList<>();
        totalimg.clear();
        if (photos != null && photos.size() > 0) {
            for (String item : photos) {
                if(item.startsWith("htt")){
                    //
                    totalimg.add(item);
                }else {
                    data.add(FilesUtil.getSmallBitmap(context, item));
                }
            }
//            List<File> data = new ArrayList<>();
//            for (String item : photos) {
//                data.add(FilesUtil.getSmallBitmap(context, item));
//            }
            if(data.size()>0){
                OkGo.<String>post(NetWorkUrl.BASE + NetWorkUrl.IMG).params("token2", ((BaseActivity) context).getToken())
                        .addFileParams("file[]", data).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        // Log.i("ad",response.body());
                        imgBeanhuanjing = new Gson().fromJson(response.body(), ImgBean.class);
                        //提交了两次;
                        upPhotoCallBack.success(imgBeanhuanjing,code);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        // Log.i("ad",response.body());
                        upPhotoCallBack.onError(response.message(),code);
                    }
                });
            }else {
                if(totalimg.size()>0){
                    upPhotoCallBack.success(null,code);
                }
            }

        }else {
            Toast.makeText(context,"请"+addna,Toast.LENGTH_SHORT).show();
        }
    }




    public String getPhoto2(){
        List<String>  temp = new ArrayList<>();
        if(imgBeanhuanjing!=null){
            temp.addAll(imgBeanhuanjing.getData().getPhoto());
        }
        temp.addAll(totalimg);
        return arraytoString(temp) ;
    }

    public String getPhoto(){
        return arraytoString(photos);
    }

    public List<String> getPhotoList(){
        return photos;
    }
    private String arraytoString(List<String> photo) {
        StringBuilder buffer = new StringBuilder();



        for (int i = 0; i < photo.size() - 1; i++) {
            String item = photo.get(i);
            if(item.contains("http://jd.zyeo.net/attachs/")){
               item =  item.replace("http://jd.zyeo.net/attachs/","");
            }
            buffer.append(item);
            buffer.append(",");
        }
        String firstorlast = photo.get(photo.size() - 1);
        if(firstorlast.contains("http://jd.zyeo.net/attachs/")){
            firstorlast =   firstorlast.replace("http://jd.zyeo.net/attachs/","");
        }
        buffer.append(firstorlast);
        return buffer.toString();
    }


}
