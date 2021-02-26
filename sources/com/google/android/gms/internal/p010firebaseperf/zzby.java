package com.google.android.gms.internal.p010firebaseperf;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.NonNull;
import java.net.URI;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzby */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzby {
    private static String[] zzic;

    public static boolean zza(@NonNull URI uri, @NonNull Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier <= 0) {
            return true;
        }
        Log.i("FirebasePerformance", "Detected domain whitelist, only whitelisted domains will be measured.");
        if (zzic == null) {
            zzic = resources.getStringArray(identifier);
        }
        for (String str : zzic) {
            String host = uri.getHost();
            if (host == null || host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
