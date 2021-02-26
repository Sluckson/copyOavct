package com.google.android.gms.internal.p010firebaseperf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzca */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzca {
    private static Boolean zzij;

    public static boolean zzg(@NonNull Context context) {
        Boolean bool = zzij;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            zzij = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.d("isEnabled", valueOf2.length() != 0 ? "No perf logcat meta data found ".concat(valueOf2) : new String("No perf logcat meta data found "));
            return false;
        }
    }
}
