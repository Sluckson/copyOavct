package lib.android.paypal.com.magnessdk.p059b;

import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: lib.android.paypal.com.magnessdk.b.a */
public final class C4823a {

    /* renamed from: a */
    public static final int f5531a = 0;

    /* renamed from: b */
    public static final int f5532b = 1;

    /* renamed from: c */
    public static final int f5533c = 2;

    /* renamed from: d */
    public static final int f5534d = 3;

    /* renamed from: e */
    private static final String f5535e = "****MAGNES DEBUGGING MESSAGE****";

    /* renamed from: f */
    private static boolean f5536f = Boolean.valueOf(System.getProperty("magnes.debug.mode", Boolean.FALSE.toString())).booleanValue();

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: lib.android.paypal.com.magnessdk.b.a$a */
    @interface C4824a {
    }

    private C4823a() {
    }

    /* renamed from: a */
    public static void m4653a(Class<?> cls, int i, String str) {
        boolean z = f5536f;
        if (!z) {
            return;
        }
        if (i == 0) {
            String simpleName = cls.getSimpleName();
            Log.d(simpleName, "****MAGNES DEBUGGING MESSAGE**** : " + str);
        } else if (i == 1) {
            String simpleName2 = cls.getSimpleName();
            Log.i(simpleName2, "****MAGNES DEBUGGING MESSAGE**** : " + str);
        } else if (i == 2) {
            String simpleName3 = cls.getSimpleName();
            Log.w(simpleName3, "****MAGNES DEBUGGING MESSAGE**** : " + str);
        } else if (i == 3 && z) {
            String simpleName4 = cls.getSimpleName();
            Log.e(simpleName4, "****MAGNES DEBUGGING MESSAGE**** : " + str);
        }
    }

    /* renamed from: a */
    public static void m4654a(Class<?> cls, int i, Throwable th) {
        boolean z = f5536f;
        if (!z) {
            return;
        }
        if (i == 0) {
            String simpleName = cls.getSimpleName();
            Log.d(simpleName, "****MAGNES DEBUGGING MESSAGE**** : " + th.getMessage(), th);
        } else if (i == 1) {
            String simpleName2 = cls.getSimpleName();
            Log.i(simpleName2, "****MAGNES DEBUGGING MESSAGE**** : " + th.getMessage(), th);
        } else if (i == 2) {
            String simpleName3 = cls.getSimpleName();
            Log.w(simpleName3, "****MAGNES DEBUGGING MESSAGE**** : " + th.getMessage(), th);
        } else if (i == 3 && z) {
            String simpleName4 = cls.getSimpleName();
            Log.e(simpleName4, "****MAGNES DEBUGGING MESSAGE**** : " + th.getMessage(), th);
        }
    }
}
