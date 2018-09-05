package com.zhuye.te.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class MyRecycleview extends RecyclerView {
    public MyRecycleview(Context context) {
        this(context,null);
    }

    public MyRecycleview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRecycleview(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
