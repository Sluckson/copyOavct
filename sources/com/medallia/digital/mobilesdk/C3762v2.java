package com.medallia.digital.mobilesdk;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;

/* renamed from: com.medallia.digital.mobilesdk.v2 */
class C3762v2 {

    /* renamed from: a */
    private static final String f1953a = "UTF-8";

    C3762v2() {
    }

    /* renamed from: a */
    protected static String m1784a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return m1785b(str.split("\\.")[0]);
        } catch (UnsupportedEncodingException | ArrayIndexOutOfBoundsException e) {
            Log.w(C3762v2.class.getSimpleName(), e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private static String m1785b(String str) {
        try {
            return new String(Base64.decode(str, 8), "UTF-8");
        } catch (Exception e) {
            Log.w(C3762v2.class.getSimpleName(), e.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    protected static String m1786c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return m1785b(str.split("\\.")[1]);
        } catch (UnsupportedEncodingException | ArrayIndexOutOfBoundsException e) {
            Log.w(C3762v2.class.getSimpleName(), e.getMessage());
            return null;
        }
    }
}
