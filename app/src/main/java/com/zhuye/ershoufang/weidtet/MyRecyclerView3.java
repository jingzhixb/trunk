package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyRecyclerView3 extends RecyclerView {

    public MyRecyclerView3(Context context) {
        this(context,null);
    }

    public MyRecyclerView3(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRecyclerView3(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    Float startY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startY =  event.getY();
                Log.i("asss",startY-startY+"");
                break;

            case MotionEvent.ACTION_MOVE:
                Float moveY =   event.getY();
                if(startY==null){
                    startY=0f;
                }

                startY = moveY;
                Log.i("asss",moveY-startY+"");
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                Log.i("assss",layoutParams.height+"");
                layoutParams.height = (int) (layoutParams.height+moveY-startY);
                setLayoutParams(layoutParams);
//                try {
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                break;

            case MotionEvent.ACTION_UP:
                LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) getLayoutParams();
                Log.i("assss",layoutParams1.height+"");
                layoutParams1.height = 0;
                setLayoutParams(layoutParams1);
                break;
                }
  return super.onTouchEvent(event);
    }
}
