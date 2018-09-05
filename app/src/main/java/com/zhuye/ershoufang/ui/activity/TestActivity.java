package com.zhuye.ershoufang.ui.activity;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestActivity extends BaseActivity {


    @Override
    protected int getResId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initData() {
        super.initData();


        List<String>  dd = new ArrayList<>();
        dd.add("as");
        dd.add("as");
        dd.add("as");
        dd.add("as");
        dd.add("as");


        String aa[] = {"bb","cc"};

        Observable.fromArray(aa).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        Observable.fromIterable(dd).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable.fromArray(dd).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
//                .map(new Function<List<String>, String>() {
//                    @Override
//                    public String apply(List<String> strings) throws Exception {
//
//                        return null;
//                    }
//                }).subscribe(new Observer<String>() {
//                        @Override
//                        public void onSubscribe(Disposable d) {
//
//                        }
//
//                        @Override
//                        public void onNext(String s) {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                        }
//
//                        @Override
//                        public void onComplete() {
//
//                        }
//                    });
    }
}
