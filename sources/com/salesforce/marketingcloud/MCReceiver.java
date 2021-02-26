package com.salesforce.marketingcloud;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.p020b.C3929a;

@SuppressLint({"UnknownNullness"})
public class MCReceiver extends BroadcastReceiver {
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: a */
    public static final String f2149a = "com.salesforce.marketingcloud.WAKE_FOR_ALARM";

    /* renamed from: b */
    private static final String f2150b = "alarmName";

    /* renamed from: c */
    private static final String f2151c = C4039h.m2810a((Class<?>) MCReceiver.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static final Intent m2064a(@NonNull Context context, String str) {
        Intent intent = new Intent(context, MCReceiver.class);
        return intent.setAction(context.getApplicationContext().getPackageName() + "." + "com.salesforce.marketingcloud.WAKE_FOR_ALARM").putExtra(f2150b, str);
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            C4039h.m2820b(f2151c, "Action was empty %s", intent.toString());
            return;
        }
        String replaceFirst = action.replaceFirst(context.getApplicationContext().getPackageName() + ".", "");
        C4039h.m2817a(f2151c, "onReceive with action: %s", replaceFirst);
        char c = 65535;
        switch (replaceFirst.hashCode()) {
            case -1076576821:
                if (replaceFirst.equals("android.intent.action.AIRPLANE_MODE")) {
                    c = 2;
                    break;
                }
                break;
            case 487459773:
                if (replaceFirst.equals("com.salesforce.marketingcloud.WAKE_FOR_ALARM")) {
                    c = 5;
                    break;
                }
                break;
            case 502473491:
                if (replaceFirst.equals("android.intent.action.TIMEZONE_CHANGED")) {
                    c = 3;
                    break;
                }
                break;
            case 798292259:
                if (replaceFirst.equals("android.intent.action.BOOT_COMPLETED")) {
                    c = 1;
                    break;
                }
                break;
            case 1737074039:
                if (replaceFirst.equals("android.intent.action.MY_PACKAGE_REPLACED")) {
                    c = 4;
                    break;
                }
                break;
            case 1947666138:
                if (replaceFirst.equals("android.intent.action.ACTION_SHUTDOWN")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1 || c == 2 || c == 3 || c == 4) {
            C3929a a = C3929a.m2331a(replaceFirst);
            if (a != null) {
                C4040i.m2832a(context, a, intent.getExtras());
            }
        } else if (c == 5) {
            C4040i.m2834a(context, intent.getStringExtra(f2150b));
        }
    }
}
