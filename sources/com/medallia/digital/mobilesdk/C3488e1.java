package com.medallia.digital.mobilesdk;

import android.os.Environment;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.DecimalFormat;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.e1 */
class C3488e1 {
    C3488e1() {
    }

    /* renamed from: a */
    protected static double m652a(long j) {
        return ((double) j) / 1048576.0d;
    }

    /* renamed from: a */
    protected static long m653a(double d) {
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 0;
        }
        return (long) (d / 1048576.0d);
    }

    /* renamed from: a */
    protected static boolean m654a() {
        return Environment.isExternalStorageRemovable() && Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: b */
    protected static String m655b(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return String.format(Locale.US, "%s MB", new Object[]{decimalFormat.format(m653a(d))});
        }
        return String.format(Locale.US, "%d MB", new Object[]{0});
    }
}
