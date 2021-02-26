package lib.android.paypal.com.magnessdk;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lib.android.paypal.com.magnessdk.p059b.C4823a;

/* renamed from: lib.android.paypal.com.magnessdk.c */
public final class C4825c {
    private C4825c() {
    }

    /* renamed from: a */
    static <T> T m4655a(Object obj, Class<T> cls) {
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return null;
        }
        return cls.cast(obj);
    }

    /* renamed from: a */
    static String m4656a(String str) {
        return new String(Base64.decode(str, 2), "UTF-8");
    }

    /* renamed from: a */
    static String m4657a(boolean z) {
        return z ? UUID.randomUUID().toString() : UUID.randomUUID().toString().replaceAll("-", "");
    }

    /* renamed from: a */
    public static void m4658a(Class<?> cls, Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C4823a.m4654a(cls.getClass(), 3, (Throwable) e);
            }
        }
    }

    /* renamed from: a */
    static boolean m4659a(PackageManager packageManager, Intent intent) {
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    /* renamed from: a */
    static boolean m4660a(Object obj) {
        if (obj == null) {
            return true;
        }
        return obj instanceof String ? ((String) obj).isEmpty() : obj instanceof Long ? ((Long) obj).longValue() == 0 : !(obj instanceof Integer) || ((Integer) obj).intValue() == 0;
    }
}
