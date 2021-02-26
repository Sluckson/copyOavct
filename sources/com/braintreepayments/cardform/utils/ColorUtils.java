package com.braintreepayments.cardform.utils;

import android.app.Activity;
import android.util.TypedValue;

public class ColorUtils {
    public static int getColor(Activity activity, String str, int i) {
        TypedValue typedValue = new TypedValue();
        try {
            if (activity.getTheme().resolveAttribute(activity.getResources().getIdentifier(str, "attr", activity.getPackageName()), typedValue, true)) {
                return typedValue.data;
            }
        } catch (Exception unused) {
        }
        return activity.getResources().getColor(i);
    }
}
