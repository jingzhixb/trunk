package com.zhuye.ershoufang.scale;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ScaleLinearLayout extends LinearLayout {
    public ScaleLinearLayout(Context context) {
        this(context,null);
    }

    public ScaleLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScaleLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
