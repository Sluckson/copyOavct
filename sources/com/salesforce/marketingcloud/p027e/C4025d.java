package com.salesforce.marketingcloud.p027e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Locale;
import java.util.UUID;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.e.d */
public final class C4025d {
    private C4025d() {
    }

    /* renamed from: a */
    public static String m2755a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("_et_default_shared_preferences", 0);
        String string = sharedPreferences.getString("id", (String) null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String e = C4029h.m2781e(String.format(Locale.ENGLISH, "%s%d", new Object[]{UUID.randomUUID().toString(), Long.valueOf(System.currentTimeMillis())}));
        sharedPreferences.edit().putString("id", e).apply();
        return e;
    }
}
