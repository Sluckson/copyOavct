package com.salesforce.marketingcloud.p027e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.util.Collection;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.e.g */
public final class C4028g {
    private C4028g() {
    }

    /* renamed from: a */
    public static <T extends CharSequence> T m2761a(T t, String str) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException(str);
    }

    /* renamed from: a */
    public static <T> T m2762a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static <T extends Collection> T m2763a(T t, String str) {
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException(str);
    }

    /* renamed from: a */
    public static boolean m2764a(boolean z, String str) {
        if (z) {
            return true;
        }
        throw new IllegalArgumentException(str);
    }
}
