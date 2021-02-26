package com.braintreepayments.cardform.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.braintreepayments.cardform.C1011R;

public class ViewUtils {
    public static int dp2px(Context context, float f) {
        return Math.round(TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()));
    }

    public static boolean isDarkBackground(Activity activity) {
        int color = activity.getResources().getColor(C1011R.C1012color.bt_white);
        try {
            Drawable background = activity.getWindow().getDecorView().getRootView().getBackground();
            if (background instanceof ColorDrawable) {
                color = ((ColorDrawable) background).getColor();
            }
        } catch (Exception unused) {
        }
        return ((((double) Color.red(color)) * 0.2126d) + (((double) Color.green(color)) * 0.7152d)) + (((double) Color.blue(color)) * 0.0722d) < 128.0d;
    }
}
