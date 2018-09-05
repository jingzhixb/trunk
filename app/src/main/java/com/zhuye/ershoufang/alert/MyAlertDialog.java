package com.zhuye.ershoufang.alert;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

public class MyAlertDialog extends AlertDialog {


    protected MyAlertDialog(@NonNull Context context) {
        this(context,0);
    }

    protected MyAlertDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }


    public static class Builder{
        static int resolveDialogTheme(@NonNull Context context, @StyleRes int resid) {
            // Check to see if this resourceId has a valid package ID.
            if (((resid >>> 24) & 0x000000ff) >= 0x00000001) {   // start of real resource IDs.
                return resid;
            } else {
                TypedValue outValue = new TypedValue();
                context.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.alertDialogTheme, outValue, true);
                return outValue.resourceId;
            }
        }
//        public Builder(@NonNull Context context) {
//            this(context, resolveDialogTheme(context, 0));
//        }
//
//        public Builder(@NonNull Context context, @StyleRes int themeResId) {
//            P = new MyAlertController.AlertParams(new ContextThemeWrapper(
//                    context, resolveDialogTheme(context, themeResId)));
//            mTheme = themeResId;
//        }
    }
}
