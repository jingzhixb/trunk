package com.zhuye.ershoufang.data;

import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static com.zhuye.ershoufang.data.NetWorkUrl.NETWORKERROR;

/**
 * Created by Administrator on 2018/1/11 0011.
 */

public class MyObserver<T extends Base> implements Observer<T>   {

    private  Boolean isShowLoding =true;
    private BaseView baseView;
    private int requestcode;

    public  MyObserver(BaseView baseView, int requestcode) {

        this.baseView = baseView;
        this.requestcode = requestcode;
    }
    public MyObserver(BaseView baseView, int requestcode,Boolean isShowLoding) {
        this.baseView = baseView;
        this.requestcode = requestcode;
        this.isShowLoding = isShowLoding;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
      //  isShowLoding ? baseView.loding(): "";
        checkNetWork();
        if(isShowLoding){
            baseView.loding();
        }
    }

    private void checkNetWork() {

    }


    @Override
    public void onError(@NonNull Throwable e) {
        
        
        // // TODO: 2018/5/25 0025  错图提示

       // e instanceof ClassCastException;
       // base.setErrorcode();
        // 刷新时有问题
//        Base  base = new Base();;
//        base.setErrorcode(NETWORKERROR);
//        baseView.error(base);
        if(isShowLoding)
            baseView.finishLoding();
    }

    @Override
    public void onComplete() {
        //baseView.error();
        if(isShowLoding)
           baseView.finishLoding();
    }

    @Override
    public void onNext(T t) {
        //  状态码统一处理
        if (t.getCode()==200){
            baseView.success(requestcode,t);
//            if(t instanceof CommonListBean){
//                if(((CommonListBean) t).getData()==null || ((CommonListBean) t).getData().size()==0){
//                    baseView.empty();
//                    // 用于刷新时关闭刷新头
//                   //baseView.success(requestcode,t);
//                }else {
//                    baseView.success(requestcode,t);
//                }
//            }else {
//                baseView.success(requestcode,t);
//            }
        }else  {
//            if(t instanceof CommonListBean){
//                  if(((CommonListBean) t).getData()==null || ((CommonListBean) t).getData().size()==0){
//                      baseView.empty();
//                  }else {
//                      baseView.error(t);
//                  }
//            }

            // 288 登录时效
            baseView.error(t);
         }
        if(isShowLoding)
             baseView.finishLoding();
    }
}
