package com.iaai.android.old.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iaai.android.old.utils.p016ui.ActivityHelper;

public class AppRater {
    public static void app_launched(Context context, Activity activity) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("apprater", 0);
        if (!sharedPreferences.getBoolean("dontshowagain", false)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            long j = sharedPreferences.getLong("launch_count", 0);
            Long valueOf = Long.valueOf(sharedPreferences.getLong("date_firstlaunch", 0));
            if (valueOf.longValue() == 0) {
                valueOf = Long.valueOf(System.currentTimeMillis());
                edit.putLong("date_firstlaunch", valueOf.longValue());
            }
            if (j >= 1 && System.currentTimeMillis() >= valueOf.longValue() + 0) {
                showRateDialog(context, edit, activity);
            }
            edit.commit();
        }
    }

    public static void showRateDialog(Context context, SharedPreferences.Editor editor, Activity activity) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText("If you enjoy using IAA Buyer, please take a moment to rate it. Thanks for your support!");
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setGravity(1);
        linearLayout.addView(textView);
        ActivityHelper.showRateMyAppDialog(context, activity, linearLayout, editor);
    }
}
