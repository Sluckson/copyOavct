package com.salesforce.marketingcloud.analytics;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import java.util.List;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.analytics.e */
public final class C3913e {
    private C3913e() {
    }

    /* renamed from: a */
    public static String m2297a(List<C3910d> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (C3910d next : list) {
            if (next != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(next.mo56307a());
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String[] m2298a(String str) {
        return str.split("\\s*,\\s*");
    }
}
