package com.salesforce.marketingcloud.p027e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.salesforce.marketingcloud.C4039h;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.e.e */
public final class C4026e {

    /* renamed from: a */
    private static final String f2923a = C4039h.m2810a((Class<?>) C4026e.class);

    /* renamed from: b */
    private static String f2924b;

    private C4026e() {
    }

    @NonNull
    /* renamed from: a */
    public static String m2756a(Context context) {
        if (!TextUtils.isEmpty(f2924b)) {
            return f2924b;
        }
        f2924b = "";
        if (context == null) {
            return f2924b;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            f2924b = String.format("%s : %s", new Object[]{packageInfo.versionName, Integer.valueOf(packageInfo.versionCode)});
        } catch (PackageManager.NameNotFoundException e) {
            C4039h.m2830e(f2923a, e, "Failed to get Application Version from the PackageManager.", new Object[0]);
        }
        return f2924b;
    }

    /* renamed from: a */
    public static boolean m2757a(@NonNull Context context, @NonNull String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    /* renamed from: a */
    public static boolean m2758a(PackageManager packageManager, Intent intent) {
        return packageManager.queryIntentServices(intent, 65536).size() > 0;
    }

    /* renamed from: b */
    public static boolean m2759b(PackageManager packageManager, Intent intent) {
        return packageManager.queryBroadcastReceivers(intent, 131072).size() > 0;
    }
}
